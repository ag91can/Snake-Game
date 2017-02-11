/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame1;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author e15
 */
public class Token {

    private int x, y, score;
    private Snake snake;

    public Token(Snake s) {
        x = (int) (Math.random() * 395);
        y = (int) (Math.random() * 395);
        snake = s;
    }

    public int getScore() {
        return score;
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, 6, 6);
    }

    public void changePosition() {
        x = (int) (Math.random() * 395);
        y = (int) (Math.random() * 395);
    }

    public boolean snakeCollision() {
        int snakeX = snake.getX();
        int snakeY = snake.getY();
        if (snakeX >= x - 1 && snakeX <= (x + 6)) {
            if (snakeY >= y - 1 && snakeY <= (y + 6)) {
                changePosition();
                snake.setElongate(true);
                score++;
                if (score < 21) {
                    snake.increaseSnakeSpeed();
                }
                return true;

            }
        }
        return false;
    }
}
