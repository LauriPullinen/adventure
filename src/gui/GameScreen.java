package gui;

import model.level.Level;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lauri on 10.4.2015.
 */
public class GameScreen extends JPanel {
    private List<Drawable> drawables;
    private Level level;
    private SpriteModel playerSpriteModel;
    private boolean debugLevels;

    private static final Color DEBUG_COLOR = new Color(6, 154, 223);

    public GameScreen() {
        this.drawables = new LinkedList<>();
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
        MouseHandler mouseHandler = new MouseHandler(this);
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        this.debugLevels = true;
    }

    public void addDrawable(Drawable drawable) {
        this.drawables.add(drawable);
    }

    public Level getLevel() {
        return level;
    }

    public SpriteModel getPlayerSpriteModel() {
        return playerSpriteModel;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        if(this.level != null) {
            this.level.getDrawable().draw(graphics);
            if (this.debugLevels) {
                graphics.setColor(DEBUG_COLOR);
                graphics.drawPolygon(this.level.getBounds());
            }
        }
        for(Drawable drawable: this.drawables) {
            drawable.draw(graphics);
        }
    }

    public void setDebugLevels(boolean debugLevels) {
        this.debugLevels = debugLevels;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setPlayerSpriteModel(SpriteModel playerSpriteModel) {
        this.playerSpriteModel = playerSpriteModel;
    }
}
