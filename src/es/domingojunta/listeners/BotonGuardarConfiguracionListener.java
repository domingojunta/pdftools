package es.domingojunta.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JOptionPane;

import es.domingojunta.entities.ExpedienteEntity;
import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.ConfigurationPanel;
import es.domingojunta.panels.PaginarEIndicePanel;
import es.domingojunta.tools.Configuracion;

public class BotonGuardarConfiguracionListener implements ActionListener {

	
	private HomeFrame homeFrame;
	private ConfigurationPanel panel;
	
	public BotonGuardarConfiguracionListener(ConfigurationPanel panel) {
		
		this.panel = panel;
		this.homeFrame = panel.getHomeFrame();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Properties propiedades = new Properties();
		propiedades.put("rue",panel.getTextFieldRUE().getText());
		propiedades.put("declarante", panel.getTextFieldDeclarante().getText());
		propiedades.put("consejeria", panel.getTextFieldConsejeria().getText());
		propiedades.put("organismo", panel.getTextFieldOrganismo().getText());
		propiedades.put("unidad", panel.getTextFieldUnidad().getText());
		propiedades.put("logo", panel.getTextFieldLogo().getText());
		propiedades.put("unidadFirmante", panel.getTextFieldUnidadFirmante().getText());
		propiedades.put("nombreFirmante", panel.getTextFieldNombreFirmante().getText());
		
		Configuracion configuracion = new Configuracion();
		
		boolean resultado = configuracion.actualizarArchivoProperties(propiedades);
		
		if (resultado) {
			ExpedienteEntity expedienteEntity = configuracion.generarExpedienteEntityFromProperties(propiedades);
			homeFrame.setExpedienteEntity(expedienteEntity);
			String mensaje = "Se ha actualizado el archivo de configuración en el disco...";
			JOptionPane.showMessageDialog(null, mensaje, "Panel de configuración.",JOptionPane.INFORMATION_MESSAGE);
		} else {
			
			String mensaje = "No se ha podido actualizar el archivo de configuración en el disco...";
			JOptionPane.showMessageDialog(null, mensaje, "Panel de configuración.",JOptionPane.ERROR_MESSAGE);
		}

		homeFrame.getMenuCentral().mostrarConfiguracionPanel();
		homeFrame.repaint();
	}

}
