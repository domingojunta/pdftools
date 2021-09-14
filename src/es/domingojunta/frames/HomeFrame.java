package es.domingojunta.frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import es.domingojunta.entities.ExpedienteEntity;
import es.domingojunta.listeners.AboutListener;
import es.domingojunta.listeners.BorrarListener;
import es.domingojunta.listeners.ConfiguracionPanelListener;
import es.domingojunta.listeners.DividirListener;
import es.domingojunta.listeners.NombrarListener;
import es.domingojunta.listeners.PaginarListener;
import es.domingojunta.listeners.SalirListener;
import es.domingojunta.listeners.SeleccionarDirectorioListener;
import es.domingojunta.listeners.UnirListener;
import es.domingojunta.panels.MenuCentralPanel;
import es.domingojunta.panels.LogoJuntaPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class HomeFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu menuArchivo;
	private JMenu menuGestionPdf;
	private JMenu menuAyuda;
	private JMenu menuEdicion;
	private JMenuItem itemAbout;
	private JMenuItem itemSeleccionarDirectorio;
	private JMenuItem itemSalir;
	private JMenuItem itemUnirPdf;
	private JMenuItem itemDividirPdf;
	private JMenuItem itemNombrarPdf;
	private JMenuItem itemBorrarPdf;
	private JMenuItem itemPaginar;
	private JMenuItem itemEdicionConfiguracion;
	private MenuCentralPanel menuCentral;
	private JPanel menuLateralPanel;
	private JButton botonSeleccionarDirectorio;
	private JButton botonUnirPdf;
	private JButton botonDividirPdf;
	private JButton botonNombrarPdf;
	private JButton botonBorrarPdf;
	private JButton botonPaginar;
	private ExpedienteEntity expedienteEntity;
	private  String directorioDeTrabajo = null;
	private JLabel labelLogoMenuLaterial;
	
	
	public HomeFrame(ExpedienteEntity expedienteEntity) {
		
		
		this.expedienteEntity = expedienteEntity;
		
		setSize(1000,700);
		setDefaultLookAndFeelDecorated(true);
		try {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			
			try {
				UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			} catch (Exception e2) {
				System.out.println("No estoy estableciendo lookandFeel");
			}
			
		
		}
		setLocation(50,50);
		
		//setBackground(Color.BLUE);
		setTitle("Pdf Tools");
		
		Image icono;
		try {
			icono = ImageIO.read(new File("images/pdf-logo.png"));
			setIconImage(icono);
		} catch (IOException e) {
			System.out.println("No se ha encontrado la imagen images/pdf-logo.png");
		}
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Barra de Menú //=====================================================================
		
		//MenuBar menuBar = new MenuBar();
		
		menuBar = new JMenuBar();
		
		menuArchivo = new JMenu("Archivo");
		menuEdicion = new JMenu("Edición");
		menuGestionPdf = new JMenu("Gestión PDF");
		menuAyuda = new JMenu("Ayuda");
		
		//MenuArchivo
		itemSeleccionarDirectorio = new JMenuItem("Seleccionar directorio",new ImageIcon("images/SelectFileGroup_16x.png"));
		itemSeleccionarDirectorio.addActionListener(new SeleccionarDirectorioListener(this));
		itemNombrarPdf = new JMenuItem("Nombrar",new ImageIcon("images/Rename_16x.png"));
		itemNombrarPdf.addActionListener(new NombrarListener(this));
		itemBorrarPdf = new JMenuItem("Borrar",new ImageIcon("images/DeleteListItem_16x.png"));
		itemBorrarPdf.addActionListener(new BorrarListener(this));
		JSeparator separador = new JSeparator();
		itemSalir = new JMenuItem("Salir",new ImageIcon("images/Exit_16x.png"));
		itemSalir.addActionListener(new SalirListener());
		
		menuArchivo.add(itemSeleccionarDirectorio);
		menuArchivo.add(itemNombrarPdf);
		menuArchivo.add(itemBorrarPdf);
		menuArchivo.add(separador);
		menuArchivo.add(itemSalir);
		
		//Menu Edición
		
		itemEdicionConfiguracion = new JMenuItem("Configuración", new ImageIcon("images/ConfigurationFile_16x.png"));
		itemEdicionConfiguracion.addActionListener(new ConfiguracionPanelListener(this));
		menuEdicion.add(itemEdicionConfiguracion);
		
		//Menu Ayuda
		itemAbout = new JMenuItem("About",new ImageIcon("images/HelpApplication_16x.png"));
		itemAbout.addActionListener(new AboutListener(this));
		menuAyuda.add(itemAbout);
		
		//Menu Gestión Pdf
		
		itemUnirPdf = new JMenuItem("Unir",new ImageIcon("images/Add_16x.png"));
		itemUnirPdf.addActionListener(new UnirListener(this));
		itemDividirPdf = new JMenuItem("Dividir",new ImageIcon("images/DividePath_16x.png"));
		itemDividirPdf.addActionListener(new DividirListener(this));
		itemPaginar = new JMenuItem("Paginar y Generar Índice",new ImageIcon("images/SelectFileGroup_16x.png"));
		itemPaginar.addActionListener(new PaginarListener(this));
		JSeparator separador2 = new JSeparator();
		
		menuGestionPdf.add(itemUnirPdf);
		menuGestionPdf.add(itemDividirPdf);
		menuGestionPdf.add(separador2);
		menuGestionPdf.add(itemPaginar);
		
		
		menuBar.add(menuArchivo);
		menuBar.add(menuEdicion);
		menuBar.add(menuGestionPdf);
		menuBar.add(menuAyuda);
		
		
		setJMenuBar(menuBar);
		
		getContentPane().setBackground(new Color(240,240,240,50));
		getContentPane().setLayout(new BorderLayout());
		
		//HomePanel homePanel = new HomePanel();
		//this.getContentPane().add(homePanel);
		
		
		// Menú Lateral // =======================================
		
		
		menuLateralPanel = new JPanel();
		
		menuLateralPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		menuLateralPanel.setLayout(null);
		menuLateralPanel.setBackground(new Color(224, 255, 255));
		menuLateralPanel.setBounds(0, 0, 300, 650);
		
		botonSeleccionarDirectorio = new JButton("Seleccionar directorio",new ImageIcon("images/SelectFileGroup_16x.png"));
		botonSeleccionarDirectorio.setHorizontalAlignment(SwingConstants.LEFT);
		botonSeleccionarDirectorio.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonSeleccionarDirectorio.setBounds(new Rectangle(10, 220, 230, 40));
		botonSeleccionarDirectorio.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonSeleccionarDirectorio.addActionListener(new SeleccionarDirectorioListener(this));
		
		botonUnirPdf = new JButton("Unir Pdf's",new ImageIcon("images/Add_16x.png"));
		botonUnirPdf.setHorizontalAlignment(SwingConstants.LEFT);
		botonUnirPdf.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonUnirPdf.setBounds(new Rectangle(10, 280, 230, 40));
		botonUnirPdf.addActionListener(new UnirListener(this));
		
		botonDividirPdf = new JButton("Dividir Pdf's",new ImageIcon("images/DividePath_16x.png"));
		botonDividirPdf.setHorizontalAlignment(SwingConstants.LEFT);
		botonDividirPdf.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonDividirPdf.setBounds(10, 340, 230, 40);
		botonDividirPdf.addActionListener(new DividirListener(this));
		
		botonNombrarPdf = new JButton("Nombrar archivo",new ImageIcon("images/Rename_16x.png"));
		botonNombrarPdf.setHorizontalAlignment(SwingConstants.LEFT);
		botonNombrarPdf.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonNombrarPdf.setBounds(10, 400, 230, 40);
		botonNombrarPdf.addActionListener(new NombrarListener(this));
		
		botonBorrarPdf = new JButton("Borrar archivo",new ImageIcon("images/DeleteListItem_16x.png"));
		botonBorrarPdf.setHorizontalAlignment(SwingConstants.LEFT);
		botonBorrarPdf.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonBorrarPdf.setBounds(10, 460, 230, 40);
		botonBorrarPdf.addActionListener(new BorrarListener(this));
		
		botonPaginar = new JButton("Paginar y Generar Índice",new ImageIcon("images/SelectFileGroup_16x.png"));
		botonPaginar.setHorizontalAlignment(SwingConstants.LEFT);
		botonPaginar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonPaginar.setBounds(10, 520, 230, 40);
		botonPaginar.addActionListener(new PaginarListener(this));
				
		menuLateralPanel.add(botonSeleccionarDirectorio);
		menuLateralPanel.add(botonUnirPdf);
		menuLateralPanel.add(botonDividirPdf);
		menuLateralPanel.add(botonNombrarPdf);
		menuLateralPanel.add(botonBorrarPdf);
		menuLateralPanel.add(botonPaginar);
		
		
		menuLateralPanel.setPreferredSize(new Dimension(250, 650));
		menuLateralPanel.setVisible(true);
		getContentPane().add(menuLateralPanel, BorderLayout.WEST);
		
		labelLogoMenuLaterial = new JLabel("");
		labelLogoMenuLaterial.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		labelLogoMenuLaterial.setBounds(50, 30, 150, 160);
		ImageIcon imagen = new ImageIcon(expedienteEntity.getLogo());
		int width = labelLogoMenuLaterial.getWidth();
		int height = labelLogoMenuLaterial.getHeight();
		Icon iconoTrabajando = new ImageIcon(imagen.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		labelLogoMenuLaterial.setIcon(iconoTrabajando);
		menuLateralPanel.add(labelLogoMenuLaterial);
		
		
		//Menú Central ==============================================
		
		menuCentral = new MenuCentralPanel(this);
		menuCentral.setPreferredSize(new Dimension(750,650));
		menuCentral.setVisible(true);
		getContentPane().add(menuCentral, BorderLayout.CENTER);
		
		if (directorioDeTrabajo==null) {
			//System.out.println("el directorio de trabajo es nulo");
			//itemAbout.disable();
			itemBorrarPdf.setEnabled(false);
			itemDividirPdf.setEnabled(false);
			itemNombrarPdf.setEnabled(false);
			itemPaginar.setEnabled(false);
			itemUnirPdf.setEnabled(false);
			botonBorrarPdf.setEnabled(false);
			botonDividirPdf.setEnabled(false);
			botonNombrarPdf.setEnabled(false);
			botonPaginar.setEnabled(false);
			botonUnirPdf.setEnabled(false);
			
			
		} else {
			//System.out.println("el directorio de trabajo NO es nulo");
			itemBorrarPdf.setEnabled(true);
			itemDividirPdf.setEnabled(true);
			itemNombrarPdf.setEnabled(true);
			itemPaginar.setEnabled(true);
			itemUnirPdf.setEnabled(true);
			botonBorrarPdf.setEnabled(true);
			botonDividirPdf.setEnabled(true);
			botonNombrarPdf.setEnabled(true);
			botonPaginar.setEnabled(true);
			botonUnirPdf.setEnabled(true);
		}
		
		
		getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				ImageIcon imagen = new ImageIcon(expedienteEntity.getLogo());
				int width = labelLogoMenuLaterial.getWidth();
				int height = labelLogoMenuLaterial.getHeight();
				Icon iconoTrabajando = new ImageIcon(imagen.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
				labelLogoMenuLaterial.setIcon(iconoTrabajando);
			}
		});
		
		
	}

	
	public void repintarHomeFrame( ) {
		
		
		ImageIcon imagen = new ImageIcon(expedienteEntity.getLogo());
		int width = labelLogoMenuLaterial.getWidth();
		int height = labelLogoMenuLaterial.getHeight();
		Icon iconoTrabajando = new ImageIcon(imagen.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		labelLogoMenuLaterial.setIcon(iconoTrabajando);
		
		if (directorioDeTrabajo==null) {
			//System.out.println("el directorio de trabajo es nulo");
			//itemAbout.disable();
			itemBorrarPdf.setEnabled(false);
			itemDividirPdf.setEnabled(false);
			itemNombrarPdf.setEnabled(false);
			itemPaginar.setEnabled(false);
			itemUnirPdf.setEnabled(false);
			botonBorrarPdf.setEnabled(false);
			botonDividirPdf.setEnabled(false);
			botonNombrarPdf.setEnabled(false);
			botonPaginar.setEnabled(false);
			botonUnirPdf.setEnabled(false);
			
			
		} else {
			//System.out.println("el directorio de trabajo NO es nulo");
			itemBorrarPdf.setEnabled(true);
			itemDividirPdf.setEnabled(true);
			itemNombrarPdf.setEnabled(true);
			itemPaginar.setEnabled(true);
			itemUnirPdf.setEnabled(true);
			botonBorrarPdf.setEnabled(true);
			botonDividirPdf.setEnabled(true);
			botonNombrarPdf.setEnabled(true);
			botonPaginar.setEnabled(true);
			botonUnirPdf.setEnabled(true);
		}
	}

	public MenuCentralPanel getMenuCentral() {
		return menuCentral;
	}


	
	public JPanel getMenuLateralPanel() {
		return menuLateralPanel;
	}


	public String getDirectorioDeTrabajo() {
		return directorioDeTrabajo;
	}


	public void setDirectorioDeTrabajo(String directorioDeTrabajo) {
		this.directorioDeTrabajo = directorioDeTrabajo;
	}


	public ExpedienteEntity getExpedienteEntity() {
		return expedienteEntity;
	}


	public void setExpedienteEntity(ExpedienteEntity expedienteEntity) {
		this.expedienteEntity = expedienteEntity;
	}
	
	
	
	}
	

