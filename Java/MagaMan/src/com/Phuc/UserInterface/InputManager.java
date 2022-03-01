package com.Phuc.UserInterface;

import com.Phuc.GameObjects.Megaman;

import java.awt.event.KeyEvent;

public class InputManager {

    private  GamePanel gamePanel;
    public InputManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void processKeyPressed(int keyCode){
        switch (keyCode){
            case KeyEvent.VK_UP:
                break;
            case KeyEvent.VK_DOWN:
                break;
            case KeyEvent.VK_LEFT:
                gamePanel.megaman.setDirection(Megaman.DIR_LEFT);
                gamePanel.megaman.setSpeedX(-5);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.megaman.setDirection(Megaman.DIR_RIGHT);
                gamePanel.megaman.setSpeedX(5);
                break;
            case KeyEvent.VK_ENTER:
                break;
            case KeyEvent.VK_SPACE:
                gamePanel.megaman.setSpeedY(-6);
                gamePanel.megaman.setPosY(gamePanel.megaman.getPosY() - 6);
                break;
            case KeyEvent.VK_A:
                break;
        }

    }

    public void processKeyReleased(int keyCode){
        switch (keyCode){
            case KeyEvent.VK_UP:
                break;
            case KeyEvent.VK_DOWN:
                break;
            case KeyEvent.VK_LEFT:
                gamePanel.megaman.setSpeedX(0);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.megaman.setSpeedX(0);
                break;
            case KeyEvent.VK_ENTER:
                break;
            case KeyEvent.VK_SPACE:
                break;
            case KeyEvent.VK_A:
                break;
        }

    }
}
