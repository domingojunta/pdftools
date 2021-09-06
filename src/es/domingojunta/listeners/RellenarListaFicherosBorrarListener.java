package es.domingojunta.listeners;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import es.domingojunta.entities.FicherosSeleccionadosModel;
import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.BorrarArchivoPanel;
import es.domingojunta.tools.OperacionesConFicheros;

public class RellenarListaFicherosBorrarListener implements ComponentListener {

	
	private HomeFrame homeFrame;
	private BorrarArchivoPanel borrarArchivoPanel;
	
	
	public RellenarListaFicherosBorrarListener(BorrarArchivoPanel borrarArchivoPanel) {
		
		this.homeFrame = borrarArchivoPanel.getHomeFrame();
		this.borrarArchivoPanel = borrarArchivoPanel;
		
		
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
		
		
		
		File directorioDeTrabajo = new File(homeFrame.getDirectorioDeTrabajo());
		File[] ficherosEnDirectorioTrabajo = directorioDeTrabajo.listFiles();
		
		OperacionesConFicheros operacionesConFicheros = new OperacionesConFicheros();
		File[] ficherosEnDirectorioTrabajoOrdenados = operacionesConFicheros.ordenarFicherosPorNombre(ficherosEnDirectorioTrabajo);
		
		
		borrarArchivoPanel.setFicherosEnDirectorio(ficherosEnDirectorioTrabajoOrdenados);
		FicherosSeleccionadosModel ficherosSeleccionadosModel = new FicherosSeleccionadosModel(ficherosEnDirectorioTrabajoOrdenados);
		borrarArchivoPanel.getBotonBorrarFicherosSeleccionados().setEnabled(false);
		borrarArchivoPanel.getListFicherosEnDirectorio().setModel(ficherosSeleccionadosModel);
		
		
		

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	public HomeFrame getHomeFrame() {
		return homeFrame;
	}

	public void setHomeFrame(HomeFrame homeFrame) {
		this.homeFrame = homeFrame;
	}

	public BorrarArchivoPanel getBorrarArchivoPanel() {
		return borrarArchivoPanel;
	}

	public void setBorrarArchivoPanel(BorrarArchivoPanel borrarArchivoPanel) {
		this.borrarArchivoPanel = borrarArchivoPanel;
	}
	
	

}
