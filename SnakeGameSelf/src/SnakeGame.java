
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author e15
 */
public class SnakeGame extends Applet implements Runnable, KeyListener{
    
    Snake snake;
    Token token;
    Image img;
    Graphics gfx;
    Thread thread;
    
   public void init() {
       this.resize(400,400);
       img = createImage(400,400);
       gfx = img.getGraphics();
       snake = new Snake ();
       
       
   }

    public void run() {

    }

    public void paint () {
        
    }
    public void keyTyped(KeyEvent e) {
 
    }


    public void keyPressed(KeyEvent e) {

    }


    public void keyReleased(KeyEvent e) {

    }
    
}
