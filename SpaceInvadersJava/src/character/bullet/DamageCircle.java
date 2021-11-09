package character.bullet;

import character.GameCharacter;
import game.A_Const;

public class DamageCircle extends GameCharacter {
	GameCharacter rookie;
	int xoffset;
	int yoffset;
	double x;
	double y;
	public DamageCircle(double x, double y, GameCharacter rookie) {
		super(x, y, 0, 8, 0, 400);
		this.rookie = rookie;
		xoffset = (int) (x - rookie.getX());
		yoffset = (int) (y - rookie.getY());
		this.x = x;
		this.y = y;
		
	}
	public int type() {
		return A_Const.TYPE_DAMAGE;
	}
	
	@Override
	public void move(double diffSeconds) {
		x = (rookie.getX() + xoffset);
		y = (rookie.getY() + yoffset);		
		if (rookie.getRemove()) {
			this.setRemove();
		}
	}
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

}
