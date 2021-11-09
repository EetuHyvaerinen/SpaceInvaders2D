package game;

import java.util.ArrayList;
import character.GameCharacter;
import character.enemy.*;

public class EnemyWaves {
	private ArrayList<ArrayList<GameCharacter>> waves = new ArrayList<ArrayList<GameCharacter>>();
	private ArrayList<GameCharacter> wave;
	private int counter;

	public EnemyWaves() {
		// generates a wave with preset enemies and random locations
		ArrayList<GameCharacter> wave1 = new ArrayList<GameCharacter>();
		wave1.add(new Rookie(50, 100));
		wave1.add(new Rookie(100, 100));
		wave1.add(new Rookie(150, 100));
		wave1.add(new Rookie(200, 100));
		wave1.add(new Rookie(250, 100));
		wave1.add(new Rookie(300, 100));
		wave1.add(new Rookie(350, 100));

		waves.add(wave1);

		ArrayList<GameCharacter> wave2 = new ArrayList<GameCharacter>();
		wave2.add(new Rookie(50, 100));
		wave2.add(new Rookie(100, 100));
		wave2.add(new Rookie(150, 100));
		wave2.add(new Rookie(200, 100));
		wave2.add(new Rookie(250, 100));
		wave2.add(new Rookie(300, 100));
		wave2.add(new Rookie(350, 100));
		wave2.add(new Rookie(400, 100));
		wave2.add(new Rookie(450, 100));
		wave2.add(new Rookie(500, 100));
		wave2.add(new Rookie(550, 100));

		
		waves.add(wave2);

		ArrayList<GameCharacter> wave3 = new ArrayList<GameCharacter>();

		waves.add(wave3);

		ArrayList<GameCharacter> wave4 = new ArrayList<GameCharacter>();

		waves.add(wave4);



		//added an empty wave to check when game should end
		ArrayList<GameCharacter> wave6 = new ArrayList<GameCharacter>();
		waves.add(wave6);
		
		// counter is equal to the amount of waves
		counter = waves.size();
	}

	// returns a new wave to CharacterHandler
	public ArrayList<GameCharacter> getNewWave() {
		if (counter < 1)
			return null;
		counter--;
		wave = waves.get(0);
		waves.remove(0);
		return wave;
	}

	public int getCounter() {
		return counter;
	}
}
