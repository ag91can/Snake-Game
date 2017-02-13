/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegameself2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author e15
 */
public class SnakeGame extends Applet implements Runnable, KeyListener {

    Graphics gfx;
    Image img;
    Snake snake;
    Token token;
    Thread thread;
    boolean gameOver;

    public void init() {
        this.resize(400, 400);
        img = createImage(400, 400);
        gfx = img.getGraphics();
        gameOver = false;
        this.addKeyListener(this);
        thread = new Thread(this);
        snake = new Snake();
        token = new Token(snake);
        thread.start();

    }

    public void run() {
        for (;;) {
            if (!gameOver) {
                snake.move();
                gameOverCheck();
                token.collisionDetectionToken();
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

        gfx.setColor(Color.BLACK);
        gfx.fillRect(0, 0, 400, 400);

        if (!gameOver) {
            snake.draw(gfx);
            token.draw(gfx);
        } else {
            gfx.setColor(Color.RED);
            gfx.drawString("game is over", 200, 200);
            gfx.drawString("Score: " + token.getScore(), 200, 250);
        }

        g.drawImage(img, 0, 0, null);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
       
        if (!snake.getisMoving()) {
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN
                    || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                snake.setIsMoving(true);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (snake.getY() != 1) {
                snake.setyDir(-1);
                snake.setxDir(0);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (snake.getY() != -1) {
                snake.setyDir(1);
                snake.setxDir(0);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (snake.getX() != 1) {
                snake.setyDir(0);
                snake.setxDir(-1);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (snake.getX() != -1) {
                snake.setyDir(0);
                snake.setxDir(1);
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void gameOverCheck() {
        if (snake.getX() <= 0 || snake.getX() >= 364 || snake.getY() <= 0 || snake.getY() >= 364 || snake.snakeCollision()) {
            this.gameOver = true;
        }
    }
}
