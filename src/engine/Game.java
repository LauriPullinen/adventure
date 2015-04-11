package engine;

import gui.GameScreen;
import gui.SpriteModel;
import gui.Window;
import model.Player;

/**
 * Created by Lauri on 10.4.2015.
 */
public class Game {
    private static Game singleton;

    private Window window;

    private Player player;

    public static Game getInstance() {
        return singleton;
    }

    private static void initialize() {
        singleton = new Game();
    }

    private Game() {
        this.window = new Window("Adventure");
        this.player = new Player();
        this.getGameScreen().addDrawable(this.player.getDrawable());
        this.getGameScreen().setPlayerSpriteModel((SpriteModel)this.player.getDrawable());
        this.window.start();
    }

    public GameScreen getGameScreen() {
        return this.window.getGameScreen();
    }

    public Player getPlayer() {
        return player;
    }

    public static void main(String[] args) {
        Game.initialize();
    }
}
