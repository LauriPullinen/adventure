package gui;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lauri on 10.4.2015.
 */
public class GameScreen extends JPanel {
    List<Drawable> drawables;
    SpriteModel playerSpriteModel;

    public GameScreen() {
        this.drawables = new LinkedList<>();
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
        this.addMouseListener(new MouseListener(this));
    }

    public void addDrawable(Drawable drawable) {
        this.drawables.add(drawable);
    }

    public SpriteModel getPlayerSpriteModel() {
        return playerSpriteModel;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        for(Drawable drawable: this.drawables) {
            drawable.draw(graphics);
        }
    }

    public void setPlayerSpriteModel(SpriteModel playerSpriteModel) {
        this.playerSpriteModel = playerSpriteModel;
    }
/*
    List<Drawable> getDrawablesUnderPosition(int x, int y) {
        List<Drawable> spriteModelsUnder = new LinkedList<>();
        for(Drawable drawable: this.drawables) {
            if(x >= drawable.getX() && x <= drawable.getX() + drawable.getWidth() &&
                    y >= drawable.getY() && y <= drawable.getY() + drawable.getHeight()) {
                spriteModelsUnder.add(drawable);
            }
        }
        return spriteModelsUnder;
    }
*/
}
