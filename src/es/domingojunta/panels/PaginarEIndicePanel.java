package es.domingojunta.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import es.domingojunta.entities.ExpedienteEntity;
import es.domingojunta.entities.FicheroEntity;
import es.domingojunta.frames.HomeFrame;
import es.domingojunta.listeners.BotonPaginarListener;
import es.domingojunta.listeners.ComponentListenerPaginarEIndicePanel;

import javax.swing.JTextPane;
import java.awt.SystemColor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

public class PaginarEIndicePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton botonPaginar;
	private HomeFrame homeFrame;
	private ExpedienteEntity expedienteEntity; 
	private List<FicheroEntity> ficheros;
	private String directorioDeSalida;
	private JTextField textFieldRUE;
	private JTextField textFieldDeclarante;
	private JTextField textFieldUnidadFirmante;
	private JTextField textFieldNombreFirmante;
	private JLabel labelWorkingGif;
	private JButton botonIndice;
	

	public PaginarEIndicePanel(HomeFrame homeFrame) {
		
		
		this.homeFrame = homeFrame;
		this.expedienteEntity = new ExpedienteEntity();
		
		setBackground(new Color(240, 240, 240, 50));
		//setBackground(Color.BLUE);
		setOpaque(false);
		setPreferredSize(new Dimension(750,650));
		setLayout(null);
		setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Paginar pdf's y generar índice");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(30, 55, 696, 40);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		add(lblNewLabel);
		
		JTextPane txtpnAlPulsarEn = new JTextPane();
		txtpnAlPulsarEn.setText("Al pulsar en el botón Paginar, se crea un subdirectorio /salida dentro del directorio de trabajo, en el que se sitúan los ficheros pdf renumerados y paginados.");
		txtpnAlPulsarEn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtpnAlPulsarEn.setBackground(new Color(240,240,240));
		txtpnAlPulsarEn.setBounds(30, 105, 696, 52);
		
		add(txtpnAlPulsarEn);
		
		botonPaginar = new JButton("Paginar");
		
		botonPaginar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonPaginar.setBounds(30, 390, 300, 40);
		
		botonPaginar.addActionListener(new BotonPaginarListener(this));
		add(botonPaginar);
		
		JLabel labelRUE = new JLabel("R.U.E.:");
		labelRUE.setHorizontalAlignment(SwingConstants.LEFT);
		labelRUE.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelRUE.setBounds(30, 180, 140, 30);
		add(labelRUE);
		
		textFieldRUE = new JTextField();
		textFieldRUE.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldRUE.setBounds(165, 180, 560, 30);
		textFieldRUE.setText("");
		add(textFieldRUE);
		
		JLabel labelDeclarante = new JLabel("Declarante:");
		labelDeclarante.setHorizontalAlignment(SwingConstants.LEFT);
		labelDeclarante.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelDeclarante.setBounds(30, 220, 140, 30);
		add(labelDeclarante);
		
		textFieldDeclarante = new JTextField();
		textFieldDeclarante.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldDeclarante.setBounds(165, 220, 560, 30);
		textFieldDeclarante.setText("");
		add(textFieldDeclarante);
		
		JLabel labelUnidadFirmante = new JLabel("Unidad Firmante:");
		labelUnidadFirmante.setHorizontalAlignment(SwingConstants.LEFT);
		labelUnidadFirmante.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelUnidadFirmante.setBounds(30, 270, 140, 30);
		add(labelUnidadFirmante);
		
		textFieldUnidadFirmante = new JTextField();
		textFieldUnidadFirmante.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldUnidadFirmante.setBounds(165, 270, 560, 30);
		textFieldUnidadFirmante.setText("");
		add(textFieldUnidadFirmante);
		
		JLabel labelNombreFirmante = new JLabel("Nombre Firmante:");
		labelNombreFirmante.setHorizontalAlignment(SwingConstants.LEFT);
		labelNombreFirmante.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelNombreFirmante.setBounds(30, 320, 140, 30);
		add(labelNombreFirmante);
						
		textFieldNombreFirmante = new JTextField();
		textFieldNombreFirmante.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldNombreFirmante.setBounds(165, 320, 560, 30);
		textFieldNombreFirmante.setText("");
		add(textFieldNombreFirmante);
		
		ImageIcon imagen = new ImageIcon("images/Paginando.gif");
		Icon iconoTrabajando = new ImageIcon(imagen.getImage().getScaledInstance(300, 170, Image.SCALE_DEFAULT));
		labelWorkingGif = new JLabel(iconoTrabajando);
		labelWorkingGif.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		labelWorkingGif.setBounds(225, 455, 300	, 170);
		add(labelWorkingGif);
		
		botonIndice = new JButton("Generar Índice");
		botonIndice.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonIndice.setBounds(426, 390, 300, 40);
		add(botonIndice);
		
		addComponentListener(new ComponentListenerPaginarEIndicePanel(this));
		
	}


	public JButton getBotonPaginar() {
		return botonPaginar;
	}


	public void setBotonPaginar(JButton botonPaginar) {
		this.botonPaginar = botonPaginar;
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


	public JLabel getLabelWorkingGif() {
		return labelWorkingGif;
	}


	public void setLabelWorkingGif(JLabel labelWorkingGif) {
		this.labelWorkingGif = labelWorkingGif;
	}


	public JButton getBotonIndice() {
		return botonIndice;
	}


	public void setBotonIndice(JButton botonIndice) {
		this.botonIndice = botonIndice;
	}


	public ExpedienteEntity getExpedienteEntity() {
		return expedienteEntity;
	}


	public void setExpedienteEntity(ExpedienteEntity expedienteEntity) {
		this.expedienteEntity = expedienteEntity;
	}


	public String getDirectorioDeSalida() {
		return directorioDeSalida;
	}


	public void setDirectorioDeSalida(String directorioDeSalida) {
		this.directorioDeSalida = directorioDeSalida;
	}


	public List<FicheroEntity> getFicheros() {
		return ficheros;
	}


	public void setFicheros(List<FicheroEntity> ficheros) {
		this.ficheros = ficheros;
	}
	
	
	
}
