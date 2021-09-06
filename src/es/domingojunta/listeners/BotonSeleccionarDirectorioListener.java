package es.domingojunta.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import es.domingojunta.filters.PdfFileFilter;
import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.SeleccionarDirectorioPanel;
import es.domingojunta.tools.OperacionesConFicheros;

public class BotonSeleccionarDirectorioListener implements ActionListener {

	private SeleccionarDirectorioPanel panel;
	private HomeFrame homeFrame;
	
	public BotonSeleccionarDirectorioListener(SeleccionarDirectorioPanel panel) {
		
		this.panel = panel;
		this.homeFrame = panel.getHomeFrame();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Selecciona el directorio de trabajo");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		
		int resultado = fileChooser.showDialog(panel, "Selecciona el directorio de trabajo");
		if ( resultado == JFileChooser.APPROVE_OPTION) {
			
			String directorioSeleccionado = fileChooser.getSelectedFile().getAbsolutePath().toString();
			homeFrame.setDirectorioDeTrabajo(directorioSeleccionado);
			panel.getTextAreaDirectorioSeleccionado().setText(directorioSeleccionado);
			
			
			mostrarArchivoEnDirectorio(directorioSeleccionado);
			
		} else {
			
			panel.getTextAreaListadoArchivos().setText("Nada seleccionado");
		}
		
		

	}

	private void mostrarArchivoEnDirectorio(String directorioSeleccionado) {
		
		File archivosEnDirectorio = new File(directorioSeleccionado);
		String mensaje = "Sin Ficheros pdf en el directorio";
		StringBuffer stringBuffer = new StringBuffer();
		
		if (archivosEnDirectorio.exists()) {
			
			OperacionesConFicheros operacionesConFicheros = new OperacionesConFicheros();
			
			File[] ficheros = operacionesConFicheros.seleccionarFicherosEnDirectorio(homeFrame.getDirectorioDeTrabajo());
			
			
			
			if (ficheros.length>0) {
				
				for (File item : ficheros) {
					
					stringBuffer.append(item.getName());
					stringBuffer.append("\n");
					
				}
				
				mensaje = stringBuffer.toString();
			
			}
			
			//panel.setFicherosSeleccionadosParaRenumerar(ficheros);
			
		}
		
		//System.out.println(mensaje);
		panel.getTextAreaListadoArchivos().setText(mensaje);
		
		if (homeFrame.getDirectorioDeTrabajo()==null) {
			
			panel.getTextAreaDirectorioSeleccionado().setEnabled(false);
			panel.getTextAreaListadoArchivos().setEnabled(false);
			panel.getBotonRenumerar().setEnabled(false);
		} else {
			panel.getTextAreaDirectorioSeleccionado().setEnabled(true);
			panel.getTextAreaListadoArchivos().setEnabled(true);
			panel.getBotonRenumerar().setEnabled(true);
		}
		
		
		panel.getHomeFrame().repintarHomeFrame();
		panel.getHomeFrame().repaint();
	
	
	}
		
	

	

	

}
