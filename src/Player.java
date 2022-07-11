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
    static boolean jumping;
    static int jumpTimer;

    public Player(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        canJump = true;
        jumping = false;
        jumpTimer = 0;
        try{
            playerImage = ImageIO.read(getClass().getResourceAsStream("images/player.png"));
            playerEastWallImage = ImageIO.read(getClass().getResourceAsStream("images/playerEastWall.png"));
            playerWestWallImage = ImageIO.read(getClass().getResourceAsStream("images/playerWestWall.png"));
          } catch(IOException e) {
             e.printStackTrace();
           }
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 48, 40);
      }

    public static void jump(){
        if(canJump && jumpTimer <= 3){
            jumping = true;
            jumpTimer++;
            velY = -10;
            System.out.println(jumpTimer);
        }
        else{
            canJump = false;
            velY = 0;
        }
    }

    public void tick(){
        x += velX;
        y += velY;
        y += 5;
        collision();
    }

    private void collision(){
        
    }

    enum positionState {
        west,
        none,
        east
    }

    private BufferedImage playerImage;
    private BufferedImage playerEastWallImage;
    private BufferedImage playerWestWallImage;
    public void render(Graphics g){
        g.setColor(Color.BLACK);
        //g.drawRect(x, y, 48, 40);
        g.drawImage(playerImage, x, y, 48, 40, null);

        if(KeyInput.hitBoxes){g.drawRect(x, y, 48, 40);}
    }
}
