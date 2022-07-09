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

public class Platform extends GameObject{
    Handler handler;
    int width;
    int height;
    int face;

    public Platform(int x, int y, int width, int height, int face, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        this.width = width;
        this.height = height;
        this.face = face;
    }

    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }

    public void tick(){
        collision();
    }

    private void collision(){
        for(int i = 0; i< handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player && getBounds().intersects(tempObject.getBounds())){
                /* the 'face' of the platform is the side that pushes back on the player
                0 = north
                1 = east
                2 = south
                3 = west
                */
                if(this.face == 0){tempObject.y -= 5;}
                else if(this.face == 1){tempObject.x += 5;}
                else if(this.face == 2){tempObject.y += 5;}
                else if(this.face == 3){tempObject.x -= 5;}
            }
        }
    }

    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }
}
