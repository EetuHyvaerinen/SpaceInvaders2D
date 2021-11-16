package character.enemy;








import java.util.Random;

import character.GameCharacter;
import game.A_Const;

public class Rookie extends GameCharacter {
	int direction = 1;
	Random r = new Random();
	double timer = 1+ r.nextDouble();

	public Rookie(double x, double y) {
		super(x, y, 5, 20, 10, 100);
	}

	public void move(double diffSeconds) {
		
		timer -= diffSeconds;
		if (timer < 0) {
			timer = 1;
			int chance = r.nextInt(10);
			if (chance < 1) {
				shoot();

			}
		}
		
		if (direction == 1) {
			x -= speed * diffSeconds;
			if (x < radius) {
				y+=50;
				direction = 0;
			}
		}
		
		if (direction == 0) {
			x += speed * diffSeconds;
			if (x > A_Const.SCREEN_WIDTH-radius) {
				y+= 50;
				direction = 1;
			}
		}
	}
	private void shoot() {
		handler.addObject(new EnemyBullet(x, y, 3));
	}

	public void setRemove() {
		remove = true;
	}
	@Override
	public int type() {
		return A_Const.TYPE_ENEMY;
	}

}
