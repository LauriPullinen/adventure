package model;

import gui.Sprite;
import gui.SpriteModel;

/**
 * Created by Lauri on 12.4.2015.
 */
public class NPC extends Model<SpriteModel> {
    public NPC(int x, int y) {
        this.drawable = new SpriteModel();
        this.drawable.putSprite(SpriteModel.Type.DEFAULT, Sprite.load("resources/sprites/npc.png", 1, 1, 0));
        this.drawable.setPosition(x, y);
        this.drawable.moveTo(x,y);
    }
}
