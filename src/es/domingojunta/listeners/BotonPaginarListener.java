package es.domingojunta.listeners;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import es.domingojunta.entities.ExpedienteEntity;
import es.domingojunta.entities.FicheroEntity;
import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.PaginarEIndicePanel;
import es.domingojunta.tools.OperacionesConFicheros;
import es.domingojunta.tools.OperacionesConPdf;

public class BotonPaginarListener implements ActionListener {

	
	private HomeFrame homeFrame;
	private PaginarEIndicePanel panel;
	
	
	public BotonPaginarListener(PaginarEIndicePanel panel) {
		
		this.panel = panel;
		this.homeFrame = panel.getHomeFrame();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		panel.getLabelWorkingGif().setVisible(true);
		homeFrame.repaint();
		ImageIcon imagenTrabajando = new ImageIcon("images/Paginando.gif");
		Icon iconoTrabajando = new ImageIcon(imagenTrabajando.getImage().getScaledInstance(300, 170, Image.SCALE_DEFAULT));
		panel.getLabelWorkingGif().setIcon(iconoTrabajando);
		
		
		String rue = panel.getTextFieldRUE().getText().toUpperCase();
		String declarante = panel.getTextFieldDeclarante().getText().toUpperCase();
		String unidadFirmante = panel.getTextFieldUnidadFirmante().getText().toUpperCase();
		String nombreFirmante = panel.getTextFieldNombreFirmante().getText().toUpperCase();
		
		ExpedienteEntity expediente = new ExpedienteEntity();
		expediente.setRue(rue);
		expediente.setDeclarante(declarante);
		expediente.setUnidadFirmante(unidadFirmante);
		expediente.setNombreFirmante(nombreFirmante);
		
		
		panel.setExpedienteEntity(expediente);
		
		OperacionesConFicheros operacionesConFicheros = new OperacionesConFicheros();
		OperacionesConPdf operacionesConPdf = new OperacionesConPdf();
		
		
		
		String directorioDeSalida = homeFrame.getDirectorioDeTrabajo();
		String separador = File.separator;
		
		if (!rue.equals("")) {
			
			directorioDeSalida = directorioDeSalida + separador + rue;
		} else {
			
			directorioDeSalida = directorioDeSalida+separador+"SALIDA";
		}
		
		boolean resultadoCrearDirectorio = operacionesConFicheros.crearDirectorio(directorioDeSalida);
		String mensaje ="";
		
		if (! resultadoCrearDirectorio) {
			
			mensaje = "Error al crear el directorio "+ directorioDeSalida;
			mostrarIconoDeError(mensaje);
			volverAMostrarPanelPaginarEIndice();
			
		} 
		
		List<FicheroEntity> listadoFicheroEntities = operacionesConFicheros.leerDirectorioYGenerarListaFicherosEntity(homeFrame.getDirectorioDeTrabajo());
			
		//System.out.println("El número total de páginas es: "+ resultadoGenerarListadoFicheroEntities.get(resultadoGenerarListadoFicheroEntities.size()-1).getPaginaFinal());
		
		
		boolean resultadoPaginacion = operacionesConPdf.paginar(listadoFicheroEntities, directorioDeSalida);
		
		if (! resultadoPaginacion) {
			
			mensaje = "Error en la paginación de los ficheros...";
			mostrarIconoDeError(mensaje);
			volverAMostrarPanelPaginarEIndice();
		}
		
		String message = "Los ficheros se han paginado correctamente...";
		JOptionPane.showMessageDialog(null, message, "Paginar", JOptionPane.INFORMATION_MESSAGE);
		ImageIcon imagen = new ImageIcon("images/Ok.jpg");
		Icon iconoOk = new ImageIcon(imagen.getImage().getScaledInstance(300, 170, Image.SCALE_DEFAULT));
		panel.getLabelWorkingGif().setIcon(iconoOk);
		panel.getBotonIndice().setEnabled(true);
	}
	
	
	private void mostrarIconoDeError(String message) {
		
		ImageIcon imagen = new ImageIcon("images/error.png");
		Icon iconoError = new ImageIcon(imagen.getImage().getScaledInstance(300, 170, Image.SCALE_DEFAULT));
		panel.getLabelWorkingGif().setIcon(iconoError);
		JOptionPane.showMessageDialog(null, message, "Paginar", JOptionPane.ERROR_MESSAGE);
		
	}
	
	private void volverAMostrarPanelPaginarEIndice() {
		
		homeFrame.getMenuCentral().mostrarPaginarEIndicePanel();
		homeFrame.repaint();
	} 

}
