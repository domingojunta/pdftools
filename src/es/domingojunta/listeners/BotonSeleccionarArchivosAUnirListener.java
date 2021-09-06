package es.domingojunta.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.MenuCentralPanel;
import es.domingojunta.panels.SeleccionarDirectorioPanel;
import es.domingojunta.panels.UnirPanel;
import es.domingojunta.tools.OperacionesConFicheros;

public class BotonSeleccionarArchivosAUnirListener implements ActionListener {

	private HomeFrame homeFrame;
	private UnirPanel unirPanel;
	
	
	public BotonSeleccionarArchivosAUnirListener(UnirPanel unirPanel) {
		
		this.homeFrame = unirPanel.getHomeFrame();
		this.unirPanel = unirPanel;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		File currentDirectory = new File(homeFrame.getDirectorioDeTrabajo());
		JFileChooser fileChooser = new JFileChooser(currentDirectory);
		fileChooser.setDialogTitle("Selecciona los ficheros a unir");
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setAcceptAllFileFilterUsed(false);
		int resultado = fileChooser.showDialog(unirPanel, "Selecciona el directorio de trabajo");
		//System.out.println("El resultado es: "+ resultado);
		
		
		if ( resultado == JFileChooser.APPROVE_OPTION) {
			
			File[] ficherosSeleccionados = fileChooser.getSelectedFiles();
			
			
			OperacionesConFicheros ordenarFicheros = new OperacionesConFicheros();
			
			
			if (ficherosSeleccionados.length > 1) {
				
				File[] ficherosSeleccionadosOrdenados = ordenarFicheros.ordenarFicherosPorNombre(ficherosSeleccionados);
				unirPanel.setFicherosSeleccionadosOrdenados(ficherosSeleccionadosOrdenados);
				
				StringBuffer nombreArchivosSeleccionados = new StringBuffer();
				for (File item : ficherosSeleccionadosOrdenados) {
					
					nombreArchivosSeleccionados.append(item.getName());
					nombreArchivosSeleccionados.append("\n");
				}
				
				unirPanel.getTextAreaFicherosSeleccionados().setText(nombreArchivosSeleccionados.toString());
				
				//unirPanel.repaint();
				unirPanel.mostrarParteInferior();
				unirPanel.getTextFieldNombreArchivo().requestFocus(true);
				unirPanel.getTextFieldNombreArchivo().selectAll();
				unirPanel.getBotonUnir().setEnabled(false);
				homeFrame.repaint();
							
				
				
			} else {
				
				unirPanel.getTextAreaFicherosSeleccionados().setText("Debe seleccionar al menos dos ficheros...");
			}
		}
		
		
		

	}

}
