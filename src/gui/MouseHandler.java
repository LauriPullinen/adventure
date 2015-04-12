package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

/**
 * Created by Lauri on 10.4.2015.
 */
public class MouseHandler implements MouseListener, MouseMotionListener {
    private GameScreen gameScreen;

    public MouseHandler(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Note: left empty intentionally
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Note: left empty intentionally
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO: Add mouse movement handling
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Note: left empty intentionally
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if(this.gameScreen.getLevel().inBounds(x,y)) {
            this.gameScreen.getPlayerSpriteModel().moveTo(x,y);
        } else {
            System.out.printf("Click %d,%d out of level bounds\n",x,y);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Note: left empty intentionally
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Note: left empty intentionally
    }
}
