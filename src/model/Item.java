package model;

import gui.Sprite;

/**
 * Created by Lauri on 12.4.2015.
 */
public class Item extends Model<Sprite> {
    public Item(int x, int y) {
        this.drawable = Sprite.load("resources/sprites/item.png", 1, 1, 0);
        this.drawable.setPosition(x, y);
    }
}
