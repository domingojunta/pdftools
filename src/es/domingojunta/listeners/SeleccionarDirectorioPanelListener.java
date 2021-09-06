package es.domingojunta.listeners;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;

import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.SeleccionarDirectorioPanel;
import es.domingojunta.tools.OperacionesConFicheros;

public class SeleccionarDirectorioPanelListener implements ComponentListener {

	private SeleccionarDirectorioPanel panel;
	private HomeFrame homeFrame;
	
	
	public SeleccionarDirectorioPanelListener(SeleccionarDirectorioPanel panel) {
		
		this.panel = panel;
		this.homeFrame = panel.getHomeFrame();
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
		
		if (homeFrame.getDirectorioDeTrabajo()!=null) {
			
			OperacionesConFicheros operaciones = new OperacionesConFicheros();
			File[] ficheros = operaciones.seleccionarFicherosEnDirectorio(homeFrame.getDirectorioDeTrabajo());
			StringBuffer buffer = new StringBuffer();
			
			for (File item : ficheros) {
				
				buffer.append(item.getName());
				buffer.append("\n");
			}
			
			panel.getTextAreaListadoArchivos().setText(buffer.toString());
		}
		
		toogleMostrarOcultarComponent();

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		
		toogleMostrarOcultarComponent();

	}
	
	public void toogleMostrarOcultarComponent() {
		
		if (homeFrame.getDirectorioDeTrabajo()==null) {
			
			panel.getTextAreaDirectorioSeleccionado().setEnabled(false);
			panel.getTextAreaListadoArchivos().setEnabled(false);
			panel.getBotonRenumerar().setEnabled(false);
		} else {
			panel.getTextAreaDirectorioSeleccionado().setEnabled(true);
			panel.getTextAreaListadoArchivos().setEnabled(true);
			panel.getBotonRenumerar().setEnabled(true);
		}
		
	}

}
