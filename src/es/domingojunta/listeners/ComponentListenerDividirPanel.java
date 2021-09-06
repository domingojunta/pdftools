package es.domingojunta.listeners;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import es.domingojunta.panels.DividirPanel;

public class ComponentListenerDividirPanel implements ComponentListener {

	private DividirPanel panel;
	
	public ComponentListenerDividirPanel(DividirPanel panel) {
		
		this.panel = panel;
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentShown(ComponentEvent e) {

		borrarContenido();
		desactivarContenido();

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		
		borrarContenido();
		desactivarContenido();

	}
	
	private void borrarContenido() {
		
		panel.getTextFieldNombreFicheroADividir().setText("");
		panel.getTextFieldNombreBaseNuevosArchivos().setText("");
		panel.getTextFieldNumerosDePaginaDeCorte().setText("");
		panel.getLabelNumerosDePaginasDeCorte().setText("Introduce los números de página de corte separados por comas...");
		panel.setFicheroADividir(null);
	}
	
	private void desactivarContenido() {
		
		panel.getTextFieldNombreFicheroADividir().setEnabled(false);
		panel.getTextFieldNombreBaseNuevosArchivos().setEnabled(false);
		panel.getTextFieldNumerosDePaginaDeCorte().setEnabled(false);
		panel.getLabelNumerosDePaginasDeCorte().setText("Introduce los números de página de corte separados por comas...");
		panel.getBotonDividirArchivoPdf().setEnabled(false);
		
	}

}
