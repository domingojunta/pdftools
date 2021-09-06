package es.domingojunta.listeners;

import java.io.File;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.itextpdf.kernel.log.SystemOutCounter;
import com.itextpdf.kernel.pdf.filters.IFilterHandler;

import es.domingojunta.panels.BorrarArchivoPanel;
import es.domingojunta.panels.NombrarArchivoPanel;

public class ListSimpleFileSelectionListener implements ListSelectionListener {

	private NombrarArchivoPanel nombrarArchivoPanel;
	
	public ListSimpleFileSelectionListener(NombrarArchivoPanel nombrarArchivoPanel) {
		//System.out.println("Entrando en ListSimpleFileSelectionListener...");
		this.nombrarArchivoPanel = nombrarArchivoPanel;
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		//System.out.println("Entrando en el método valueChanged...");
		int ficheroSeleccionadoIndice = nombrarArchivoPanel.getListFicherosEnDirectorio().getSelectedIndex();
		String nombreFicheroCorto = "";
		String comentario ="";
		
		if (ficheroSeleccionadoIndice != -1) {
			nombrarArchivoPanel.getTextFieldNombreArchivo().setEnabled(true);
			nombrarArchivoPanel.getTextAreaComentarioArchivo().setEnabled(true);
			nombrarArchivoPanel.getBotonRenombrar().setEnabled(true);
			
		
		//NombrarArchivoPanel.getBotonBorrarFicherosSeleccionados().setEnabled(true);
		File ficheroSeleccionado = nombrarArchivoPanel.getFicherosEnDirectorio()[ficheroSeleccionadoIndice];
		nombrarArchivoPanel.setFicheroSeleccionadoParaRenombrarlo(ficheroSeleccionado);
		
		String nombreFicheroLargo = ficheroSeleccionado.getName();
		
		int indice = nombreFicheroLargo.indexOf("#");
		
		if (indice == -1) {
			
			nombreFicheroCorto = nombreFicheroLargo.replaceAll(".pdf", "").trim();
		
		} else {
			
			nombreFicheroCorto = nombreFicheroLargo.substring(0,indice).trim();
			comentario = nombreFicheroLargo.substring(indice+1).replaceAll(".pdf", "").trim();
		}
		
		
		
		nombrarArchivoPanel.getTextFieldNombreArchivo().setText(nombreFicheroCorto);
		
		nombrarArchivoPanel.getTextAreaComentarioArchivo().setText(comentario);
		
		nombrarArchivoPanel.getTextFieldNombreArchivo().requestFocus(true);
		nombrarArchivoPanel.getTextFieldNombreArchivo().selectAll();
		
		}
		
		
		
		
		

	}

}
