package game;

import java.awt.Dimension;

import javax.swing.*;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private GamePanel panel;

	public GameFrame() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		setTitle("Space Invaders");
		panel = new GamePanel();
		this.setContentPane(panel);

		// Set the actual dimension for GamePanel
		this.getContentPane().setPreferredSize(new Dimension(panel.WIDTH, panel.HEIGHT));
		this.pack();
	}

	public GamePanel getPanel() {
		return panel;
	}
}
