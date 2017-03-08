package player.game.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import sidescroller.game.main.GamePanel;

public class Player extends Rectangle {
	private static final long serialVersionUID = 1l;

	private boolean right = false, left = false;

	private Graphics gr;

	private static int xLoc;
	private static int yLoc;
	
	public Player(int width, int height) {

		setBounds(GamePanel.WIDTH / 2, GamePanel.HEIGHT / 2, width, height);

	}

	public void tick() {

		if(right) {
			x++;
			System.out.println("if right is being called");
		}

		if(left) {
			x--;
		}

	}
	
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_D) {
			right = true;
		}
		if(k == KeyEvent.VK_A) {
			left = true;
		}
		if(k == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
	}
	
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_D) {
			right = false;
		}
		if(k == KeyEvent.VK_A) {
			left = false;
		}
		
	}
	
}
