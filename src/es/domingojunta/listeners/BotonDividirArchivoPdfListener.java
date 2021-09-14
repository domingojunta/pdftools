package es.domingojunta.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;

import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.DividirPanel;
import es.domingojunta.tools.OperacionesConPdf;

public class BotonDividirArchivoPdfListener implements ActionListener {

	private HomeFrame homeFrame;
	private DividirPanel panel;
	
	public BotonDividirArchivoPdfListener(DividirPanel panel) {
		
		this.panel = panel;
		this.homeFrame = panel.getHomeFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
			
		String directorioTrabajo = homeFrame.getDirectorioDeTrabajo();
		String nombreBase = panel.getTextFieldNombreBaseNuevosArchivos().getText();
		File ficheroADividir = panel.getFicheroADividir();
		int[] paginasDeCorte = panel.getPaginasDeCorte();
		
		OperacionesConPdf operacionesPdf = new OperacionesConPdf();
		
		boolean resultado = operacionesPdf.dividirFichero(ficheroADividir,paginasDeCorte,directorioTrabajo, nombreBase);
		
		if (resultado) {
			
			String mensaje = "Fichero Dividido de forma satisfactoria";
			JOptionPane.showMessageDialog(null, mensaje,"Dividir pdf",JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			
			String mensaje = "No se ha podido dividir el archivo...";
			JOptionPane.showMessageDialog(null, mensaje,"Dividir pdf",JOptionPane.ERROR_MESSAGE);
		}
		
		homeFrame.getMenuCentral().mostrarDividirPanel();
		homeFrame.repaint();
		

	}
		
	

}
