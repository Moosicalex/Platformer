/*********************************************************************************************
* Final Assignment  --  Slime Friend and the Search for the Mysterious Treasure - The Game *
*                                                                                            *
* PROGRAMMER:        Alex Bradberry (moosicalex2@gmail.com)                                  *
* CLASS:             CS160 -- Structured Programming                                         *
* INSTRUCTOR:        Dean Zeller                                                             *
* TERM:              Fall 2020                                                               *
* SUBMISSION DATE:   12/5/2020                                                               *
*                                                                                            *
* DESCRIPTION:                                                                               *
* The user uses the arrow keys on their keyboard to move a character around a screen and     *
* interacts with other characters triggering music and text.                                 *
*                                                                                            *
* COPYRIGHT:                                                                                 *
* This program is copyright (c)2020 Alex Bradberry and Dean Zeller.                          *
* It is original work with the use of outside surces.                                        *
*                                                                                            *
*********************************************************************************************/



//for the display of the game
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.applet.*;

//for music
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
import java.io.File;


public class Game extends Canvas implements Runnable{
    
    public static final int WIDTH = 800, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;

    public Game()
    throws UnsupportedAudioFileException,
        IOException, LineUnavailableException{
            handler = new Handler();
            this.addKeyListener(new KeyInput(handler));

            new Window(WIDTH, HEIGHT, "Platformer", this);

            //handler.addObject(new Map(100, 100, ID.Map));
            handler.addObject(new Player(Game.WIDTH/2, Game.HEIGHT/2, ID.Player, handler));
            //handler.addObject(new Platform(Game.WIDTH/2, Game.HEIGHT/2, ID.Platform, handler));
            handler.addObject(new Full_Platform(0, Game.HEIGHT - 100, WIDTH, HEIGHT, ID.Full_Platform, handler));
        }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
          thread.join();
          running = false;
        }catch(Exception e){
          e.printStackTrace();
        }
    }

    public void run(){
    
    
        /*******************************
        * common game tick timer       *
        * used by many game creators   *
        * like notch among others      *
        * *****************************/
       long LastTime = System.nanoTime();
       double amountOfTicks = 60.0;
       double ns = 1000000000 / amountOfTicks;
       double delta = 0;
       long timer = System.currentTimeMillis();
       int frames = 0;
       while(running){
         long now = System.nanoTime();
         delta += (now - LastTime) / ns;
         LastTime = now;
         while(delta >= 1){
           tick();
           delta--;
         }
         if(running)
           render();
         frames++;
         
         if(System.currentTimeMillis() - timer > 1000){
           timer += 1000;
           System.out.println("FPS: " + frames);
           frames = 0;
         }
       }
       stop();
     }

     private void tick(){
         handler.tick();
     }

     private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
          this.createBufferStrategy(3);
          return;
        }

        Graphics g = bs.getDrawGraphics();
        handler.render(g); 
    
        g.dispose();
        bs.show();
     }

     public static void main(String args[])
  throws UnsupportedAudioFileException, 
        IOException, LineUnavailableException{
    new Game();
  }
}
