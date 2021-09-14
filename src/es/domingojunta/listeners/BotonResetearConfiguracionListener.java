package es.domingojunta.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JOptionPane;

import es.domingojunta.entities.ExpedienteEntity;
import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.ConfigurationPanel;
import es.domingojunta.tools.Configuracion;

public class BotonResetearConfiguracionListener implements ActionListener {

	
	private HomeFrame homeFrame;
	private ConfigurationPanel panel;
	
	public BotonResetearConfiguracionListener(ConfigurationPanel panel) {
		
		this.panel = panel;
		this.homeFrame = panel.getHomeFrame();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Properties propiedades = new Properties();
		Configuracion configuracion = new Configuracion();
		propiedades = configuracion.inicializar();
		
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
