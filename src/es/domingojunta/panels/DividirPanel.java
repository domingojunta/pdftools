package es.domingojunta.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.itextpdf.kernel.log.SystemOutCounter;
import com.itextpdf.kernel.pdf.filters.IFilterHandler;

import es.domingojunta.comparators.ComparatorEnteros;
import es.domingojunta.frames.HomeFrame;
import es.domingojunta.listeners.BotonDividirArchivoPdfListener;
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
	private int[] paginasDeCorte;

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
					botonDividirArchivoPdf.setEnabled(true);
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
		
		textFieldNumerosDePaginaDeCorte.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				String paginasDeCorteString = textFieldNumerosDePaginaDeCorte.getText();
				if (paginasDeCorteString != null) {
					
					String separador = ",";
			        String[] paginasString = paginasDeCorteString.split(separador);
			        
			        
			        Set<String> paginasConjunto = new TreeSet<String>();
			        paginasConjunto.add("1");
			        paginasConjunto.add(""+numeroPaginasFicheroADividir);
			        
			        if (!paginasString[0].trim().equals("")) {
			        	for (String itemb : paginasString) {
				        	paginasConjunto.add(itemb.trim());
				        }
					}
			        
			        
			        List<String> paginasLista = new ArrayList<>();
			        for (String iteml : paginasConjunto) {
			        	paginasLista.add(iteml);
			        }
			        
			        
			        List<Integer> paginasListaEnteros = new ArrayList<>();
			        
			        
			        try {
			        	
			        	
			        	
			        	for (String item : paginasLista) {
							
							
			        		int pagina = Integer.parseInt(item);
			        		
			        		if (pagina >= 1 && pagina <= numeroPaginasFicheroADividir) {
			        			
			        			
			        			paginasListaEnteros.add(pagina);
			        			
			        		}
			        		
			        	
			        		
						}
			        	
			        	paginasListaEnteros.sort(new ComparatorEnteros());
			        	
			        	paginasDeCorte = new int[paginasListaEnteros.size()];
			        	
			        	for (int i = 0; i< paginasListaEnteros.size();i++) {
			        		
			        		paginasDeCorte[i] = paginasListaEnteros.get(i);
			        	}
			        	
			        	
			        	
			        	
			        	
						
					} catch (Exception e2) {
						e2.printStackTrace();
						String mensaje = "Debes indicar las páginas de cortes separadas por comas entre la página 1 y la página "+numeroPaginasFicheroADividir+" en su lugar has ingresado letras.";
						JOptionPane.showMessageDialog(null, mensaje,"Dividir pdf",JOptionPane.ERROR_MESSAGE);
						textFieldNumerosDePaginaDeCorte.setText("");
						textFieldNumerosDePaginaDeCorte.requestFocus();
						textFieldNumerosDePaginaDeCorte.selectAll();
					}
			        
					
				} else {
					
					String mensaje = "Debes indicar las páginas de cortes separadas por comas entre la página 1 y la página "+numeroPaginasFicheroADividir;
					JOptionPane.showMessageDialog(null, mensaje,"Dividir pdf",JOptionPane.ERROR_MESSAGE);
					textFieldNumerosDePaginaDeCorte.setText("");
					textFieldNumerosDePaginaDeCorte.requestFocus();
					textFieldNumerosDePaginaDeCorte.selectAll();
				}
				
			}
		});
		
		add(textFieldNumerosDePaginaDeCorte);
		
		botonDividirArchivoPdf = new JButton("Dividir archivo pdf");
		
		botonDividirArchivoPdf.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonDividirArchivoPdf.setBounds(182, 492, 411, 40);
		
		botonDividirArchivoPdf.addActionListener(new BotonDividirArchivoPdfListener(this));
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

	public int[] getPaginasDeCorte() {
		return paginasDeCorte;
	}

	public void setPaginasDeCorte(int[] paginasDeCorte) {
		this.paginasDeCorte = paginasDeCorte;
	}

	
	
	
}
