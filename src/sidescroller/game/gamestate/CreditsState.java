package sidescroller.game.gamestate;

import java.awt.*;
import java.awt.event.KeyEvent;

import player.game.entities.Player;
import sidescroller.game.main.GamePanel;

import java.util.Arrays;

public class CreditsState extends GameState {

    private Player player;
    private String[] contributors = {"Drew Taylor", "Josh Hess", "Jordan Flagg", "Alec Collins"};
    private int scrollLength;

    public CreditsState(GameStateManager gsm) {

        super(gsm);
    }


    public void init() {

        scrollLength = -600;

    }


    public void tick() {

        scrollLength += 4;

        if (scrollLength > 500) {
            scrollLength = -600;
        }

    }


    public void draw(Graphics g) {

        for(int i = 0; i < contributors.length; i++) {
            g.setFont(new Font("Arial", Font.PLAIN, 72));
            g.drawString(contributors[i], GamePanel.WIDTH / 2 - 200, (150 + i * 150) + scrollLength);
        }
    }


    public void keyPressed(int k) {

        if(k == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }


    public void keyReleased(int k) {


    }
}
