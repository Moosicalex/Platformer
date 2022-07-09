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
* It is original work without use of outside sources.                                        *
*                                                                                            *
*********************************************************************************************/


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


public class Map extends GameObject{
  
  private BufferedImage mapImage;
  
  
  public Map(int x, int y, ID id){
    super(x, y, id);
    
    try{
      mapImage = ImageIO.read(getClass().getResourceAsStream("images/map.png"));
    } catch(IOException e) {
       e.printStackTrace();
     }
  }
  
  /**************************************
   * Method: tick                       *
   * Purpose: updates the maps position *
   * using the mapX and mapY variables  *
   * in the KeyInput class.             *
   * ***********************************/
  public void tick() {

  }
  
  public Rectangle getBounds(){
        return new Rectangle(x, y, 0, 0);
  }
  
  
  public void render(Graphics g){
    g.drawImage(mapImage, x+30, y, Game.WIDTH*10, Game.HEIGHT*10, null);
  }
}
