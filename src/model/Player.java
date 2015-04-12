package model;

import gui.Sprite;
import gui.SpriteModel;

/**
 * Created by Lauri on 10.4.2015.
 */
public class Player extends Model<SpriteModel> {
    public Player() {
        this.drawable = new SpriteModel();
        this.drawable.putSprite(SpriteModel.Type.DEFAULT, Sprite.load("resources/sprites/player.png", 1, 1, 0));
        this.drawable.setPosition(125, 140);
        this.drawable.moveTo(125, 140);
    }
}
