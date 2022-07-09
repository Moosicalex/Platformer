import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.Canvas;


import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;
  
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.applet.*;

public class Full_Platform  extends GameObject{
    Handler handler;
    
    Platform north = new Platform(0, 0, 1, 1, 0, ID.Platform, handler);
    Platform east = new Platform(0, 0, 1, 1, 1, ID.Platform, handler);
    Platform south = new Platform(0, 0, 1, 1, 2, ID.Platform, handler);
    Platform west = new Platform(0, 0, 1, 1, 3, ID.Platform, handler);
    

    int height;
    int width;
    
    public Full_Platform(int x, int y, int width, int height, ID id, Handler handler){
        super(x, y, id);
        this.height = height;
        this.width = width;
        this.handler = handler;

        this.north.setWidth(width);
        this.north.setX(x);
        this.north.setY(y - height);
        handler.addObject(north);

        this.south.setWidth(width);
        this.south.setX(x);
        this.south.setY(y);
        handler.addObject(south);
        
        this.east.setHeight(height);
        this.east.setX(x);
        this.east.setY(y);
        handler.addObject(east);

        this.west.setHeight(height);
        this.west.setX(x-width);
        this.west.setY(y);
        handler.addObject(west);

        try{
            dialogueBox = ImageIO.read(getClass().getResourceAsStream("images/dialogueBox.png"));
          } catch(IOException e) {
             e.printStackTrace();
           }
    }

    public void tick(){}

    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
      }
    
    private BufferedImage dialogueBox;
    public void render(Graphics g){
        g.drawImage(dialogueBox, x, y, width, height, null);
    }
}
