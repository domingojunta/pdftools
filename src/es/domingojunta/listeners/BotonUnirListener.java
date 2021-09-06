package es.domingojunta.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.UnirPanel;
import es.domingojunta.tools.OperacionesConPdf;




public class BotonUnirListener implements ActionListener {

	
	private HomeFrame homeFrame;
	private UnirPanel unirPanel;
	
	public BotonUnirListener (UnirPanel unirPanel) {
		
		this.homeFrame = unirPanel.getHomeFrame();
		this.unirPanel = unirPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		OperacionesConPdf unirFicheros = new OperacionesConPdf();
		
		StringBuffer nombreArchivoBuffer = new StringBuffer();
		
		nombreArchivoBuffer.append(homeFrame.getDirectorioDeTrabajo());
		nombreArchivoBuffer.append(File.separator);
		nombreArchivoBuffer.append(unirPanel.getTextFieldNombreArchivo().getText().trim());
		
		String comentario = unirPanel.getTextAreaComentarioNuevoArchivo().getText().trim();
		
		if (!comentario.equals("")) {
			
			nombreArchivoBuffer.append(" # ");
			nombreArchivoBuffer.append(comentario);
		}
		
		String nombreArchivoString = nombreArchivoBuffer.toString();
		
		if (nombreArchivoString.length()>251) {
			
			nombreArchivoString = nombreArchivoString.substring(0, 251);
		}
		
		nombreArchivoString = nombreArchivoString + ".pdf";
		
		Boolean resultado = unirFicheros.unirficheros(unirPanel.getFicherosSeleccionadosOrdenados(),nombreArchivoString);
		
		if (resultado) {
			
			homeFrame.getMenuCentral().mostrarUnirPanel();
			homeFrame.repaint();
		}
	}

}
