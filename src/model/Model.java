package model;

import gui.Drawable;
import gui.SpriteModel;

/**
 * Models are game objects with {@link gui.Drawable} objects.
 * @param <T> the type of the Drawable object
 * Created by Lauri on 10.4.2015.
 */
public abstract class Model<T extends Drawable> {
    protected T drawable;

    public T getDrawable() {
        return drawable;
    }
}
