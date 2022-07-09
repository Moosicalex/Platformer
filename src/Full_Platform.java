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

    int height;
    int width;
    
    public Full_Platform(int x, int y, int width, int height, ID id, Handler handler){
        super(x, y, id);
        this.height = height;
        this.width = width;
        this.handler = handler;

        handler.addObject(new Platform(x, y, width, 1, 0, ID.Platform, handler));
        handler.addObject(new Platform(x + width, y, 1, height, 1, ID.Platform, handler));
        handler.addObject(new Platform(x, y + height, width, 1, 2, ID.Platform, handler));
        handler.addObject(new Platform(x, y, 1, height, 3, ID.Platform, handler));

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
      g.setColor(Color.RED);
      g.drawRect(x, y, width, height);
    }
}
