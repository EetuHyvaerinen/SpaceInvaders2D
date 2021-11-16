package character.bullet;

import character.GameCharacter;
import game.A_Const;

public class DamageCircle extends GameCharacter {
	GameCharacter gc;
	int xoffset;
	int yoffset;
	double x;
	double y;
	public DamageCircle(double x, double y, GameCharacter gc) {
		super(x, y, 0, 8, 0, 400);
		this.gc = gc;
		xoffset = (int) (x - gc.getX());
		yoffset = (int) (y - gc.getY());
		this.x = x;
		this.y = y;
		
	}
	public int type() {
		return A_Const.TYPE_DAMAGE;
	}
	
	@Override
	public void move(double diffSeconds) {
		x = (gc.getX() + xoffset);
		y = (gc.getY() + yoffset);		
		if (gc.getRemove()) {
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
