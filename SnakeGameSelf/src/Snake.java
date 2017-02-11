
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author e15
 */
public class Snake {

    Graphics g;
    List<Point> snakePoints;
    Boolean elongate, isMoving;
    int xDir, yDir, x, y;

    public Snake() {
        snakePoints = new ArrayList<Point>();
        this.elongate = false;
        xDir = 0;
        yDir = 0;
        for (int i = 20; i >= 0; i--) {
            snakePoints.add(new Point(200 + i * 4, 150));
        }
        isMoving = false;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        for (Point p : snakePoints) {
            g.fillRect(p.getX(), p.getY(), 4, 4);
        }
    }

    public void move() {

        if (isMoving) {
            Point tempFirstPoint = snakePoints.get(0);
            Point lastPoint = snakePoints.get(snakePoints.size() - 1);

            for (int i = snakePoints.size() - 1; i >= 1; i--) {
                snakePoints.set(i, snakePoints.get(i - 1));
            }
        snakePoints.set(0, new Point(tempFirstPoint.getX() + xDir * 4, tempFirstPoint.getY() + yDir * 4));
        
            if (elongate) {
                snakePoints.add(lastPoint);
                this.elongate = false;
            }
        }

    }

    public void setElongate(Boolean elongate) {
        this.elongate = elongate;
    }

    public boolean snakeCollision() {
        for (int i = 1; i < snakePoints.size() - 1; i++) {
            if (this.getX() == snakePoints.get(i).getX() && this.getY() == snakePoints.get(i).getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean wallCollision() {
        if (this.getX() >= 396 || this.getX() < 0 || this.getY() >= 396 || this.getY() < 0) {
            return true;
        }

        return false;
    }

    public int getX() {
        return this.snakePoints.get(0).getX();
    }

    public int getY() {
        return this.snakePoints.get(0).getY();
    }

    public int getXDir() {
        return xDir;
    }

    public int getYDir() {
        return yDir;
    }

    public void setXDir(int x) {
        this.xDir = x;
    }

    public void setYDir(int y) {
        this.yDir = y;
    }

    public void setIsMoving(boolean b) {
        this.isMoving = b;
    }

    public boolean getIsMoving() {
        return this.isMoving;
    }
}
