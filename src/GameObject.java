import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
    
    //protected varaibles are able to be inherited by the other object classes 
  protected int x, y;
  protected ID id;
  protected static int velX;
  protected static int velY;

  public GameObject(int x, int y, ID id){
    
    this.x = x;
    this.y = y;
    this.id = id;
    
  }

  public abstract void tick();
  public abstract void render(Graphics g);
  public abstract Rectangle getBounds();

  public void setX(int x){
    this.x = x;
  }

  public void setY(int y){
    this.y = y;
  }

  public int getX(){
    return this.x;
  }

  public int getY(){
    return y;
  }

  public void setId(ID id){
    this.id = id;
  }

  public ID getId(){
    return id;
  }

  public void setVelX(int velX){
    this.velX = velX;
  }

  public void setVelY(int velY){
    this.velY = velY;
  }

  public int getVelX(){
    return velX;
  }

  public int getVelY(){
    return velY;
  }
}
