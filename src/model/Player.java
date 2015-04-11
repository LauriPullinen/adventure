package model;

import gui.Sprite;
import gui.SpriteModel;

/**
 * Created by Lauri on 10.4.2015.
 */
public class Player extends Model {
    public Player() {
        SpriteModel model = new SpriteModel();
        model.putSprite(SpriteModel.Type.DEFAULT, Sprite.load("resources/sprites/ball.png", 2, 2, 500));
        model.setPosition(100, 100);
        model.moveTo(100,100);
        this.drawable = model;
    }
}
