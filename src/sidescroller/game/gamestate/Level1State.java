package sidescroller.game.gamestate;

import java.awt.Graphics;
import player.game.entities.Player;
import storage.game.objects.Block;

public class Level1State extends GameState {

	private Player player;

	private Block[] b;
	
	public Level1State(GameStateManager gsm) {

		super(gsm);
	}

	
	public void init() {

		player = new Player(30, 30);

		b = new Block[3];
		b[0] = new Block(250, 100);
		b[1] = new Block(200, 250);
		b[2] = new Block(550, 250);
	}

	
	public void tick() {

		for(int i = 0; i < b.length; i++) {
			b[i].tick();
		}

		player.tick(b);

	}

	
	public void draw(Graphics g) {
		player.draw(g);
		for(int i = 0; i < b.length; i++) {
			b[i].draw(g);
		}
	}

	
	public void keyPressed(int k) {
		player.keyPressed(k);
	}

	
	public void keyReleased(int k) {
		player.keyReleased(k);
	}
}
