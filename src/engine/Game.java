package engine;

import gui.GameScreen;
import gui.SpriteModel;
import gui.Window;
import model.Item;
import model.NPC;
import model.Player;
import model.level.Level;

/**
 * Created by Lauri on 10.4.2015.
 */
public class Game {
    private static Game singleton;

    private Window window;
    private Player player;
    private Level level;

    public static Game getInstance() {
        return singleton;
    }

    private static void initialize() {
        singleton = new Game();
    }

    private Game() {
        this.window = new Window("Adventure");
        this.player = new Player();
        this.level = new Level("resources/levels/level.csv", "resources/sprites/level.png");
        this.getGameScreen().addDrawable(this.player.getDrawable());
        this.getGameScreen().setPlayerSpriteModel(this.player.getDrawable());
        this.getGameScreen().setLevel(this.level);
        this.getGameScreen().setDebugLevels(true);

        Item item = new Item(200,250);
        NPC npc = new NPC(400, 200);
        NPC npc2 = new NPC(600, 150);
        this.getGameScreen().addDrawable(item.getDrawable());
        this.getGameScreen().addDrawable(npc.getDrawable());
        this.getGameScreen().addDrawable(npc2.getDrawable());
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
