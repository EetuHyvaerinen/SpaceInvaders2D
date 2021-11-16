package character;

import java.util.ArrayList;
import java.util.Random;

import character.avatar.Avatar;
import character.bullet.Bullet;
import character.bullet.DamageCircle;
import character.bullet.Shrapnel;
import game.A_Const;
import game.EnemyWaves;
import game.InputSystem;
import game.PhysicsSystem;

public class CharacterHandler {

	private EnemyWaves waves;
	private int waveCounter = 0, enemyCounter = 0, score = 0, points = 0, maxWaves = 0;
	private PhysicsSystem physics = new PhysicsSystem();
	private ArrayList<GameCharacter> objectList = new ArrayList<GameCharacter>();
	private static Avatar avatar;
	protected static CharacterHandler handler;
	Random random = new Random();
	public CharacterHandler(InputSystem inputSystem) {
		handler = this;
		avatar = new Avatar(400, 550, 3, inputSystem);
		addObject(new Block(300, 450, 3, 10, 0, 0));
		addObject(new Block(320, 450, 3, 10, 0, 0));
		addObject(new Block(340, 450, 3, 10, 0, 0));
		addObject(new Block(360, 450, 3, 10, 0, 0));
		addObject(new Block(380, 450, 3, 10, 0, 0));
		addObject(new Block(400, 450, 3, 10, 0, 0));
		addObject(new Block(420, 450, 3, 10, 0, 0));
		addObject(new Block(440, 450, 3, 10, 0, 0));
		addObject(new Block(460, 450, 3, 10, 0, 0));

		addObject(avatar);
		// initialize EnemyWaves and get the initial wave
		EnemyWaves waves = new EnemyWaves();
		this.waves = waves;
		maxWaves = waves.getCounter();
		getNewWave();
	}

	public void addObject(GameCharacter gc) {
		objectList.add(gc);
	}
	

	public void removeObject(GameCharacter gc) {
		// if removed object is an enemy, decrement enemyCounter
		if (gc.type() == A_Const.TYPE_ENEMY) {
			enemyCounter--;
		}
		score += gc.getScore();
		points += gc.getScore();
		objectList.remove(gc);
		
		// if all enemies have died and there is another wave to get, get new wave
		if (enemyCounter < 1 && waves.getCounter() > 0) {
			getNewWave();
		}
	}

	public void move(double diffSeconds) {
		for (int i = 0; i < objectList.size(); i++) {
			GameCharacter gc = objectList.get(i);
			gc.move(diffSeconds);
			collisionCheck(gc);
			if (gc.getRemove()) {
				removeObject(gc);
			}
		}
	}
	
	public void collisionCheck(GameCharacter gc) {
		ArrayList<GameCharacter> enemyListSmall;
		switch (gc.type()) {
		case A_Const.TYPE_AVATAR:
			enemyListSmall = physics.getCollisions(gc, objectList);
			for (int i = 0; i < enemyListSmall.size(); i++) {
				enemyListSmall.get(i).setRemove();
				gc.changeHealth(-1);


			}
			break;
			
		case A_Const.TYPE_BLOCK:
			enemyListSmall = physics.getCollisions(gc, objectList);
			for (int k = 0; k < enemyListSmall.size(); k++) {
				enemyListSmall.get(k).setRemove();
				gc.changeHealth(-1);
				DamageCircle dmg = new DamageCircle(enemyListSmall.get(k).getX(), enemyListSmall.get(k).getY(), gc);
				addObject(dmg);

			}
			break;
			
		case A_Const.TYPE_BULLET:
			enemyListSmall = physics.getCollisions(gc, objectList);
			for (int j = 0; j < enemyListSmall.size(); j++) {
				enemyListSmall.get(j).changeHealth(-((Bullet) gc).getDamage());
				DamageCircle dmg = new DamageCircle(gc.getX(), gc.getY(), enemyListSmall.get(j));
				addObject(dmg);
				double b = random.nextInt(20);
				for (int i = 0; i < b; i++) {
					addObject(new Shrapnel(dmg.getX(), dmg.getY()));
				}
				gc.setRemove();
			}
			break;
		}
	}
	
	private void getNewWave() {
		ArrayList<GameCharacter> wave = waves.getNewWave();
		waveCounter++;
		for (int i = 0; i < wave.size(); i++) {
			addObject(wave.get(i));
			enemyCounter++;
		}
	}

	public ArrayList<GameCharacter> getList() {
		return objectList;
	}

	public int getScore() {
		return score;
	}
	
	public int getPoints() {
		return points;
	}
	
	public Avatar getAvatar() {
		return avatar;
	}

	public int maxWaves() {
		return maxWaves;
	}
	public int getWaveCounter() {
		return waveCounter;
	}
}
