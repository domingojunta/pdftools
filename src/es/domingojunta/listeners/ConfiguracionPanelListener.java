package es.domingojunta.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.domingojunta.frames.HomeFrame;

public class ConfiguracionPanelListener implements ActionListener {

	private HomeFrame homeFrame = null;
	
	public ConfiguracionPanelListener(HomeFrame homeFrame) {
		
		this.homeFrame = homeFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		homeFrame.repaint();
		homeFrame.getMenuCentral().mostrarConfiguracionPanel();

	}

}
