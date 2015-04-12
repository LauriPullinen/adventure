package gui;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lauri on 10.4.2015.
 */
public class Sprite implements Drawable {
    private List<BufferedImage> images;
    private int x;
    private int y;
    private int currentFrame;
    private int frameDelay;
    private long lastTime;

    public Sprite(BufferedImage baseImage, int rows, int columns, int frameDelay) {
        this.frameDelay = frameDelay;
        this.currentFrame = 0;
        this.lastTime = 0;
        this.x = 0;
        this.y = 0;

        this.images = new ArrayList<>(rows * columns);
        int spriteWidth = baseImage.getWidth() / columns;
        int spriteHeight = baseImage.getHeight() / rows;
        for(int y = 0; y < rows; y++) {
            for(int x = 0; x < columns; x++) {
                BufferedImage subImage =
                        baseImage.getSubimage(x * spriteWidth, y * spriteHeight, spriteWidth, spriteHeight);
                this.images.add(subImage);
            }
        }
    }

    public static Sprite load(String pathName, int rows, int columns, int frameDelay) {
        File imageFile = new File(pathName);
        try {
            BufferedImage image = ImageIO.read(imageFile);
            return new Sprite(image, rows, columns, frameDelay);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getHeight() {
        return this.images.get(this.currentFrame).getHeight();
    }

    public int getWidth() {
        return this.images.get(this.currentFrame).getWidth();
    }

    public void draw(Graphics graphics) {
        this.update();
        graphics.drawImage(this.images.get(this.currentFrame), this.x, this.y, null);
    }

    public void setPosition(int x, int y) {
        this.x = x - getWidth() / 2;
        this.y = y - getHeight() / 2;
    }

    private void update() {
        long currentTime = System.currentTimeMillis();
        if(currentTime - this.lastTime > frameDelay) {
            this.currentFrame = (this.currentFrame + 1) % this.images.size();
            this.lastTime = currentTime;
        }
    }
}
