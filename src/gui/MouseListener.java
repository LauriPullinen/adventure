package gui;

import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Created by Lauri on 10.4.2015.
 */
public class MouseListener implements java.awt.event.MouseListener {
    private GameScreen gameScreen;

    public MouseListener(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Note: left empty intentionally
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Note: left empty intentionally
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        //List<SpriteModel> spriteModels = this.gameScreen.getSpriteModelsUnderPosition(x,y);
        //if(spriteModels.isEmpty()) {
            this.gameScreen.getPlayerSpriteModel().moveTo(x,y);
        //}
        // TODO: Else
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
