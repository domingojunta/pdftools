package es.domingojunta.listeners;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.PaginarEIndicePanel;

public class ComponentListenerPaginarEIndicePanel implements ComponentListener {

	private HomeFrame homeFrame;
	private PaginarEIndicePanel panel;
	
	public ComponentListenerPaginarEIndicePanel(PaginarEIndicePanel panel) {
		
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
		
		resetearCampos();

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		
		resetearCampos();

	}
	
	private void resetearCampos () {
		
		panel.getTextFieldRUE().setText(homeFrame.getExpedienteEntity().getRue());
		panel.getTextFieldDeclarante().setText(homeFrame.getExpedienteEntity().getDeclarante());
		panel.getTextFieldUnidadFirmante().setText(homeFrame.getExpedienteEntity().getUnidadFirmante());
		panel.getTextFieldNombreFirmante().setText(homeFrame.getExpedienteEntity().getNombreFirmante());
		panel.getBotonIndice().setEnabled(false);
		panel.getLabelWorkingGif().setVisible(false);
		
		panel.getTextFieldRUE().requestFocus();
		panel.getTextFieldRUE().selectAll();
		
		panel.setExpedienteEntity(null);
		homeFrame.repaint();
	}

}
