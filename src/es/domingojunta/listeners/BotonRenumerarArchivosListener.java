package es.domingojunta.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.SeleccionarDirectorioPanel;
import es.domingojunta.tools.OperacionesConFicheros;

public class BotonRenumerarArchivosListener implements ActionListener {

	private SeleccionarDirectorioPanel panel;
	private HomeFrame homeFrame;
	
	public BotonRenumerarArchivosListener(SeleccionarDirectorioPanel panel) {
		
		this.panel = panel;
		this.homeFrame = panel.getHomeFrame();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
			OperacionesConFicheros operacionesConFicheros = new OperacionesConFicheros();
			
			File[] oldFicheros = operacionesConFicheros.seleccionarFicherosEnDirectorio(homeFrame.getDirectorioDeTrabajo());
			String prefijo = "";
			
			File[] ficherosNormalizados = operacionesConFicheros.renumerarFicheros(oldFicheros);
		
			
			
			File[] ficheros = operacionesConFicheros.seleccionarFicherosEnDirectorio(homeFrame.getDirectorioDeTrabajo());
			StringBuffer buffer = new StringBuffer();
			
			for (File item : ficheros) {
								buffer.append(item.getName());
				buffer.append("\n");
			}
			panel.getTextAreaListadoArchivos().setText(buffer.toString());
			
			homeFrame.repaint();
			
	}
}
