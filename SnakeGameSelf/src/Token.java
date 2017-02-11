
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author e15
 */
public class Token {

    int x, y, score;
    Snake s;
    Boolean snakeCollision = false;

    public Token(Snake s) {
        this.s = s;
        this.x = (int) (Math.random() * 395);
        this.y = (int) (Math.random() * 395);
    }

    public void draw(Graphics g) {

        g.setColor(Color.green);
        g.fillRect(x, y, 5, 5);

    }

    public void randomizePosition() {
        this.x = (int) (Math.random() * 395);
        this.y = (int) (Math.random() * 395);
    }

    public void checkCollisionWithToken() {
        int snakeX = s.getX();
        int snakeY = s.getY();
        
        if (snakeX >= this.x -1 && snakeX <= this.x + 5) {
            if (snakeY >= this.y - 1 && snakeY <= this.y + 5) {
                s.setElongate(true);
                randomizePosition();
                score++;
            }
        }
    }

    public int getScore() {
        return score;
    }

}
