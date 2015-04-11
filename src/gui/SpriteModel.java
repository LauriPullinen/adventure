package gui;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lauri on 10.4.2015.
 */
public class SpriteModel implements Drawable {
    private Map<Type, Sprite> typeSpriteMap;
    private Type currentType;
    private double x;
    private double y;
    private double xTarget;
    private double yTarget;
    private double speed;
    private long lastTime;

    public SpriteModel() {
        this.typeSpriteMap = new HashMap<>();
        this.currentType = Type.DEFAULT;
        this.speed = 0.15;
    }

    public void draw(Graphics graphics) {
        this.update();
        graphics.translate((int)this.x, (int)this.y);
        this.getCurrentSprite().draw(graphics);
    }

    public Sprite getCurrentSprite() {
        return this.getSprite(this.currentType);
    }

    public int getHeight() {
        return this.getCurrentSprite().getHeight();
    }

    public int getWidth() {
        return this.getCurrentSprite().getWidth();
    }

    public Sprite getSprite(Type type) {
        return this.typeSpriteMap.get(type);
    }

    public int getX() {
        return (int) this.x + getWidth() / 2;
    }

    public int getY() {
        return (int) this.y + getHeight() / 2;
    }

    private double getXDouble() {
        return this.x + getWidth() / 2;
    }

    private double getYDouble() {
        return this.y + getHeight() / 2;
    }

    public void moveTo(int x, int y) {
        this.xTarget = x;
        this.yTarget = y;
    }

    public void putSprite(Type type, Sprite sprite) {
        this.typeSpriteMap.put(type, sprite);
    }

    public void setCurrentType(Type type) {
        if(this.typeSpriteMap.containsKey(type))
            this.currentType = type;
    }

    public void setPosition(double x, double y) {
        this.x = x - getWidth() / 2;
        this.y = y - getHeight() / 2;
    }

    @Override
    public String toString() {
        return String.format("SpriteModel: %d sprites, (%d,%d) to (%d,%d)", this.typeSpriteMap.size(),
                this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight());
    }

    /**
     * Moves the model toward the target position set with {@link #moveTo(int, int)}. Also updates the sprite if the
     * model is moving in the X dimension.
     */
    private void update() {
        long currentTime = System.currentTimeMillis();
        double deltaY = this.yTarget - this.getYDouble();
        double deltaX = this.xTarget - this.getXDouble();
        double distance = (currentTime - this.lastTime) * this.speed;
        // Don't move the sprite if the step would take it past the target
        if(Math.sqrt(deltaX*deltaX + deltaY*deltaY) > distance) {
            double movementX;
            double movementY = 0.0;
            // Can't compute the angle if the Y dimension is 0
            if(deltaY != 0) {
                double alpha = Math.atan(Math.abs(deltaX) / Math.abs(deltaY));
                movementX = this.getX() + Math.signum(deltaX) * Math.sin(alpha) * distance;
                movementY = this.getY() + Math.signum(deltaY) * Math.cos(alpha) * distance;
            } else {
                movementX = distance;
            }

            if(movementX > 0)
                this.setCurrentType(Type.LEFT);
            else if (movementX < 0)
                this.setCurrentType(Type.RIGHT);

            this.setPosition(this.getX() + movementX, this.getY() + movementY);
        }
        this.lastTime = currentTime;
    }

    public enum Type {
        LEFT, RIGHT, DEFAULT
    }
}
