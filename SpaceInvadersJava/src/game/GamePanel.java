package game;

import character.GameCharacter;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public final int WIDTH = A_Const.SCREEN_WIDTH;
	public final int HEIGHT = 600;
	

	private BufferedImage imageBuffer;
	private Graphics graphics;
	//private KeyInput keyInput = new KeyInput();
	private InputSystem inputSystem;

	public GamePanel() {
		this.setSize(WIDTH, HEIGHT);
		GraphicsConfiguration graphicsConf = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		imageBuffer = graphicsConf.createCompatibleImage(this.getWidth(), this.getHeight());
		graphics = imageBuffer.getGraphics();
		inputSystem = new InputSystem();
		this.addKeyListener(inputSystem);
		this.addMouseListener(inputSystem);
		this.addMouseMotionListener(inputSystem);
	}


	public void draw(GameCharacter gc) {
		if (gc.type() == 5) {
			drawremovedpart(gc);
		} else if (gc.type() == 6) {
			drawShrapnel(gc);
			
		} else {
			int x = (int) (gc.getX() - gc.getRadius());
			int y = (int) (gc.getY() - gc.getRadius());
			graphics.setColor(Color.WHITE);
			graphics.fillOval(x, y, gc.getRadius()*2, gc.getRadius()*2);
		}

	}

	private void drawShrapnel(GameCharacter gc) {
		int x = (int) (gc.getX() - gc.getRadius());
		int y = (int) (gc.getY() - gc.getRadius());

		graphics.setColor(Color.RED);
		graphics.fillOval(x, y, gc.getRadius()*2, gc.getRadius()*2);
		
	}


	public void draw(ArrayList<GameCharacter> List) {
		for (int i = 0; i < List.size(); i++) draw(List.get(i));	
	}
	
	
	public void drawtext(String str, int x, int y) {
		graphics.drawString(str, x, y);
	}
	
	public void drawremovedpart(GameCharacter gc) {
		int x = (int) (gc.getX() - gc.getRadius());
		int y = (int) (gc.getY() - gc.getRadius());

		graphics.setColor(Color.BLACK);
		graphics.fillOval(x, y, gc.getRadius()*2, gc.getRadius()*2);
	}
		
	public void clear() {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
	}

	
	public void redraw() {
		this.getGraphics().drawImage(imageBuffer, 0, 0, this);
	}
	public final InputSystem getInput() {
		return inputSystem;
	}

 }