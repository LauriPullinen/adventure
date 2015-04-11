package gui;

import engine.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lauri on 10.4.2015.
 */
public class Window extends JFrame {
    private int width;
    private int height;

    private GameScreen gameScreen;

    private WindowAnimator windowAnimator;

    public Window(String title)
    {
        super(title);

        this.width = 900;
        this.height = 400;
        this.gameScreen = new GameScreen();
        this.gameScreen.setPreferredSize(new Dimension(width, height));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(this.gameScreen, BorderLayout.CENTER);
        this.setSize(new Dimension(this.width, this.height));
        this.setResizable(false);
        this.setVisible(true);

        this.windowAnimator = new WindowAnimator(this);
    }

    public GameScreen getGameScreen() {
        return this.gameScreen;
    }

    public void start() {
        this.windowAnimator.run();
    }
}
