import java.util.LinkedList;
import java.awt.Color;
import java.awt.Graphics;

public class Handler {
    
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    /********************************************
   * Method: tick                             *
   * Purpose: updates all of the game objects *
   * *****************************************/
    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    /*******************************************
   * Method: render                          *
   * Purpose: Renders the images for all of  *
   * the game objects.                       *
   * Paramaters: g = just an arbitrary       *
   * variable for rendering graphics         *
   * using the java.awt library              *
   * ****************************************/
    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }
      
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
}
