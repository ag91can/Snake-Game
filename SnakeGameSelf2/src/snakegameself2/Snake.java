/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegameself2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e15
 */
public class Snake {

    int firstX, firstY, xDir, yDir;
    List<Points> snakePoints;
    boolean elongate, isMoving;

    public Snake() {
        xDir = 0;
        yDir = 0;
        firstX = 150;
        firstY = 150;
        snakePoints = new ArrayList<>();
        elongate = false;
        isMoving = false;

        for (int i = 0; i < 21; i++) {
            snakePoints.add(i, new Points(firstX - i * 4, firstY));
        }
    }

    public void draw(Graphics g) {
        for (Points i : snakePoints) {
            g.setColor(Color.white);
            g.fillRect(i.getX(), i.getY(), 4, 4);
        }
    }

    public void move() {
        if (isMoving) {
            Points lastPoint = snakePoints.get(snakePoints.size() - 1);
            Points firstPoints = snakePoints.get(0);
            Points newTempFirstPoint = new Points(firstPoints.getX() + xDir * 4, firstPoints.getY()+ yDir * 4);

            for (int i = snakePoints.size() - 1; i >= 1; i--) {
                snakePoints.set(i, snakePoints.get(i - 1));
            }

            snakePoints.set(0, newTempFirstPoint);

            if (elongate) {
                snakePoints.add(lastPoint);
                elongate = false;
            }
        }
    }

    public void setxDir(int xDir) {
        this.xDir = xDir;
    }

    public void setyDir(int yDir) {
        this.yDir = yDir;
    }

    public boolean snakeCollision() {

        for (int i = 1; i <= snakePoints.size() - 1; i++) {
            if (snakePoints.get(0).getX() == snakePoints.get(i).getX() && snakePoints.get(0).getY() == snakePoints.get(i).getY()) {
                return true;
            }
        }

        return false;
    }

    public int getX() {
        return snakePoints.get(0).getX();
    }

    public int getY() {
        return snakePoints.get(0).getY();
    }

    public void setElongate(boolean elongate) {
        this.elongate = elongate;
    }

    public void setIsMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }
    
    public boolean getisMoving () {
        return this.isMoving;
    }

}
