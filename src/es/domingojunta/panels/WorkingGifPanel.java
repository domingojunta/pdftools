package es.domingojunta.panels;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;

public class WorkingGifPanel extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WorkingGifPanel() {
		setBackground(new Color(240, 240, 240, 50));
		
		setSize(180,180);
		setVisible(true);
	}
	
	private Icon paginando;
	
	@Override
	public void paint(Graphics g) {
		
		
		
		try {
			
			paginando = new ImageIcon("images/Paginando.gif");
			//paginando = ImageIO.read(new File("images/Paginando.gif"));
			//logoJunta = new ImageIcon(getClass().getResource("images/logoJunta.png")).getImage();
			//g.drawImage(paginando, 0, 0, getWidth(), getHeight(),this);
			
		} catch (Exception e) {

			System.out.println("No se ha podido cargar la imagen images/Paginando.gif");
		}
		
		setOpaque(false);
		super.paintComponent(g);
	}

}
