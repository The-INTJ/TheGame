package sidescroller.game.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import sidescroller.game.main.GamePanel;

public class MenuState extends GameState {
	
	private String[] options = {"Start", "Credits", "Quit"};
	private int currentSelection = 0;
	
	public MenuState(GameStateManager gsm) {

		super(gsm);
	}
	
	
	public void init() {	
	}
	
	public void tick() {
	}
	
	public void draw(Graphics g) {
		
		g.setColor(new Color(50, 150, 200));
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		for(int i = 0; i < options.length; i++) {
			if(i == currentSelection){
				g.setColor(Color.GREEN);
			}else {
				g.setColor(Color.WHITE);
			}
			
			g.setFont(new Font("Arial", Font.PLAIN, 72));
			g.drawString(options[i], GamePanel.WIDTH / 2 - 75, 150 + (i * 150));
		}
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_DOWN){					//down arrow
			currentSelection++;
			if(currentSelection >= options.length){
				currentSelection = 0;
			}
		} else if (k == KeyEvent.VK_UP){			//up arrow
			currentSelection--;
			if(currentSelection < 0) {
				currentSelection = options.length - 1;
			}
		}
		
		if(k == KeyEvent.VK_ENTER) {
			if(currentSelection == 0) { 			//'PLAY' is selected
			gsm.states.push(new Level1State(gsm));
		} else if (currentSelection == 1) {			//'CREDITS' is selected
				gsm.states.push(new CreditsState(gsm));
		} else if(currentSelection == 2) {			//'QUIT' is selected
			System.exit(0);
		}
		}
	}
	
	public void keyReleased(int k) {
	}

}
