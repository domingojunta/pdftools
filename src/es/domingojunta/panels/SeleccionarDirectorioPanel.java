package es.domingojunta.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import es.domingojunta.frames.HomeFrame;
import es.domingojunta.listeners.BotonRenumerarArchivosListener;
import es.domingojunta.listeners.BotonSeleccionarDirectorioListener;
import es.domingojunta.listeners.SeleccionarDirectorioPanelListener;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SeleccionarDirectorioPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton botonSeleccionar;
	private HomeFrame homeFrame;
	private JTextArea textAreaListadoArchivos;
	private JTextArea textAreaDirectorioSeleccionado;
	private JButton botonRenumerar;
	

	public SeleccionarDirectorioPanel(HomeFrame homeFrame) {
		
		this.homeFrame = homeFrame;
		setBackground(new Color(240, 240, 240, 50));
		//setBackground(Color.BLUE);
		setOpaque(false);
		setPreferredSize(new Dimension(750,650));
		setLayout(null);
		setVisible(false);
		
		JLabel labelTitulo = new JLabel("Seleccionar directorio de trabajo");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(30, 30, 699, 40);
		labelTitulo.setVerticalAlignment(SwingConstants.TOP);
		labelTitulo.setForeground(Color.BLUE);
		labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 25));
		add(labelTitulo);
		
		JLabel lblElDirectorioDe = new JLabel("El directorio de trabajo actual es:");
		lblElDirectorioDe.setVerticalAlignment(SwingConstants.TOP);
		lblElDirectorioDe.setForeground(Color.RED);
		lblElDirectorioDe.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblElDirectorioDe.setAlignmentX(0.5f);
		lblElDirectorioDe.setBounds(30, 86, 400, 30);
		add(lblElDirectorioDe);
		
		JScrollPane scrollPaneDirectorioActual = new JScrollPane();
		scrollPaneDirectorioActual.setBounds(30, 126, 699, 60);
		add(scrollPaneDirectorioActual);
		
		textAreaDirectorioSeleccionado = new JTextArea();
		textAreaDirectorioSeleccionado.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrollPaneDirectorioActual.setViewportView(textAreaDirectorioSeleccionado);
		
		botonSeleccionar = new JButton("Seleccionar directorio de trabajo");
		botonSeleccionar.addActionListener(new BotonSeleccionarDirectorioListener(this));
		botonSeleccionar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonSeleccionar.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonSeleccionar.setBounds(217, 209, 341, 30);
		add(botonSeleccionar);
		JScrollPane scrollPaneListadoFicheros = new JScrollPane();
		scrollPaneListadoFicheros.setBounds(30, 264, 699, 295);
		add(scrollPaneListadoFicheros);
		
		textAreaListadoArchivos = new JTextArea();
		textAreaListadoArchivos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textAreaListadoArchivos.setEditable(false);
		scrollPaneListadoFicheros.setViewportView(textAreaListadoArchivos);
		
		botonRenumerar = new JButton("Renumerar archivos");
		botonRenumerar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonRenumerar.setAlignmentX(0.5f);
		botonRenumerar.setBounds(217, 589, 341, 30);
		botonRenumerar.addActionListener(new BotonRenumerarArchivosListener(this));
		add(botonRenumerar);
		
		addComponentListener(new SeleccionarDirectorioPanelListener(this));
	}

	

	





	public JTextArea getTextAreaDirectorioSeleccionado() {
		return textAreaDirectorioSeleccionado;
	}





	public void setTextAreaDirectorioSeleccionado(JTextArea textAreaDirectorioSeleccionado) {
		this.textAreaDirectorioSeleccionado = textAreaDirectorioSeleccionado;
	}





	public JButton getBotonSeleccionar() {
		return botonSeleccionar;
	}

	public HomeFrame getHomeFrame() {
		return homeFrame;
	}

	public void setHomeFrame(HomeFrame homeFrame) {
		this.homeFrame = homeFrame;
	}



	public JTextArea getTextAreaListadoArchivos() {
		return textAreaListadoArchivos;
	}



	public void setTextAreaListadoArchivos(JTextArea textAreaListadoArchivos) {
		this.textAreaListadoArchivos = textAreaListadoArchivos;
	}





	public JButton getBotonRenumerar() {
		return botonRenumerar;
	}





	public void setBotonRenumerar(JButton botonRenumerar) {
		this.botonRenumerar = botonRenumerar;
	}


	public void setBotonSeleccionar(JButton botonSeleccionar) {
		this.botonSeleccionar = botonSeleccionar;
	}
	
	
}
