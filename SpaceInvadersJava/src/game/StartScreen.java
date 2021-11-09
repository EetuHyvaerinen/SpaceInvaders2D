package game;

import java.awt.Color;

public class StartScreen implements Screen {
	
	private InputSystem inputSystem;
	GameButton startBtn;
	
	@Override
	public void update(GamePanel panel) 
    {
		inputSystem = panel.getInput();
		startBtn  = new GameButton(A_Const.SCREEN_WIDTH / 2, A_Const.SCREEN_HEIGHT / 2, 60, 40, new Color(82,68,58), inputSystem);
		startBtn.toggleColor = new Color(48,39,34);

		
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
	
		while(true) {		
			
				break;
			}
			
		}
    
}
