import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
    
    private Handler handler;
    public static boolean hitBoxes;
    public KeyInput(Handler handler){
        this.handler = handler;
        this.hitBoxes = false;
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

            GameObject tempObject = handler.object.get(0);

            if(tempObject.getId() == ID.Player){

                if(key == KeyEvent.VK_UP) Player.jump();
                //else if(key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
                else if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
                else if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
                else if(key == KeyEvent.VK_M) this.hitBoxes = !hitBoxes;
                else{ tempObject.setVelX(0); tempObject.setVelY(0);}
            }
            else{System.out.println("Wrong index for player");}
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        GameObject tempObject = handler.object.get(0);

            if(tempObject.getId() == ID.Player){

                if(key == KeyEvent.VK_UP){Player.canJump = false; Player.jumpTimer = 4; tempObject.setVelY(0);} 
                //else if(key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
                else if(key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
                else if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
                else if(key == KeyEvent.VK_M) this.hitBoxes = !hitBoxes;
                else{tempObject.setVelX(0); tempObject.setVelY(0);}
            }
            else{System.out.println("Wrong index for player");}
      }
}
