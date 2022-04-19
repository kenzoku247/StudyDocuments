package com.Phuc.UserInterface;

import com.Phuc.Effects.FrameImage;
import com.Phuc.GameObjects.Megaman;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class GamePanel extends JPanel implements Runnable, KeyListener {

        private Thread thread;
        private boolean isRunning;

        private InputManager inputManager;

        private  BufferedImage bufferedImage;
        private Graphics2D bufG2D;

        Megaman megaman = new Megaman(300,300,100,100,0.1f);

        public GamePanel(){
                inputManager = new InputManager(this);
                bufferedImage = new BufferedImage(GameFrame.SCREEN_WIDTH,GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);

        }

        @Override
        public  void paint(Graphics g){
                g.drawImage(bufferedImage,0,0,this);

        }

        public void RenderGame(){
                if (bufferedImage == null){
                        bufferedImage = new BufferedImage(GameFrame.SCREEN_WIDTH,GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);

                } else {
                        bufG2D = (Graphics2D) bufferedImage.getGraphics();
                }
                if (bufG2D != null){
                        bufG2D.setColor(Color.YELLOW);
                        bufG2D.fillRect(0,0,GameFrame.SCREEN_WIDTH,GameFrame.SCREEN_HEIGHT);

                        //draw  game objects
                        megaman.draw(bufG2D);
                }
        }

        public void UpdateGame (){
                megaman.update();
        }

        public void startGame(){
                if (thread == null) {
                        isRunning =true;
                       thread = new Thread(this);
                       thread.start();
                }

        }
        @Override
        public void run(){

                long FPS  = 80;
                long period = 1000*1000000 / FPS;
                long beginTime;
                long sleepTime;


                beginTime = System.nanoTime();
                while (isRunning){
                        //Update game
                        // Render game

                        UpdateGame();
                        RenderGame();
                        repaint();

                        long deltaTime = System.nanoTime() - beginTime;
                        sleepTime = period - deltaTime;


                        //System.out.println("a = " + (a++));
                        try {
                                if(sleepTime > 0) {
                                        Thread.sleep(sleepTime/1000000);
                                } else Thread.sleep(period/2000000);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }

                        beginTime = System.nanoTime();
                }
        }


        // Callback Method
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
                inputManager.processKeyPressed(e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e) {
                inputManager.processKeyReleased(e.getKeyCode());
        }
}
