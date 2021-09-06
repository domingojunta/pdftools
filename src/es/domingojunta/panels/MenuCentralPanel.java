package es.domingojunta.panels;

import javax.swing.JPanel;

import es.domingojunta.frames.HomeFrame;

import java.awt.Color;

public class MenuCentralPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AboutPanel aboutPanel;
	private SeleccionarDirectorioPanel seleccionarDirectorioPanel;
	private DividirPanel dividirPanel;
	private UnirPanel unirPanel;
	private NombrarArchivoPanel nombrarArchivoPanel;
	private BorrarArchivoPanel borrarArchivoPanel;
	private PaginarEIndicePanel paginarEIndicePanel;
	private HomeFrame homeFrame;
	
	
	public MenuCentralPanel(HomeFrame homeFrame) {
		
		this.homeFrame = homeFrame;
		setBackground(new Color(240,240,240,50));
		
		aboutPanel = new AboutPanel();
		add(aboutPanel);
		
		seleccionarDirectorioPanel = new SeleccionarDirectorioPanel(homeFrame);
		add(seleccionarDirectorioPanel);
		
		unirPanel = new UnirPanel(homeFrame);
		add(unirPanel);
		
		dividirPanel = new DividirPanel(homeFrame);
		add(dividirPanel);
		
		nombrarArchivoPanel = new NombrarArchivoPanel(homeFrame);
		add(nombrarArchivoPanel);
		
		borrarArchivoPanel = new BorrarArchivoPanel(homeFrame);
		add(borrarArchivoPanel);
		
		paginarEIndicePanel = new PaginarEIndicePanel();
		add(paginarEIndicePanel);
		
		aboutPanel.setVisible(true);
	}
	

	public void mostrarSeleccionarDirectorioPanel() {
		
		limpiarTodo();
		
		seleccionarDirectorioPanel.setVisible(true);
		
	}
	
	public void mostrarAboutPanel() {
		
		limpiarTodo();
		
		aboutPanel.setVisible(true);
		
	}
	
	public void mostrarUnirPanel() {
		
		
		limpiarTodo();
		
		unirPanel.setVisible(true);
		
		
	}
	
	public void mostrarDividirPanel() {
		
		limpiarTodo();
		
		dividirPanel.setVisible(true);
		
		
	}
	
	public void mostrarNombrarArchivoPanel() {
		
		limpiarTodo();
		//System.out.println("Mostrando Panel nombrar archivo...");
		nombrarArchivoPanel.setVisible(true);
		
		
	}
	
	public void mostrarBorrarArchivoPanel() {
		
		limpiarTodo();
		
		borrarArchivoPanel.setVisible(true);
		
		
	}
	
	public void mostrarPaginarEIndicePanel() {
		
		limpiarTodo();
		
		paginarEIndicePanel.setVisible(true);
		
	}
	
	public void limpiarTodo() {
		
		homeFrame.repintarHomeFrame();
		aboutPanel.setVisible(false);
		seleccionarDirectorioPanel.setVisible(false);
		unirPanel.setVisible(false);
		dividirPanel.setVisible(false);
		nombrarArchivoPanel.setVisible(false);
		borrarArchivoPanel.setVisible(false);
		paginarEIndicePanel.setVisible(false);
		
	}


	public HomeFrame getHomeFrame() {
		return homeFrame;
	}


	public void setHomeFrame(HomeFrame homeFrame) {
		this.homeFrame = homeFrame;
	}


	public AboutPanel getAboutPanel() {
		return aboutPanel;
	}


	public void setAboutPanel(AboutPanel aboutPanel) {
		this.aboutPanel = aboutPanel;
	}


	public SeleccionarDirectorioPanel getSeleccionarDirectorioPanel() {
		return seleccionarDirectorioPanel;
	}


	public void setSeleccionarDirectorioPanel(SeleccionarDirectorioPanel seleccionarDirectorioPanel) {
		this.seleccionarDirectorioPanel = seleccionarDirectorioPanel;
	}


	public DividirPanel getDividirPanel() {
		return dividirPanel;
	}


	public void setDividirPanel(DividirPanel dividirPanel) {
		this.dividirPanel = dividirPanel;
	}


	public UnirPanel getUnirPanel() {
		return unirPanel;
	}


	public void setUnirPanel(UnirPanel unirPanel) {
		this.unirPanel = unirPanel;
	}


	public NombrarArchivoPanel getNombrarArchivoPanel() {
		return nombrarArchivoPanel;
	}


	public void setNombrarArchivoPanel(NombrarArchivoPanel nombrarArchivoPanel) {
		this.nombrarArchivoPanel = nombrarArchivoPanel;
	}


	public BorrarArchivoPanel getBorrarArchivoPanel() {
		return borrarArchivoPanel;
	}


	public void setBorrarArchivoPanel(BorrarArchivoPanel borrarArchivoPanel) {
		this.borrarArchivoPanel = borrarArchivoPanel;
	}


	public PaginarEIndicePanel getPaginarEIndicePanel() {
		return paginarEIndicePanel;
	}


	public void setPaginarEIndicePanel(PaginarEIndicePanel paginarEIndicePanel) {
		this.paginarEIndicePanel = paginarEIndicePanel;
	}
	
	
}
