package es.domingojunta.entities;

import java.io.File;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class FicherosSeleccionadosModel implements ListModel {

	
	private File[] datos;
	
	public FicherosSeleccionadosModel (File[] ficherosSeleccionados){
		
		this.datos = ficherosSeleccionados;
	}
	
	
	@Override
	public int getSize() {
		
		return datos.length;
	}

	@Override
	public Object getElementAt(int index) {
		
		return datos[index].getName();
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

}
