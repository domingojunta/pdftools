package es.domingojunta.panels;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.io.File;

public class AboutPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AboutPanel() {
		
		setBackground(new Color(240, 240, 240, 50));
		//setBackground(Color.BLUE);
		setOpaque(false);
		setPreferredSize(new Dimension(750,650));
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Acerca de ...");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(58, 55, 613, 40);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		add(lblNewLabel);
		
		JTextPane txtpnEsteProgramaSirve = new JTextPane();
		txtpnEsteProgramaSirve.setBackground(new Color(240,240,240,80));
		txtpnEsteProgramaSirve.setEditable(false);
		txtpnEsteProgramaSirve.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtpnEsteProgramaSirve.setText("Este programa sirve de apoyo a la preparaci\u00F3n de expedientes digitalizados, para su remisi\u00F3n a los Tribunales Econ\u00F3micos Administrativos y a los Tribunales de Justicia.");
		txtpnEsteProgramaSirve.setBounds(58, 128, 619, 74);
		//txtpnEsteProgramaSirve.setLineWrap(true);
		add(txtpnEsteProgramaSirve);
		
		JTextPane txtpnElProgramaSe = new JTextPane();
		txtpnElProgramaSe.setText("El programa se distribuye bajo la licencia AGPL v:3.0 (https://es.wikipedia.org/wiki/GNU_General_Public_Licence), considerada licencia de SOFTWARE LIBRE.");
		txtpnElProgramaSe.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtpnElProgramaSe.setEditable(false);
		txtpnElProgramaSe.setBackground(new Color(240,240,240,80));
		txtpnElProgramaSe.setBounds(58, 212, 619, 67);
		//txtpnElProgramaSe.setLineWrap(true);
		add(txtpnElProgramaSe);
		
		JTextPane txtpnElProgramaSe_1 = new JTextPane();
		txtpnElProgramaSe_1.setText("Esta versi\u00F3n del programa tiene consideraci\u00F3n de Beta, por lo que puede estar sujeta a errores puntuales propios de desarrollo de aplicaciones.");
		txtpnElProgramaSe_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtpnElProgramaSe_1.setEditable(false);
		txtpnElProgramaSe_1.setBackground(new Color(240,240,240,80));
		txtpnElProgramaSe_1.setBounds(58, 289, 619, 67);
		//txtpnElProgramaSe_1.setLineWrap(true);
		add(txtpnElProgramaSe_1);
		
		JTextPane txtpnElProgramaSe_1_1 = new JTextPane();
		txtpnElProgramaSe_1_1.setText("Versi\u00F3n 0.4 (Java)    Fecha: 26/08/2021");
		txtpnElProgramaSe_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtpnElProgramaSe_1_1.setEditable(false);
		txtpnElProgramaSe_1_1.setBackground(new Color(240,240,240,80));
		txtpnElProgramaSe_1_1.setBounds(58, 366, 619, 30);
		//txtpnElProgramaSe_1_1.setLineWrap(true);
		add(txtpnElProgramaSe_1_1);
		
		JTextPane txtpnElProgramaSe_1_2 = new JTextPane();
		txtpnElProgramaSe_1_2.setText("Puedes contactar con el autor en: domingojunta@gmail.com. El C\u00F3digo fuente puede ser consultado en https://github.com/domingojunta");
		txtpnElProgramaSe_1_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtpnElProgramaSe_1_2.setEditable(false);
		txtpnElProgramaSe_1_2.setBackground(new Color(240,240,240,80));
		txtpnElProgramaSe_1_2.setBounds(58, 406, 619, 62);
		//txtpnElProgramaSe_1_2.setLineWrap(true);
		add(txtpnElProgramaSe_1_2);
	}
	
private Image logoPdf;
	
	@Override
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		try {
			
			logoPdf = ImageIO.read(new File("images/pdf.png"));
			//logoJug.setcom
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
			g2.drawImage(logoPdf, 10, 50, getWidth(), getHeight(),this);
			
		} catch (Exception e) {

			System.out.println("No se ha podido cargar la imagen images/pdf.png");
		}
		
		setOpaque(false);
		super.paintComponent(g);
	}
}
