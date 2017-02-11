
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

    int x, y;
    Snake s;
    Boolean snakeCollision = false;

    public Token(Snake s) {
        this.s = s;
        this.x = (int) (Math.random() * 395);
        this.y = (int) (Math.random() * 395);
    }

    public void draw(Graphics g) {

        if (!snakeCollision) {
            g.setColor(Color.green);
            g.fillRect(x, y, 5, 5);
        }

    }

    public void randomizePosition() {
        this.x = (int) (Math.random() * 395);
        this.y = (int) (Math.random() * 395);
    }

    public boolean checkCollisionWithToken() {

        if (s.getX() >= this.x - 1 || s.getX() <= this.x + 5) {
            if (s.getY() >= this.y - 1 || s.getY() <= this.y + 5) {
                s.setElongate(true);
                randomizePosition();
                
            }
        }
    }

}
