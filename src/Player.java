import java.awt.Graphics;
import java.awt.Color;


import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;
  
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.applet.*;


public class Player extends GameObject{
    Handler handler;
    static boolean canJump;
    static int jumpTimer;

    public Player(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        canJump = true;
        jumpTimer = 0;
        try{
            playerImage = ImageIO.read(getClass().getResourceAsStream("images/player.png"));
          } catch(IOException e) {
             e.printStackTrace();
           }
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 48, 40);
      }

    public static void jump(){
        if(canJump && jumpTimer <=50){
            velY -= 10;
            jumpTimer++;
        }
        else{canJump = false;}
    }

    public void tick(){
        x += velX;
        y += velY;
        y += 5;
        collision();
    }

    private void collision(){
        
    }

    private BufferedImage playerImage;
    public void render(Graphics g){
        g.setColor(Color.BLACK);
        //g.drawRect(x, y, 48, 40);
        g.drawImage(playerImage, x, y, 48, 40, null);
    }
}
