
import java.applet.Applet;
import java.awt.Color;
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
public class SnakeGame extends Applet implements Runnable, KeyListener {

    Snake snake;
    Token token;
    Image img;
    Graphics gfx;
    Thread thread;
    Boolean gameOver;

    public void init() {
        this.resize(400, 400);
        img = createImage(400, 400);
        gfx = img.getGraphics();
        snake = new Snake();
        thread = new Thread(this);
        token = new Token(snake);
        thread.start();
        gameOver = false;
    }

    public void run() {
        for (;;) {
            if (!gameOver) {
                this.checkGameOver();
                token.checkCollisionWithToken();
                snake.move();
            }
            this.repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        gfx.setColor(Color.black);
        gfx.fillRect(0, 0, 400, 400);

        if (!gameOver) {
            snake.draw(gfx);
            token.draw(gfx);
        } else {
            //code here to get the game over screen
        }

        g.drawImage(img, 0, 0, null);
    }

    public void checkGameOver() {
        if (snake.snakeCollision() || snake.wallCollision()) {
            this.gameOver = true;
        }
        this.gameOver = false;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

}
