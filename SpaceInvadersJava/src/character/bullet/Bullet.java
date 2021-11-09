package character.bullet;


import character.GameCharacter;
import game.A_Const;

public class Bullet extends GameCharacter {
	
	private int damage;
	
	public Bullet(double x, double y, int damage) {
		super(x, y, 0, 3, 0, 400);
		this.damage = damage;
	}
	public void move(double diffSeconds) {
		y -= speed * diffSeconds;
		if (x > A_Const.SCREEN_HEIGHT+radius) {
			remove = true;
		}
	}

	public int getDamage() {
		return damage;
	}

	@Override
	public int type() {
		return A_Const.TYPE_BULLET;
	}
}
