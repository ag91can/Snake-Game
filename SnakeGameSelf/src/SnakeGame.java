
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
        gameOver = false;
        this.addKeyListener(this);
        thread.start();
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
            gfx.setColor(Color.RED);
            gfx.drawString("Game Over", 190, 180);
            gfx.drawString("Score: " + token.getScore(), 190, 170);
        }

        g.drawImage(img, 0, 0, null);
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void reprint(Graphics g) {
        paint(g);
    }

    public void checkGameOver() {
        if (snake.snakeCollision() || snake.wallCollision()) {
            this.gameOver = true;
        }

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
        if (!snake.getIsMoving()) {
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN
                    || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                snake.setIsMoving(true);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (snake.getYDir() != 1) {
                snake.setYDir(-1);
                snake.setXDir(0);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (snake.getYDir() != -1) {
                snake.setYDir(1);
                snake.setXDir(0);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (snake.getXDir() != 1) {
                snake.setYDir(0);
                snake.setXDir(-1);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (snake.getXDir() != -1) {
                snake.setYDir(0);
                snake.setXDir(1);
            }
        }

    }
}
