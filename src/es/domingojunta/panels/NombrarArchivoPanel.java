package es.domingojunta.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import es.domingojunta.frames.HomeFrame;
import es.domingojunta.listeners.BotonRenombrarFicheroListener;
import es.domingojunta.listeners.BotonUnirListener;
import es.domingojunta.listeners.ListMultipleFileSelectionListener;
import es.domingojunta.listeners.ListSimpleFileSelectionListener;
import es.domingojunta.listeners.RellenarListaFicherosBorrarListener;
import es.domingojunta.listeners.RellenarListaFicherosRenombrarListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;

public class NombrarArchivoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File[] ficherosEnDirectorio;
	private JList listFicherosEnDirectorio;
	private HomeFrame homeFrame;
	private File ficheroSeleccionadoParaRenombrarlo;
	private JButton botonRenombrar;
	private JLabel labelNombre;
	private JLabel labelComentario;
	private JScrollPane scrollPaneComentario;
	private JTextField textFieldNombreArchivo;
	private JTextArea textAreaComentarioArchivo;
	

	public NombrarArchivoPanel(HomeFrame homeFrame) {
		
		
		this.homeFrame = homeFrame;
		
		setBackground(new Color(240, 240, 240, 50));
		//setBackground(Color.BLUE);
		setOpaque(false);
		setPreferredSize(new Dimension(750,650));
		setLayout(null);
		setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Renombrar archivos pdf");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(26, 40, 690, 40);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 86, 699, 217);
		add(scrollPane);
		
		listFicherosEnDirectorio = new JList();
		listFicherosEnDirectorio.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		listFicherosEnDirectorio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Controlar la selección de ficheros en el panel.
		listFicherosEnDirectorio.addListSelectionListener(new ListSimpleFileSelectionListener(this));
		scrollPane.setViewportView(listFicherosEnDirectorio);
		
		
		addComponentListener(new RellenarListaFicherosRenombrarListener(this));
		
		labelNombre = new JLabel("Nombre del nuevo archivo: (* campo obligatorio)");
		labelNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelNombre.setBounds(29, 313, 551, 30);
		labelNombre.setBackground(new Color(240,240,240));
		add(labelNombre);
		
		labelComentario = new JLabel("Comentario del nuevo archivo:");
		labelComentario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelComentario.setBounds(29, 418, 330, 30);
		labelComentario.setBackground(new Color(240,240,240));
		add(labelComentario);
		
		textFieldNombreArchivo = new JTextField();
		textFieldNombreArchivo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldNombreArchivo.setBounds(29, 353, 700, 55);
		textFieldNombreArchivo.setColumns(10);
		textFieldNombreArchivo.setEnabled(true);
		
		textFieldNombreArchivo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				botonRenombrar.setEnabled(false);
				String texto = textFieldNombreArchivo.getText();
				
				//System.out.println("textFieldNombreArchivo ha perdido el foco");
				//System.out.println("El texto es: "+ texto);
				
				if (texto != null && (!texto.trim().equals(""))) {
					botonRenombrar.setEnabled(true);
				} else {
					textFieldNombreArchivo.requestFocus();
					textFieldNombreArchivo.selectAll();
				}
			}
		});
		
		
		add(textFieldNombreArchivo);
		
		
		scrollPaneComentario = new JScrollPane();
		scrollPaneComentario.setBounds(29, 458, 700, 94);
		add(scrollPaneComentario);
		
		textAreaComentarioArchivo = new JTextArea();
		textAreaComentarioArchivo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textAreaComentarioArchivo.setLineWrap(true);
		textAreaComentarioArchivo.setEnabled(true);
		scrollPaneComentario.setViewportView(textAreaComentarioArchivo);
		
		botonRenombrar = new JButton("Renombrar archivo");
		botonRenombrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonRenombrar.setAlignmentX(0.5f);
		botonRenombrar.setBounds(234, 581, 321, 30);
		botonRenombrar.setBackground(new Color(240,240,240));
		botonRenombrar.setEnabled(true);
		botonRenombrar.addActionListener(new BotonRenombrarFicheroListener(this));
		add(botonRenombrar);
		
		
	}

	public File[] getFicherosEnDirectorio() {
		return ficherosEnDirectorio;
	}

	public void setFicherosEnDirectorio(File[] ficherosEnDirectorio) {
		this.ficherosEnDirectorio = ficherosEnDirectorio;
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

	public File getFicheroSeleccionadoParaRenombrarlo() {
		return ficheroSeleccionadoParaRenombrarlo;
	}

	public void setFicheroSeleccionadoParaRenombrarlo(File ficheroSeleccionadoParaRenombrarlo) {
		this.ficheroSeleccionadoParaRenombrarlo = ficheroSeleccionadoParaRenombrarlo;
	}

	public JButton getBotonRenombrar() {
		return botonRenombrar;
	}

	public void setBotonRenombrar(JButton botonRenombrar) {
		this.botonRenombrar = botonRenombrar;
	}

	public JTextField getTextFieldNombreArchivo() {
		return textFieldNombreArchivo;
	}

	public void setTextFieldNombreArchivo(JTextField textFieldNombreArchivo) {
		this.textFieldNombreArchivo = textFieldNombreArchivo;
	}

	public JTextArea getTextAreaComentarioArchivo() {
		return textAreaComentarioArchivo;
	}

	public void setTextAreaComentarioArchivo(JTextArea textAreaComentarioNuevoArchivo) {
		this.textAreaComentarioArchivo = textAreaComentarioNuevoArchivo;
	}
	
	
	
}
