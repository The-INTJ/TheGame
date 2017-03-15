package sidescroller.game.physics;

import storage.game.objects.Block;

import java.awt.*;

/**
 * Created by drew on 3/15/17.
 */
public class Collision {

    public static boolean playerBlock(Point p, Block b) {

        return b.contains(p);
    }


}
