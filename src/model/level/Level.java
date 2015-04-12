package model.level;

import gui.Sprite;
import model.Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Lauri on 11.4.2015.
 */
public class Level extends Model<Sprite> {
    private Bounds bounds;

    public Level(String boundsFilename, String spriteFilename) {
        try {
            this.bounds = Bounds.load(boundsFilename);
        } catch(IOException e) {
            e.printStackTrace();
        }

        this.drawable = Sprite.load(spriteFilename, 1, 1, 0);
    }

    public Bounds getBounds() {
        return bounds;
    }

    public boolean inBounds(int x, int y) {
        return this.getBounds().contains(x,y);
    }
}
