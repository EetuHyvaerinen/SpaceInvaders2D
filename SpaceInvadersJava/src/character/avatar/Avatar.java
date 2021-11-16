package character.avatar;



import character.GameCharacter;
import character.bullet.Bullet;
import game.A_Const;
import game.InputSystem;

public class Avatar extends GameCharacter {

	private InputSystem inputSystem;
	private double startTime = 0;
	//bullets per second
	private double fireRate = 3;
	private int damage = 1;

	
	


	public Avatar(double x, double y, int health, InputSystem inputSystem) {
		super(x, y, health, 20, 0, 300);
		this.inputSystem = inputSystem;
	}

	public void shoot(double diffSeconds) {
		if (inputSystem.isSpace() && !remove) {
			startTime += diffSeconds;
			if (startTime >= 1/fireRate) {
				handler.addObject(new Bullet(x, y));
				startTime = 0;
			}
		}
	}

	@Override
	public void move(double diffSeconds) {
		double dx = 0, dy = 0;
		
		if	(inputSystem.isLeft())  dx--;
		if	(inputSystem.isRight()) dx++;
		
		shoot(diffSeconds);

		if	(dx != 0 || dy != 0) {

			if	(x+dx < 0 + radius || x+dx > A_Const.SCREEN_WIDTH-radius)		dx = 0;
			if	(y+dy < 0 + radius || y+dy > A_Const.SCREEN_HEIGHT-radius)	dy = 0;
			
			y += dy*speed*diffSeconds;
			x += dx*speed*diffSeconds;
		}
	}

	@Override
	public int type() {
		return A_Const.TYPE_AVATAR;

	}

	
	 	
	  public void healthUp() {
		++health;
		
		
	} 
	  
	  
	  public void damageUp() {
		++damage;
		
	} 
	  
	  public void fireRateUp() {
		++fireRate;
		
	}
	  
	  public int getHealth() {
		  return health;
	  }
	  
	  public int getDamage() {
		  return damage;
	  }
	  
	  public double getFirerate() {
		  return fireRate;
	  }
	  
	  

}
