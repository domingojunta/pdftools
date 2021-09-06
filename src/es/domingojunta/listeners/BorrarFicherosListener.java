package es.domingojunta.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Set;

import javax.swing.JOptionPane;

import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.BorrarArchivoPanel;
import es.domingojunta.tools.OperacionesConFicheros;

public class BorrarFicherosListener implements ActionListener {

	private Set<File> ficherosSeleccionadosParaSerBorrados;
	private BorrarArchivoPanel borrarArchivoPanel;
	private HomeFrame homeFrame;
	
	public BorrarFicherosListener(BorrarArchivoPanel borrarArchivoPanel) {
		
		this.borrarArchivoPanel = borrarArchivoPanel;
		this.ficherosSeleccionadosParaSerBorrados = borrarArchivoPanel.getFicherosSeleccionadosParaSerBorrados();
		this.homeFrame = borrarArchivoPanel.getHomeFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		OperacionesConFicheros operacionesConFicheros = new OperacionesConFicheros();
		boolean algunError = false;
		
		for (File item : ficherosSeleccionadosParaSerBorrados) {
			
			boolean resultado = operacionesConFicheros.borrarFichero(item);
			if (!resultado) {
				algunError = true;
				JOptionPane.showMessageDialog(null, "No se ha podido borrar el fichero "+item.getName(), "Borrar ficheros", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		String mensaje = "Operación de borrado finalizada con éxito...";
		if (algunError) {
			mensaje = "Operación de borrado finalizada con errores de borrado...";
		}
		
		JOptionPane.showMessageDialog(null, mensaje, "Borrar ficheros", JOptionPane.INFORMATION_MESSAGE);
		homeFrame.getMenuCentral().mostrarSeleccionarDirectorioPanel();
		homeFrame.repaint();
	}

}
