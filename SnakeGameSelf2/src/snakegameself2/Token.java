/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegameself2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author e15
 */
public class Token {

    int x, y, score;
    boolean tokenCollision;
    Snake s;

    public Token(Snake s) {
        this.x = (int) (Math.random() * 365);
        this.y = (int) (Math.random() * 365);
        this.tokenCollision = false;
        this.s = s;
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, 5, 5);
    }

    public void randomSpawn() {
        this.x = (int) (Math.random() * 365);
        this.y = (int) (Math.random() * 365);
    }

    public void collisionDetectionToken() {
        if (s.getX() >= x - 4 && s.getX() <= x + 5) {
            if (s.getY() >= y - 4 && s.getY() <= y + 5) {
                s.setElongate(true);
                this.randomSpawn();
                score++;
            }
        }
    }

    public int getScore() {
        return score;
    }

}
