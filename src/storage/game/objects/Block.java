package storage.game.objects;

import sidescroller.game.gamestate.GameState;

import java.awt.*;

/**
 * Created by drew on 3/15/17.
 */
public class Block extends Rectangle {

    private static final long serialVersionUID = 1L;

    public static final int blockSize = 64;

    public Block(int x, int y) {

        setBounds(x, y, blockSize, blockSize);
    }

    public void tick() {

    }

    public void draw(Graphics g) {
        g.fillRect(x - (int)GameState.xOffset, y - (int)GameState.yOffset, width, height);
    }

}
