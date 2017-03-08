package sidescroller.game.gamestate;

import java.awt.Graphics;
import player.game.entities.Player;

public class Level1State extends GameState {

	private Player player;
	
	public Level1State(GameStateManager gsm) {

		super(gsm);
	}

	
	public void init() {
		player = new Player(30, 30);
	}

	
	public void tick() {
		player.tick();
		System.out.println("Level1State tick called");
	}

	
	public void draw(Graphics g) {
		player.draw(g);
		g.fillRect(10, 10, 30, 30);
	}

	
	public void keyPressed(int k) {
		player.keyPressed(k);
	}

	
	public void keyReleased(int k) {
		player.keyReleased(k);
	}
}
