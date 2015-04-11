package model;

import gui.Drawable;
import gui.SpriteModel;

/**
 * Models are game objects with {@link gui.Drawable} objects. They can be characters, items, etc.
 *
 * Created by Lauri on 10.4.2015.
 */
public abstract class Model {
    protected Drawable drawable;

    public Drawable getDrawable() {
        return drawable;
    }
}
