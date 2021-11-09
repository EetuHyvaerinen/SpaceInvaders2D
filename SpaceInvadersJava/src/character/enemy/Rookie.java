package character.enemy;








import character.GameCharacter;
import game.A_Const;

public class Rookie extends GameCharacter {
	int direction = 1;

	public Rookie(double x, double y) {
		super(x, y, 5, 20, 10, 100);
	}

	public void move(double diffSeconds) {
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
	public void setRemove() {
		remove = true;
	}
	@Override
	public int type() {
		return A_Const.TYPE_ENEMY;
	}

}
