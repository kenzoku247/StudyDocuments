package com.Phuc.UserInterface;

import com.Phuc.Effects.CacheDataLoader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

// Ke thua thu vien JFrame
public class GameFrame extends JFrame {
    // Cai dat do rong, do ngang cua ma hinh
    public static final int SCREEN_WIDTH = 1000;
    public static final int SCREEN_HEIGHT = 750;

    GamePanel gamePanel;

    // Ham constructor
    public GameFrame(){

        Toolkit toolkit = this.getToolkit();
        // Doi tuong luu cap gia tri
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds((dimension.width - SCREEN_WIDTH) / 2, (dimension.height - SCREEN_HEIGHT) / 2,SCREEN_WIDTH,SCREEN_HEIGHT);

        // Load Data phai co truoc gamePanel
        try {
            CacheDataLoader.getInstance().LoadData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        gamePanel = new GamePanel();
        add(gamePanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addKeyListener(gamePanel);


    }

    public void startGame(){
        gamePanel.startGame();
    }

    public static void main(String[] args){
        GameFrame gameFrame = new GameFrame();
        gameFrame.setVisible(true);
        gameFrame.startGame();


    }
}
