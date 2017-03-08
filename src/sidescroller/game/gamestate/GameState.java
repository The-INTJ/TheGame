package sidescroller.game.gamestate;

import java.awt.Graphics;

public abstract class GameState {
	
	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm){
		this.gsm = gsm;
		
		init();
		System.out.println("init in GameState called");
		tick();
	}
	public abstract void init();
	public abstract void tick();
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);

}
