package es.domingojunta.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PaginarEIndicePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaginarEIndicePanel() {
		setBackground(new Color(240, 240, 240, 50));
		//setBackground(Color.BLUE);
		setOpaque(false);
		setPreferredSize(new Dimension(600,600));
		setLayout(null);
		setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Paginar pdf's y generar índice");
		lblNewLabel.setBounds(150, 55, 350, 40);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		add(lblNewLabel);
	}

	
}
