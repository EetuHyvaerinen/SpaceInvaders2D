package character.enemy;

import character.bullet.Bullet;
import game.A_Const;

public class EnemyBullet extends Bullet {
	int damage = 1;
	int speed = 100;
	public EnemyBullet(double x, double y, int radius) {
		super(x, y);
		this.radius = radius;
		
	}
	
	public void move(double diffSeconds) {
		y += speed * diffSeconds;
		if (x < 0) {
			remove = true;
		}
	}

	public int type() {
		return A_Const.TYPE_ENEMY_BULLET;
	}

}
