package es.domingojunta.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import es.domingojunta.frames.HomeFrame;
import es.domingojunta.listeners.BotonSeleccionarArchivoADividirListener;
import es.domingojunta.listeners.ComponentListenerDividirPanel;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DividirPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HomeFrame homeFrame;
	private File ficheroADividir;
	private int numeroPaginasFicheroADividir;
	private JTextField textFieldNombreFicheroADividir;
	private JButton botonSeleccionarArchivoADividir;
	private JTextField textFieldNombreBaseNuevosArchivos;
	private JTextField textFieldNumerosDePaginaDeCorte;
	private JButton botonDividirArchivoPdf;
	private JLabel labelNumerosDePaginasDeCorte;

	public DividirPanel(HomeFrame homeFrame) {
		
		
		this.homeFrame = homeFrame;
		
		setBackground(new Color(240, 240, 240, 50));
		//setBackground(Color.BLUE);
		setOpaque(false);
		setPreferredSize(new Dimension(750,650));
		setLayout(null);
		setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Dividir archivo pdf");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(27, 55, 699, 40);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		add(lblNewLabel);
		
		textFieldNombreFicheroADividir = new JTextField();
		textFieldNombreFicheroADividir.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldNombreFicheroADividir.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textFieldNombreFicheroADividir.setEnabled(false);
		textFieldNombreFicheroADividir.setBounds(27, 105, 699, 81);
		add(textFieldNombreFicheroADividir);
		textFieldNombreFicheroADividir.setColumns(10);
		
		botonSeleccionarArchivoADividir = new JButton("Seleccionar archivo a dividir");
		
		botonSeleccionarArchivoADividir.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonSeleccionarArchivoADividir.setBounds(182, 218, 411, 40);
		
		botonSeleccionarArchivoADividir.addActionListener(new BotonSeleccionarArchivoADividirListener(this));
		add(botonSeleccionarArchivoADividir);
		
		JLabel labelNombreFicheros = new JLabel("Introduce el nombre base que tendr\u00E1n los nuevos ficheros: (Se a\u00F1adir\u00E1n n\u00FAmeros...).");
		labelNombreFicheros.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelNombreFicheros.setHorizontalAlignment(SwingConstants.LEFT);
		labelNombreFicheros.setBounds(27, 289, 699, 40);
		add(labelNombreFicheros);
		
		textFieldNombreBaseNuevosArchivos = new JTextField();
		
		
		
		textFieldNombreBaseNuevosArchivos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textFieldNombreBaseNuevosArchivos.setEnabled(false);
		textFieldNombreBaseNuevosArchivos.setBounds(27, 327, 699, 40);
		
		textFieldNombreBaseNuevosArchivos.setColumns(10);
		textFieldNombreBaseNuevosArchivos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				String nombreBase = textFieldNombreBaseNuevosArchivos.getText();
				if (nombreBase != null  && nombreBase.length()>0) {
					
					textFieldNumerosDePaginaDeCorte.setEnabled(true);
					textFieldNumerosDePaginaDeCorte.requestFocus();
					textFieldNumerosDePaginaDeCorte.selectAll();
					
				} else {
					
					JOptionPane.showMessageDialog(null, "El nombre base no puede estar en blanco...", "Dividir pdf", JOptionPane.ERROR_MESSAGE);
					textFieldNombreBaseNuevosArchivos.setText("");
					textFieldNombreBaseNuevosArchivos.requestFocus();
					textFieldNombreBaseNuevosArchivos.selectAll();
				}
			
			}
		});
		
		add(textFieldNombreBaseNuevosArchivos);
		
		labelNumerosDePaginasDeCorte = new JLabel("Introduce los n\u00FAmeros de p\u00E1gina de corte separados por comas...");
		labelNumerosDePaginasDeCorte.setHorizontalAlignment(SwingConstants.LEFT);
		labelNumerosDePaginasDeCorte.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelNumerosDePaginasDeCorte.setBounds(27, 389, 699, 40);
		add(labelNumerosDePaginasDeCorte);
		
		textFieldNumerosDePaginaDeCorte = new JTextField();
		textFieldNumerosDePaginaDeCorte.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textFieldNumerosDePaginaDeCorte.setEnabled(false);
		textFieldNumerosDePaginaDeCorte.setColumns(10);
		textFieldNumerosDePaginaDeCorte.setBounds(27, 423, 699, 40);
		add(textFieldNumerosDePaginaDeCorte);
		
		botonDividirArchivoPdf = new JButton("Dividir archivo pdf");
		botonDividirArchivoPdf.setEnabled(false);
		botonDividirArchivoPdf.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonDividirArchivoPdf.setBounds(182, 492, 411, 40);
		add(botonDividirArchivoPdf);
		
		
		addComponentListener(new ComponentListenerDividirPanel(this));
		
	}

	public HomeFrame getHomeFrame() {
		return homeFrame;
	}

	public void setHomeFrame(HomeFrame homeFrame) {
		this.homeFrame = homeFrame;
	}

	public File getFicheroADividir() {
		return ficheroADividir;
	}

	public void setFicheroADividir(File ficheroADividir) {
		this.ficheroADividir = ficheroADividir;
	}

	public JTextField getTextFieldNombreFicheroADividir() {
		return textFieldNombreFicheroADividir;
	}

	public void setTextFieldNombreFicheroADividir(JTextField textFieldNombreFicheroADividir) {
		this.textFieldNombreFicheroADividir = textFieldNombreFicheroADividir;
	}

	public JButton getBotonSeleccionarArchivoADividir() {
		return botonSeleccionarArchivoADividir;
	}

	public void setBotonSeleccionarArchivoADividir(JButton botonSeleccionarArchivoADividir) {
		this.botonSeleccionarArchivoADividir = botonSeleccionarArchivoADividir;
	}

	public JTextField getTextFieldNombreBaseNuevosArchivos() {
		return textFieldNombreBaseNuevosArchivos;
	}

	public void setTextFieldNombreBaseNuevosArchivos(JTextField textFieldNombreBaseNuevosArchivos) {
		this.textFieldNombreBaseNuevosArchivos = textFieldNombreBaseNuevosArchivos;
	}

	public JTextField getTextFieldNumerosDePaginaDeCorte() {
		return textFieldNumerosDePaginaDeCorte;
	}

	public void setTextFieldNumerosDePaginaDeCorte(JTextField textFieldNumerosDePaginaDeCorte) {
		this.textFieldNumerosDePaginaDeCorte = textFieldNumerosDePaginaDeCorte;
	}

	public JButton getBotonDividirArchivoPdf() {
		return botonDividirArchivoPdf;
	}

	public void setBotonDividirArchivoPdf(JButton botonDividirArchivoPdf) {
		this.botonDividirArchivoPdf = botonDividirArchivoPdf;
	}

	public int getNumeroPaginasFicheroADividir() {
		return numeroPaginasFicheroADividir;
	}

	public void setNumeroPaginasFicheroADividir(int numeroPaginasFicheroADividir) {
		this.numeroPaginasFicheroADividir = numeroPaginasFicheroADividir;
	}

	public JLabel getLabelNumerosDePaginasDeCorte() {
		return labelNumerosDePaginasDeCorte;
	}

	public void setLabelNumerosDePaginasDeCorte(JLabel labelNumerosDePaginasDeCorte) {
		this.labelNumerosDePaginasDeCorte = labelNumerosDePaginasDeCorte;
	}
	
	
}
