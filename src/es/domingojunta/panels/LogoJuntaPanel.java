package es.domingojunta.panels;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;

public class LogoJuntaPanel extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogoJuntaPanel() {
		setBackground(new Color(240, 240, 240, 50));
		
		setSize(180,180);
		setVisible(true);
	}
	
	private Image logoJunta;
	
	@Override
	public void paint(Graphics g) {
		
		
		
		try {
			
			logoJunta = ImageIO.read(new File("images/logoJunta.png"));
			//logoJunta = new ImageIcon(getClass().getResource("images/logoJunta.png")).getImage();
			g.drawImage(logoJunta, 0, 0, getWidth(), getHeight(),this);
			
		} catch (Exception e) {

			System.out.println("No se ha podido cargar la imagen images/logoJunta.png");
		}
		
		setOpaque(false);
		super.paintComponent(g);
	}

}
