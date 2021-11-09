package game;

public class GameLoop {

	private State state = State.RUNNING;
	private GamePanel panel;

    public void run()
    {
    	RunningScreen runScrn = new RunningScreen();
    	while(true) {
    		switch(state) {
            case RUNNING:
                runScrn.update(panel);
                break;

            default:
                throw new RuntimeException("Unknown state: " + state);
            }
    	}
    	
        
    }
		
    public void setGraphicPanel(GamePanel panel) {
		this.panel = panel;
	}
}
