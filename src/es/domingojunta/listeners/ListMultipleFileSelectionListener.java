package es.domingojunta.listeners;

import java.io.File;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import es.domingojunta.panels.BorrarArchivoPanel;

public class ListMultipleFileSelectionListener implements ListSelectionListener {

	private BorrarArchivoPanel borrarArchivoPanel;
	
	public ListMultipleFileSelectionListener(BorrarArchivoPanel panel) {
		this.borrarArchivoPanel = panel;
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		//System.out.println("Entrando en VAlueChanged...");
		int[] ficherosSeleccionadosIndice = borrarArchivoPanel.getListFicherosEnDirectorio().getSelectedIndices();
		if (ficherosSeleccionadosIndice.length >0) {
			
			borrarArchivoPanel.getFicherosSeleccionadosParaSerBorrados().clear();
			
			for (int i : ficherosSeleccionadosIndice) {
				
				borrarArchivoPanel.getBotonBorrarFicherosSeleccionados().setEnabled(true);
				borrarArchivoPanel.getFicherosSeleccionadosParaSerBorrados().add(borrarArchivoPanel.getFicherosEnDirectorio()[i]);
			}
		}

			//System.out.println("Los archivos a borrar son: "+ borrarArchivoPanel.getFicherosSeleccionadosParaSerBorrados().size());
	}

}
