
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
    Boolean elongate;
    int xDir, yDir, x, y;

    public Snake() {
        snakePoints = new ArrayList<Point>();
        this.elongate = false;
        xDir = 0;
        yDir = 0;
        for (int i = 0; i < 21; i++) {
            snakePoints.add(new Point(200 + i * 4, 150));
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        for (Point p : snakePoints) {
            g.fillRect(p.getX(), p.getY(), 4, 4);
        }
    }

    public void move() {

        Point tempFirstPoint = snakePoints.get(0);
        Point lastPoint = snakePoints.get(snakePoints.size() - 1);
        snakePoints.set(0, new Point(tempFirstPoint.getX() + xDir * 4, tempFirstPoint.getY() + yDir * 4));

        for (int i = snakePoints.size() - 1; i == 1; i--) {
            snakePoints.set(i, snakePoints.get(i - 1));
        }

        if (elongate) {
            snakePoints.add(lastPoint);
            this.elongate = false;
        }

    }

    public void setElongate(Boolean elongate) {
        this.elongate = elongate;
    }

    public boolean snakeCollision() {
        for (int i = 1; i < snakePoints.size(); i++) {
            if (this.x == snakePoints.get(i).getX() && this.y == snakePoints.get(i).getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean wallCollision() {
        if (this.x >= 396 || this.x <= 0 || this.y >= 396|| this.y <= 0) {
            return true;
        }
        return false;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
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
}
