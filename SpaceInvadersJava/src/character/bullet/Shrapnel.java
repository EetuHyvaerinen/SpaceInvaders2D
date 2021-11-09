package character.bullet;

import java.util.Random;

import character.GameCharacter;
import game.A_Const;

public class Shrapnel extends GameCharacter {
	double alfa;
	double a;
	double lifetime = 0.3;
	public Shrapnel (double x, double y) {
		super(x, y, 0, 2, 0, 200);
		Random random = new Random();
		double b = random.nextInt(6);
		a = random.nextInt(100);
		alfa = b;
	}

	@Override
	public void move(double diffSeconds) {
		if (lifetime > 0) {
			x += Math.cos(alfa)*(speed+a)*diffSeconds;
		    y += Math.sin(alfa)*(speed+a)*diffSeconds; 
		    lifetime -= diffSeconds;
		} else {
			setRemove();
		}
		
		
	}

	@Override
	public int type() {
		return A_Const.TYPE_SHRAPNEL;
	}
}
