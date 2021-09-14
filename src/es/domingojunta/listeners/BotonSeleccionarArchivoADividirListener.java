package es.domingojunta.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import es.domingojunta.filters.PdfFileFilter;
import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.DividirPanel;
import es.domingojunta.tools.OperacionesConPdf;

public class BotonSeleccionarArchivoADividirListener implements ActionListener {

	private HomeFrame homeFrame;
	private DividirPanel panel;
	
	public BotonSeleccionarArchivoADividirListener(DividirPanel panel) {
		
		this.panel = panel;
		this.homeFrame = panel.getHomeFrame();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		OperacionesConPdf operacionesPdf = new OperacionesConPdf();
		File currentDirectory = new File(homeFrame.getDirectorioDeTrabajo());
		File ficheroADividir = null;
		JFileChooser fileChooser = new JFileChooser(currentDirectory);
		fileChooser.setDialogTitle("Selecciona el fichero a dividir");
		fileChooser.setMultiSelectionEnabled(false);
		
		fileChooser.setAcceptAllFileFilterUsed(false);
		
		FileNameExtensionFilter filtroPdf = new FileNameExtensionFilter("Pdfs", "pdf");
		fileChooser.setFileFilter(filtroPdf);
		int resultado = fileChooser.showDialog(panel, "Selecciona el fichero a dividir");
		
		if ( resultado == JFileChooser.APPROVE_OPTION) {
			
			ficheroADividir = fileChooser.getSelectedFile();
			
			panel.getTextFieldNombreFicheroADividir().setText(ficheroADividir.getName());
			panel.setFicheroADividir(ficheroADividir);
			int numeroDePaginas = operacionesPdf.obtenerNumeroPaginas(ficheroADividir);
			
			if (numeroDePaginas ==1) {
				
				JOptionPane.showMessageDialog(null, "El fichero seleccionado sólo tiene una página y no se puede dividir...", "Dividir pdf", JOptionPane.ERROR_MESSAGE);
				homeFrame.getMenuCentral().mostrarDividirPanel();
				homeFrame.repaint();
			} else {
			
			panel.getLabelNumerosDePaginasDeCorte().setText("Introduce los números de página de corte separados por comas, desde el (1 hasta el "+ numeroDePaginas+")...");
			panel.setNumeroPaginasFicheroADividir(numeroDePaginas);
			homeFrame.repaint();
			mostrarContenido();
			}
		}
		}

	private void mostrarContenido() {
		
		panel.getTextFieldNombreFicheroADividir().setEnabled(true);
		panel.getTextFieldNombreBaseNuevosArchivos().setEnabled(true);
		
		
		
		panel.getTextFieldNombreBaseNuevosArchivos().requestFocus();
		panel.getTextFieldNombreBaseNuevosArchivos().selectAll();
		
	}

	

}
