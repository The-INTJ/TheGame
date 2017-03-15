package player.game.entities;

import java.awt.*;
import java.awt.event.KeyEvent;

import sidescroller.game.gamestate.GameState;
import sidescroller.game.main.GamePanel;
import sidescroller.game.physics.Collision;
import storage.game.objects.Block;

import static sidescroller.game.gamestate.GameState.*;

public class Player {

	private boolean reset = false;

	private boolean right = false, left = false, jumping = false, falling = false;
	public double x, y;
	private int width, height;

	// moving
	private double moveSpeed = 5.5;

	// jump variables
	private double jumpSpeed = 5;
	private double currentJumpSpeed = jumpSpeed;
	private double jumpSlow = 0.1;

	// fall variables
	private double maxFallSpeed = 5;
	private double currentFallSpeed = 0.1;
	private double fallIncrease = 0.1;
	
	public Player(int width, int height) {

		// bounds
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		this.width = width;
		this.height = height;

	}

	public void tick(Block[] b) {


		int iX = (int)x;
		int iY = (int)y;

		for(int i = 0; i < b.length; i++) {

			// right
			if(Collision.playerBlock(new Point(iX + width + (int)GameState.xOffset,
					iY + (int)GameState.yOffset), b[i])
					|| Collision.playerBlock(new Point(iX + width + (int)GameState.xOffset,
					iY + height + (int)GameState.yOffset), b[i])) {
				right = false;
			}

			// left
			if(Collision.playerBlock(new Point(iX + (int)GameState.xOffset,
					iY + (int)GameState.yOffset), b[i])
					|| Collision.playerBlock(new Point(iX + (int)GameState.xOffset,
					iY + height + (int)GameState.yOffset), b[i])) {
				left = false;
			}

			// top
			if(Collision.playerBlock(new Point(iX + (int)GameState.xOffset,
					iY + (int)GameState.yOffset), b[i])
					|| Collision.playerBlock(new Point(iX + (int)GameState.xOffset + width,
					iY + (int)GameState.yOffset), b[i])) {
				jumping = false;
				falling = true;
			}
		}

		if(right) {
			GameState.xOffset += moveSpeed;

		}

		if(left) {
			GameState.xOffset -= moveSpeed;

		}

		if (jumping) {
			GameState.yOffset -= currentJumpSpeed;
			currentJumpSpeed -= jumpSlow;
			if (currentJumpSpeed <= 0) {
				currentJumpSpeed = jumpSpeed;
				jumping = false;
				falling = true;
			}
		}

		if (falling) {
			GameState.yOffset += currentFallSpeed;
			if (currentFallSpeed < maxFallSpeed) {
				currentFallSpeed += fallIncrease;
			}
		}

		if (!falling) {
			currentFallSpeed = 0.1;
		}

	}
	
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int)x, (int)y, width, height);
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_D) {
			right = true;
		}
		if(k == KeyEvent.VK_A) {
			left = true;
		}
		if(k == KeyEvent.VK_SPACE) {
			jumping = true;
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
