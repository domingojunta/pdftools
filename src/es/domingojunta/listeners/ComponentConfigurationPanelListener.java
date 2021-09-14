package es.domingojunta.listeners;

import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Properties;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import es.domingojunta.entities.ExpedienteEntity;
import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.ConfigurationPanel;
import es.domingojunta.tools.Configuracion;

public class ComponentConfigurationPanelListener implements ComponentListener {

	private HomeFrame homeFrame;
	private ConfigurationPanel panel;
	
	
	public ComponentConfigurationPanelListener(ConfigurationPanel panel) {
		
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
		
		panel.getTextFieldRUE().setText(homeFrame.getExpedienteEntity().getRue());
		panel.getTextFieldConsejeria().setText(homeFrame.getExpedienteEntity().getConsejeria());
		panel.getTextFieldDeclarante().setText(homeFrame.getExpedienteEntity().getDeclarante());
		panel.getTextFieldLogo().setText(homeFrame.getExpedienteEntity().getLogo());
		panel.getTextFieldNombreFirmante().setText(homeFrame.getExpedienteEntity().getNombreFirmante());
		panel.getTextFieldOrganismo().setText(homeFrame.getExpedienteEntity().getOrganismo());
		panel.getTextFieldUnidad().setText(homeFrame.getExpedienteEntity().getUnidad());
		panel.getTextFieldUnidadFirmante().setText(homeFrame.getExpedienteEntity().getUnidadFirmante());
		ImageIcon imagen = new ImageIcon(homeFrame.getExpedienteEntity().getLogo());
		int width = panel.getLabelLogoIcon().getWidth();
		int height = panel.getLabelLogoIcon().getHeight();
		Icon iconoTrabajando = new ImageIcon(imagen.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		panel.getLabelLogoIcon().setIcon(iconoTrabajando);
		//homeFrame.repaint();
		

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		
		

		
		
		
	

	}

}
