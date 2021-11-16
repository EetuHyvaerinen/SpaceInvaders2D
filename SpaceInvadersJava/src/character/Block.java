package character;

import java.awt.Rectangle;

import game.A_Const;

public class Block extends GameCharacter {

	public Block(double x, double y, int health, int radius, int score, int speed) {
		super(x, y, health, radius, 0, 0);
	}

	@Override
	public void move(double diffSeconds) {
		
	}

	@Override
	public int type() {
		return A_Const.TYPE_BLOCK;
	}
	
}
