package es.domingojunta.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import es.domingojunta.frames.HomeFrame;

public class AboutListener implements ActionListener {

	private HomeFrame homeFrame = null;
	
	
	public AboutListener(HomeFrame componente) {
		
		this.homeFrame = componente;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		homeFrame.repaint();
		homeFrame.getMenuCentral().mostrarAboutPanel();
		
		

	}

}
