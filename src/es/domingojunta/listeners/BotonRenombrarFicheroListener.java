package es.domingojunta.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.MenuCentralPanel;
import es.domingojunta.panels.NombrarArchivoPanel;
import es.domingojunta.panels.SeleccionarDirectorioPanel;
import es.domingojunta.panels.UnirPanel;
import es.domingojunta.tools.OperacionesConFicheros;

public class BotonRenombrarFicheroListener implements ActionListener {

	private HomeFrame homeFrame;
	private NombrarArchivoPanel panel;
	
	
	public BotonRenombrarFicheroListener(NombrarArchivoPanel panel) {
		
		this.homeFrame = panel.getHomeFrame();
		this.panel = panel;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("Se ha pulsado el botón renombrar...");
		File currentDirectory = new File(homeFrame.getDirectorioDeTrabajo());
		String separador = File.separator;
		StringBuffer nombreBuffer = new StringBuffer();
		nombreBuffer.append(currentDirectory);
		nombreBuffer.append(separador);
		nombreBuffer.append(panel.getTextFieldNombreArchivo().getText());
		String comentario = panel.getTextAreaComentarioArchivo().getText();
		if (!comentario.equals("")) {
			nombreBuffer.append(" # ");
			nombreBuffer.append(comentario);
		}
		
		String nombreNuevoParaArchivo = nombreBuffer.toString();
		
		if (nombreNuevoParaArchivo.length()>250) {
			
			nombreNuevoParaArchivo = nombreNuevoParaArchivo.substring(0,250);
		} 
		
		nombreNuevoParaArchivo = nombreNuevoParaArchivo+".pdf";
		
		File oldFile = panel.getFicheroSeleccionadoParaRenombrarlo();
		
		OperacionesConFicheros operacionesConFicheros = new OperacionesConFicheros();
		//System.out.println("El nombre del archivo a crear es: "+nombreNuevoParaArchivo);
		boolean resultado = operacionesConFicheros.renombrarFichero(oldFile, nombreNuevoParaArchivo);
		
		
		if (resultado) {
			String mensaje ="Se ha renombrado el fichero "+nombreNuevoParaArchivo;
			JOptionPane.showMessageDialog(null, mensaje, "Borrar ficheros", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "No se ha podido renombrar el fichero "+oldFile.getName(), "Renombrar ficheros", JOptionPane.ERROR_MESSAGE);
		}
		
		finalizar();
		

	}
	
	public void finalizar() {
		homeFrame.getMenuCentral().mostrarNombrarArchivoPanel();
		homeFrame.repaint();
	}

}
