package es.domingojunta.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import es.domingojunta.entities.FicherosSeleccionadosModel;
import es.domingojunta.frames.HomeFrame;
import es.domingojunta.listeners.BorrarFicherosListener;
import es.domingojunta.listeners.ListMultipleFileSelectionListener;
import es.domingojunta.listeners.RellenarListaFicherosBorrarListener;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BorrarArchivoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton botonBorrarFicherosSeleccionados;
	private JList listFicherosEnDirectorio;
	private File[] ficherosEnDirectorio;
	private Set<File> ficherosSeleccionadosParaSerBorrados = new HashSet<File>();
	private HomeFrame homeFrame;

	public BorrarArchivoPanel(HomeFrame homeFrame) {
		
		this.homeFrame = homeFrame;
		
		
		setBackground(new Color(240, 240, 240, 50));
		//setBackground(Color.BLUE);
		setOpaque(false);
		setPreferredSize(new Dimension(750,650));
		setLayout(null);
		setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Borrar archivo/s pdf/s");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(30, 30, 699, 40);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Listado de ficheros en directorio de trabajo");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(30, 87, 620, 40);
		add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 130, 699, 421);
		add(scrollPane);
		//System.out.println("El directorio de trabajo es: "+ homeFrame.getDirectorioDeTrabajo());
		//File directorioDeTrabajo = new File(homeFrame.getDirectorioDeTrabajo());
		//File[] ficherosEnDirectorioTrabajo = directorioDeTrabajo.listFiles();
		
		
		listFicherosEnDirectorio = new JList();
		listFicherosEnDirectorio.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		listFicherosEnDirectorio.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
		listFicherosEnDirectorio.addListSelectionListener(new ListMultipleFileSelectionListener(this));
		scrollPane.setViewportView(listFicherosEnDirectorio);
		
		botonBorrarFicherosSeleccionados = new JButton("Borrar ficheros seleccionados");
		botonBorrarFicherosSeleccionados.setForeground(Color.BLACK);
		botonBorrarFicherosSeleccionados.setBackground(Color.RED);
		botonBorrarFicherosSeleccionados.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonBorrarFicherosSeleccionados.setBounds(215, 582, 358, 40);
		botonBorrarFicherosSeleccionados.setEnabled(false);
		botonBorrarFicherosSeleccionados.addActionListener(new BorrarFicherosListener(this));
		add(botonBorrarFicherosSeleccionados);
		
		
		addComponentListener(new RellenarListaFicherosBorrarListener(this));
	}

	public JButton getBotonBorrarFicherosSeleccionados() {
		return botonBorrarFicherosSeleccionados;
	}

	public void setBotonBorrarFicherosSeleccionados(JButton botonBorrarFicherosSeleccionados) {
		this.botonBorrarFicherosSeleccionados = botonBorrarFicherosSeleccionados;
	}

	public JList getListFicherosEnDirectorio() {
		return listFicherosEnDirectorio;
	}

	public void setListFicherosEnDirectorio(JList listFicherosEnDirectorio) {
		this.listFicherosEnDirectorio = listFicherosEnDirectorio;
	}

	public HomeFrame getHomeFrame() {
		return homeFrame;
	}

	public void setHomeFrame(HomeFrame homeFrame) {
		this.homeFrame = homeFrame;
	}

	

	

	public Set<File> getFicherosSeleccionadosParaSerBorrados() {
		return ficherosSeleccionadosParaSerBorrados;
	}

	public void setFicherosSeleccionadosParaSerBorrados(Set<File> ficherosSeleccionadosParaSerBorrados) {
		this.ficherosSeleccionadosParaSerBorrados = ficherosSeleccionadosParaSerBorrados;
	}

	public File[] getFicherosEnDirectorio() {
		return ficherosEnDirectorio;
	}

	public void setFicherosEnDirectorio(File[] ficherosEnDirectorio) {
		this.ficherosEnDirectorio = ficherosEnDirectorio;
	}
	
	
	
}
