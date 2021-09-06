package es.domingojunta.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import es.domingojunta.frames.HomeFrame;
import es.domingojunta.listeners.BotonSeleccionarArchivosAUnirListener;
import es.domingojunta.listeners.BotonUnirListener;

import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class UnirPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton botonSeleccionar;
	private HomeFrame homeFrame;
	private JTextArea textAreaFicherosSeleccionados;
	private JTextField textFieldNombreArchivo;
	private JTextArea textAreaComentarioNuevoArchivo;
	private JButton botonUnir;
	private JLabel labelNombre;
	private JLabel labelComentario;
	private JScrollPane scrollPaneComentario;
	private File[] ficherosSeleccionadosOrdenados;
	
	

	public UnirPanel(HomeFrame homeFrame) {
		
		
		this.homeFrame = homeFrame;
		
		
		setBackground(new Color(240, 240, 240, 50));
		//setBackground(Color.BLUE);
		setOpaque(false);
		setPreferredSize(new Dimension(750,650));
		setLayout(null);
		setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Unir varios archivos pdf's");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(30, 30, 699, 40);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel.setBackground(new Color(240,240,240));
		add(lblNewLabel);
		
		JLabel lblElDirectorioDe = new JLabel("Los ficheros seleccionados para unir son:");
		lblElDirectorioDe.setVerticalAlignment(SwingConstants.TOP);
		lblElDirectorioDe.setForeground(Color.RED);
		lblElDirectorioDe.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblElDirectorioDe.setAlignmentX(0.5f);
		lblElDirectorioDe.setBounds(29, 83, 400, 30);
		lblElDirectorioDe.setBackground(new Color(240,240,240));
		add(lblElDirectorioDe);
		
		JScrollPane scrollPaneDirectorioActual = new JScrollPane();
		scrollPaneDirectorioActual.setBounds(30, 123, 699, 122);
		add(scrollPaneDirectorioActual);
		
		textAreaFicherosSeleccionados = new JTextArea();
		textAreaFicherosSeleccionados.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrollPaneDirectorioActual.setViewportView(textAreaFicherosSeleccionados);
		
		botonSeleccionar = new JButton("Seleccionar ficheros a unir");
		botonSeleccionar.addActionListener(new BotonSeleccionarArchivosAUnirListener(this));
		botonSeleccionar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonSeleccionar.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonSeleccionar.setBounds(234, 273, 321, 30);
		botonSeleccionar.setBackground(new Color(240,240,240));
		add(botonSeleccionar);
		
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
		textFieldNombreArchivo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				String texto = textFieldNombreArchivo.getText();
				
				//System.out.println("textFieldNombreArchivo ha perdido el foco");
				//System.out.println("El texto es: "+ texto);
				
				if (texto != null && (!texto.trim().equals(""))) {
					botonUnir.setEnabled(true);
				} else {
					textFieldNombreArchivo.requestFocus();
					textFieldNombreArchivo.selectAll();
				}
			}
		});
		
		textFieldNombreArchivo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldNombreArchivo.setBounds(29, 353, 700, 55);
		add(textFieldNombreArchivo);
		textFieldNombreArchivo.setColumns(10);
		
		scrollPaneComentario = new JScrollPane();
		scrollPaneComentario.setBounds(29, 458, 700, 94);
		add(scrollPaneComentario);
		
		textAreaComentarioNuevoArchivo = new JTextArea();
		textAreaComentarioNuevoArchivo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textAreaComentarioNuevoArchivo.setLineWrap(true);
		scrollPaneComentario.setViewportView(textAreaComentarioNuevoArchivo);
		
		botonUnir = new JButton("Unir pdfs");
		botonUnir.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonUnir.setAlignmentX(0.5f);
		botonUnir.setBounds(234, 581, 321, 30);
		botonUnir.setBackground(new Color(240,240,240));
		botonUnir.addActionListener(new BotonUnirListener(this));
		add(botonUnir);
		
		ocultarParteInferior();
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				textAreaFicherosSeleccionados.setText("...");
				ocultarParteInferior();
			}
		});
	}

	public JButton getBotonSeleccionar() {
		return botonSeleccionar;
	}

	public void setBotonSeleccionar(JButton botonSeleccionar) {
		this.botonSeleccionar = botonSeleccionar;
	}

	public HomeFrame getHomeFrame() {
		return homeFrame;
	}

	public void setHomeFrame(HomeFrame homeFrame) {
		this.homeFrame = homeFrame;
	}

	public JTextArea getTextAreaFicherosSeleccionados() {
		return textAreaFicherosSeleccionados;
	}

	public void setTextAreaFicherosSeleccionados(JTextArea textAreaFicherosSeleccionados) {
		this.textAreaFicherosSeleccionados = textAreaFicherosSeleccionados;
	}

	public JTextField getTextFieldNombreArchivo() {
		return textFieldNombreArchivo;
	}

	public void setTextFieldNombreArchivo(JTextField textFieldNombreArchivo) {
		this.textFieldNombreArchivo = textFieldNombreArchivo;
	}

	public JTextArea getTextAreaComentarioNuevoArchivo() {
		return textAreaComentarioNuevoArchivo;
	}

	public void setTextAreaComentarioNuevoArchivo(JTextArea textAreaComentarioNuevoArchivo) {
		this.textAreaComentarioNuevoArchivo = textAreaComentarioNuevoArchivo;
	}

	public JButton getBotonUnir() {
		return botonUnir;
	}

	public void setBotonUnir(JButton botonUnir) {
		this.botonUnir = botonUnir;
	}
	
	
	
	
	
	public File[] getFicherosSeleccionadosOrdenados() {
		return ficherosSeleccionadosOrdenados;
	}

	public void setFicherosSeleccionadosOrdenados(File[] ficherosSeleccionadosOrdenados) {
		this.ficherosSeleccionadosOrdenados = ficherosSeleccionadosOrdenados;
	}

	public void ocultarParteInferior() {
		
		scrollPaneComentario.setVisible(false);
		textFieldNombreArchivo.setVisible(false);
		textAreaComentarioNuevoArchivo.setVisible(false);
		botonUnir.setVisible(false);
		labelNombre.setVisible(false);
		labelComentario.setVisible(false);
	}
	
	public void mostrarParteInferior() {
		
		scrollPaneComentario.setVisible(true);
		textFieldNombreArchivo.setVisible(true);
		textAreaComentarioNuevoArchivo.setVisible(true);
		botonUnir.setVisible(true);
		labelNombre.setVisible(true);
		labelComentario.setVisible(true);
	}
	
	
}
