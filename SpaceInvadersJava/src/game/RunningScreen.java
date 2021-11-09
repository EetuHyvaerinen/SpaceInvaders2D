package game;


import character.CharacterHandler;


public class RunningScreen implements Screen {
	
	private CharacterHandler handler;
	private int maxWaves;
	private InputSystem inputSystem;
	protected static int currentScore;
	
	@Override
	public void update(GamePanel panel) 
    {
		inputSystem = panel.getInput();
		handler = new CharacterHandler(inputSystem);
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		maxWaves = handler.maxWaves();
		
		long lastTick = System.currentTimeMillis();
		while (true) {
			long currentTick = System.currentTimeMillis();
			double diffSeconds = (currentTick - lastTick) / 1000.0;
			lastTick = currentTick;			
			// moves all GameCharacters

			
			if (maxWaves == handler.getWaveCounter()) {
				currentScore = handler.getPoints();
				break;
			}
			//shop.update();
			handler.move(diffSeconds);

			panel.clear();
			// gets the int "score" from CharacterHandler and draws it

			//draws fps on screen
//			panel.drawText("FPS: " + fps, 250, 40);
			// draws the current health of the player
			
			// draws all GameCharacters
			panel.draw(handler.getList());
			panel.drawtext("" + handler.getScore(), 100, 50);
			panel.redraw();
			
			if(handler.getAvatar().getHealth() == 0) {
				currentScore = handler.getPoints();
				break;
			}
			
		}
    }

}
