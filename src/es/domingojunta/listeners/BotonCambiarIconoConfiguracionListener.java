package es.domingojunta.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import es.domingojunta.entities.ExpedienteEntity;
import es.domingojunta.frames.HomeFrame;
import es.domingojunta.panels.ConfigurationPanel;
import es.domingojunta.tools.Configuracion;

public class BotonCambiarIconoConfiguracionListener implements ActionListener {

	private HomeFrame homeFrame;
	private ConfigurationPanel panel;
	
	public BotonCambiarIconoConfiguracionListener(ConfigurationPanel panel) {
		
		this.panel = panel;
		this.homeFrame = panel.getHomeFrame();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		File currentDirectory = new File(".");
		File nuevoIconoFile = null;
		JFileChooser fileChooser = new JFileChooser(currentDirectory);
		fileChooser.setDialogTitle("Selecciona el nuevo icono");
		fileChooser.setMultiSelectionEnabled(false);
		
		fileChooser.setAcceptAllFileFilterUsed(false);
		
		FileNameExtensionFilter filtroGrafico = new FileNameExtensionFilter("Gráficos", "jpg","png","gif","jpeg");
		fileChooser.setFileFilter(filtroGrafico);
		int resultado = fileChooser.showDialog(panel, "Selecciona nuevo icono");
		
		if ( resultado == JFileChooser.APPROVE_OPTION) {
			
			nuevoIconoFile = fileChooser.getSelectedFile();
			ExpedienteEntity expedienteEntity = homeFrame.getExpedienteEntity();
			expedienteEntity.setLogo(nuevoIconoFile.getAbsolutePath());
			
			Configuracion configuracion = new Configuracion();
			
			boolean result = configuracion.actualizarArchivoProperties(expedienteEntity);
			
			
			if (result) {
				
				String mensaje = "El icono se ha actualizado correctamente...";
				JOptionPane.showMessageDialog(null, mensaje, "Actualizar icono", JOptionPane.INFORMATION_MESSAGE);
				homeFrame.setExpedienteEntity(expedienteEntity);
				homeFrame.getMenuCentral().mostrarConfiguracionPanel();
				homeFrame.repintarHomeFrame();
				homeFrame.repaint();
			} else {
			
				String mensaje = "Error al actulizar el icono...";
				JOptionPane.showMessageDialog(null, mensaje, "Actualizar icono", JOptionPane.ERROR_MESSAGE);
				homeFrame.getMenuCentral().mostrarConfiguracionPanel();
				homeFrame.repaint();
			}
		}

	}

}
