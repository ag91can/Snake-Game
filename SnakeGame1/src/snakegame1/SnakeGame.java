/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame1;

/**
 *
 * @author e15
 */
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SnakeGame extends Applet implements Runnable, KeyListener {

    Graphics gfx;
    Image img;
    Thread thread;
    Snake snake;
    boolean gameOver;
    Token token;

    public void init() {
        this.resize(400, 400);
        img = createImage(400, 400);
        gfx = img.getGraphics();
        this.addKeyListener(this);
        gameOver = false;
        thread = new Thread(this);
        snake = new Snake();
        token = new Token(snake);
        thread.start();
    }

    public void paint(Graphics g) {
        gfx.setColor(Color.BLACK);
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

    public void run() {
        for (;;) {

            if (!gameOver) {
                snake.move();
                this.checkGameOver();
                token.snakeCollision();
            }

            this.repaint();

            try {
                Thread.sleep(40 - snake.getSnakeSpeed());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void checkGameOver() {
        if (snake.getX() < 0 || snake.getX() > 396) {
            this.gameOver = true;
        }

        if (snake.getY() < 0 || snake.getY() > 396) {
            this.gameOver = true;
        }

        if (snake.snakeCollision()) {
            this.gameOver = true;
        }
    }

    public void keyTyped(KeyEvent e) {
     
    }

    public void keyPressed(KeyEvent e) {

        if (!snake.isMoving()) {
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

    public void keyReleased(KeyEvent e) {
       
    }
}
