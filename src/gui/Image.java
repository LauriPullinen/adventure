package gui;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Lauri on 12.4.2015.
 */
public class Image implements Drawable {
    BufferedImage image;

    public Image(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(this.image, 0, 0, null);
    }
}
