package es.domingojunta.panels;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Component;
import javax.swing.SwingConstants;

import es.domingojunta.entities.ExpedienteEntity;
import es.domingojunta.entities.FicheroEntity;
import es.domingojunta.frames.HomeFrame;
import es.domingojunta.listeners.BotonCambiarIconoConfiguracionListener;
import es.domingojunta.listeners.BotonGuardarConfiguracionListener;
import es.domingojunta.listeners.BotonPaginarListener;
import es.domingojunta.listeners.BotonResetearConfiguracionListener;
import es.domingojunta.listeners.ComponentConfigurationPanelListener;

import javax.swing.JTextPane;
import java.io.File;
import java.util.List;
import javax.swing.border.LineBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurationPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton botonGuardar;
	private HomeFrame homeFrame;
	private JTextField textFieldRUE;
	private JTextField textFieldDeclarante;
	private JTextField textFieldUnidadFirmante;
	private JTextField textFieldNombreFirmante;
	private JTextField textFieldUnidad;
	private JTextField textFieldOrganismo;
	private JTextField textFieldConsejeria;
	private JTextField textFieldLogo;
	private JLabel labelLogoIcon;
	private JButton botonResetear;
	private JButton botonCambiarIconoConfiguracion;
	

	public ConfigurationPanel(HomeFrame homeFrame) {
		
		
		this.homeFrame = homeFrame;
		setBackground(new Color(240, 240, 240));
		//setBackground(Color.BLUE);
		//setOpaque(false);
		setPreferredSize(new Dimension(750,650));
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Configuración de la aplicación");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(58, 39, 492, 40);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		add(lblNewLabel);
		
		JLabel labelRUE = new JLabel("R.U.E.:");
		labelRUE.setHorizontalAlignment(SwingConstants.LEFT);
		labelRUE.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelRUE.setBounds(30, 370, 140, 30);
		add(labelRUE);
		
		textFieldRUE = new JTextField();
		textFieldRUE.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldRUE.setBounds(165, 370, 553, 30);
		textFieldRUE.setText("");
		add(textFieldRUE);
		
		JLabel labelDeclarante = new JLabel("Declarante:");
		labelDeclarante.setHorizontalAlignment(SwingConstants.LEFT);
		labelDeclarante.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelDeclarante.setBounds(30, 420, 140, 30);
		add(labelDeclarante);
		
		textFieldDeclarante = new JTextField();
		textFieldDeclarante.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldDeclarante.setBounds(165, 420, 553, 30);
		textFieldDeclarante.setText("");
		add(textFieldDeclarante);
		
		JLabel labelUnidadFirmante = new JLabel("Unidad Firmante:");
		labelUnidadFirmante.setHorizontalAlignment(SwingConstants.LEFT);
		labelUnidadFirmante.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelUnidadFirmante.setBounds(30, 470, 140, 30);
		add(labelUnidadFirmante);
		
		textFieldUnidadFirmante = new JTextField();
		textFieldUnidadFirmante.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldUnidadFirmante.setBounds(165, 470, 553, 30);
		textFieldUnidadFirmante.setText("");
		add(textFieldUnidadFirmante);
		
		JLabel labelNombreFirmante = new JLabel("Nombre Firmante:");
		labelNombreFirmante.setHorizontalAlignment(SwingConstants.LEFT);
		labelNombreFirmante.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelNombreFirmante.setBounds(30, 520, 140, 30);
		add(labelNombreFirmante);
						
		textFieldNombreFirmante = new JTextField();
		textFieldNombreFirmante.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldNombreFirmante.setBounds(165, 520, 553, 30);
		textFieldNombreFirmante.setText("");
		add(textFieldNombreFirmante);
		
		botonGuardar = new JButton("Guardar");
		
		
		botonGuardar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonGuardar.setBounds(30, 577, 300, 40);
		
		//botonPaginar.addActionListener(new BotonPaginarListener(this));
		botonGuardar.addActionListener(new BotonGuardarConfiguracionListener(this));
		add(botonGuardar);
		
		JLabel labelUnidad = new JLabel("Unidad:");
		labelUnidad.setHorizontalAlignment(SwingConstants.LEFT);
		labelUnidad.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelUnidad.setBounds(30, 320, 140, 30);
		add(labelUnidad);
		
		textFieldUnidad = new JTextField();
		textFieldUnidad.setText("");
		textFieldUnidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldUnidad.setBounds(165, 320, 553, 30);
		add(textFieldUnidad);
		
		JLabel labelOrganismo = new JLabel("Organismo:");
		labelOrganismo.setHorizontalAlignment(SwingConstants.LEFT);
		labelOrganismo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelOrganismo.setBounds(30, 270, 140, 30);
		add(labelOrganismo);
		
		textFieldOrganismo = new JTextField();
		textFieldOrganismo.setText("");
		textFieldOrganismo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldOrganismo.setBounds(165, 270, 553, 30);
		add(textFieldOrganismo);
		
		JLabel labelConsejeria = new JLabel("Consejer\u00EDa:");
		labelConsejeria.setHorizontalAlignment(SwingConstants.LEFT);
		labelConsejeria.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelConsejeria.setBounds(30, 220, 140, 30);
		add(labelConsejeria);
		
		textFieldConsejeria = new JTextField();
		textFieldConsejeria.setText("");
		textFieldConsejeria.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldConsejeria.setBounds(165, 220, 553, 30);
		add(textFieldConsejeria);
		
		JLabel labelLogo = new JLabel("Logo:");
		labelLogo.setHorizontalAlignment(SwingConstants.LEFT);
		labelLogo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelLogo.setBounds(30, 121, 125, 30);
		add(labelLogo);
		
		textFieldLogo = new JTextField();
		textFieldLogo.setText("");
		textFieldLogo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldLogo.setBounds(165, 121, 385, 30);
		add(textFieldLogo);
		
		//ImageIcon imagen = new ImageIcon(homeFrame.getExpedienteEntity().getLogo());
		//Icon iconoTrabajando = new ImageIcon(imagen.getImage().getScaledInstance(300, 170, Image.SCALE_DEFAULT));
		labelLogoIcon = new JLabel("");
		labelLogoIcon.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		labelLogoIcon.setBounds(590, 92, 100, 100);
		add(labelLogoIcon);
		
		botonCambiarIconoConfiguracion = new JButton("Cambiar logo");
		botonCambiarIconoConfiguracion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonCambiarIconoConfiguracion.setBounds(333, 162, 217, 30);
		botonCambiarIconoConfiguracion.addActionListener(new BotonCambiarIconoConfiguracionListener(this));
		add(botonCambiarIconoConfiguracion);
		
		addComponentListener(new ComponentConfigurationPanelListener(this));
		
		botonResetear = new JButton("Resetear a valores por defecto");
		
		botonResetear.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonResetear.setBounds(418, 577, 300, 40);
		botonResetear.addActionListener(new BotonResetearConfiguracionListener(this));
		add(botonResetear);
	}


	public JButton getBotonGuardar() {
		return botonGuardar;
	}


	public void setBotonGuardar(JButton botonGuardar) {
		this.botonGuardar = botonGuardar;
	}


	public HomeFrame getHomeFrame() {
		return homeFrame;
	}


	public void setHomeFrame(HomeFrame homeFrame) {
		this.homeFrame = homeFrame;
	}


	public JTextField getTextFieldRUE() {
		return textFieldRUE;
	}


	public void setTextFieldRUE(JTextField textFieldRUE) {
		this.textFieldRUE = textFieldRUE;
	}


	public JTextField getTextFieldDeclarante() {
		return textFieldDeclarante;
	}


	public void setTextFieldDeclarante(JTextField textFieldDeclarante) {
		this.textFieldDeclarante = textFieldDeclarante;
	}


	public JTextField getTextFieldUnidadFirmante() {
		return textFieldUnidadFirmante;
	}


	public void setTextFieldUnidadFirmante(JTextField textFieldUnidadFirmante) {
		this.textFieldUnidadFirmante = textFieldUnidadFirmante;
	}


	public JTextField getTextFieldNombreFirmante() {
		return textFieldNombreFirmante;
	}


	public void setTextFieldNombreFirmante(JTextField textFieldNombreFirmante) {
		this.textFieldNombreFirmante = textFieldNombreFirmante;
	}


	public JTextField getTextFieldUnidad() {
		return textFieldUnidad;
	}


	public void setTextFieldUnidad(JTextField textFieldUnidad) {
		this.textFieldUnidad = textFieldUnidad;
	}


	public JTextField getTextFieldOrganismo() {
		return textFieldOrganismo;
	}


	public void setTextFieldOrganismo(JTextField textFieldOrganismo) {
		this.textFieldOrganismo = textFieldOrganismo;
	}


	public JTextField getTextFieldConsejeria() {
		return textFieldConsejeria;
	}


	public void setTextFieldConsejeria(JTextField textFieldConsejeria) {
		this.textFieldConsejeria = textFieldConsejeria;
	}


	public JTextField getTextFieldLogo() {
		return textFieldLogo;
	}


	public void setTextFieldLogo(JTextField textFieldLogo) {
		this.textFieldLogo = textFieldLogo;
	}


	public JLabel getLabelLogoIcon() {
		return labelLogoIcon;
	}


	public void setLabelLogoIcon(JLabel labelLogoIcon) {
		this.labelLogoIcon = labelLogoIcon;
	}
	
	
	
	
}
