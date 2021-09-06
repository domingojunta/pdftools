package es.domingojunta.listeners;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;

import javax.swing.JPanel;

import es.domingojunta.entities.FicherosSeleccionadosModel;
import es.domingojunta.filters.PdfFileFilter;
import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.NombrarArchivoPanel;
import es.domingojunta.tools.OperacionesConFicheros;

public class RellenarListaFicherosRenombrarListener implements ComponentListener {

	
	private HomeFrame homeFrame;
	private NombrarArchivoPanel nombrarArchivoPanel;
	
	
	public RellenarListaFicherosRenombrarListener(NombrarArchivoPanel nombrarArchivoPanel) {
		//System.out.println("Entrando en rellenar lista ficheros renombrar listener ...");
		this.homeFrame = nombrarArchivoPanel.getHomeFrame();
		this.nombrarArchivoPanel = nombrarArchivoPanel;
		
		
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
		
		//System.out.println("Entrando en el método componentShown...");
		nombrarArchivoPanel.getTextFieldNombreArchivo().setEnabled(false);
		nombrarArchivoPanel.getTextAreaComentarioArchivo().setEnabled(false);
		nombrarArchivoPanel.getBotonRenombrar().setEnabled(false);
		homeFrame.repaint();
		
		File directorioDeTrabajo = new File(homeFrame.getDirectorioDeTrabajo());
		//File[] ficherosEnDirectorioTrabajoSinFiltrar = directorioDeTrabajo.listFiles();
		File[] ficherosEnDirectorioTrabajo = directorioDeTrabajo.listFiles(new PdfFileFilter());
		
		OperacionesConFicheros operacionesConFicheros = new OperacionesConFicheros();
		File[] ficherosEnDirectorioTrabajoOrdenados = operacionesConFicheros.ordenarFicherosPorNombre(ficherosEnDirectorioTrabajo);
		
		
		nombrarArchivoPanel.setFicherosEnDirectorio(ficherosEnDirectorioTrabajoOrdenados);
		FicherosSeleccionadosModel ficherosSeleccionadosModel = new FicherosSeleccionadosModel(ficherosEnDirectorioTrabajoOrdenados);
		//nombrarArchivoPanel.getBotonBorrarFicherosSeleccionados().setEnabled(false);
		nombrarArchivoPanel.getListFicherosEnDirectorio().setModel(ficherosSeleccionadosModel);
		
		
		

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		
		//System.out.println("Entrando en el método componentHidden...");
		nombrarArchivoPanel.getTextFieldNombreArchivo().setText("");
		nombrarArchivoPanel.getTextAreaComentarioArchivo().setText("");
		
	}

	public HomeFrame getHomeFrame() {
		return homeFrame;
	}

	public void setHomeFrame(HomeFrame homeFrame) {
		this.homeFrame = homeFrame;
	}

	public NombrarArchivoPanel getNombrarArchivoPanel() {
		return nombrarArchivoPanel;
	}

	public void setNombrarArchivoPanel(NombrarArchivoPanel nombrarArchivoPanel) {
		this.nombrarArchivoPanel = nombrarArchivoPanel;
	}
	
	

}
