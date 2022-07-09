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
    public Player(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;

        try{
            playerImage = ImageIO.read(getClass().getResourceAsStream("images/player.png"));
          } catch(IOException e) {
             e.printStackTrace();
           }
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 48, 40);
      }

    public void tick(){
        x += velX;
        y += velY;
        y += 5;
        collision();
    }

    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
        }
    }

    private BufferedImage playerImage;
    public void render(Graphics g){
        g.setColor(Color.BLACK);
        //g.drawRect(x, y, 48, 40);
        g.drawImage(playerImage, x, y, 48, 40, null);
    }
}
