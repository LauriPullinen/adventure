package model;

import gui.Sprite;
import gui.SpriteModel;

/**
 * Created by Lauri on 10.4.2015.
 */
public class Player extends Model<SpriteModel> {
    public Player() {
        this.drawable = new SpriteModel();
        this.drawable.putSprite(SpriteModel.Type.DEFAULT, Sprite.load("resources/sprites/ball.png", 2, 2, 500));
        this.drawable.setPosition(100, 100);
        this.drawable.moveTo(100,100);
    }
}
