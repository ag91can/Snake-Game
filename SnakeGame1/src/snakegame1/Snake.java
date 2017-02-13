/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author e15
 */
public class Snake {
    //snake is a list of rectangles
    
    List<Point> snakePoints;
    int xDir, yDir, snakeSpeed; //it has a xDir and yDir
    boolean isMoving, elongate;
    final int StartSize = 20, startX = 150, startY = 150;

    public Snake() {
        this.snakePoints = new ArrayList<Point>();
        xDir = 0;
        yDir = 0;
        this.snakeSpeed = 0;
        this.isMoving = false;
        this.elongate = false;
        snakePoints.add(new Point(startX, startY));
        for (int i = 1; i < StartSize; i++) {
            snakePoints.add(new Point(startX - i * 4, startY));
        }

    }

    public void draw(Graphics g) {
        
        for (Point p : snakePoints) {
            g.setColor(Color.white);
            g.fillRect(p.getX(), p.getY(), 4, 4);
        }
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

    //get the head position of the snake, this is for collision detection
    public int getX() {
        return snakePoints.get(0).getX();
    }

    public int getY() {
        return snakePoints.get(0).getY();
    }
    
    public void setElongate (boolean b) {
        elongate = b;
    }
    public void move() {
        if (isMoving) {
            Point temp = snakePoints.get(0);
            Point last = snakePoints.get(snakePoints.size() - 1);
            Point newStart = new Point(temp.getX() + xDir * 4, temp.getY() + yDir * 4);
            
            
            for (int i = snakePoints.size() - 1; i >= 1; i--) {
                snakePoints.set(i, snakePoints.get(i - 1));
            }
            
            snakePoints.set(0, newStart);
            
            
            if (elongate) {
                snakePoints.add(last);
                elongate = false;
            }

        }
    }
    public boolean snakeCollision () {
        int x = this.getX();
        int y = this.getY();
        
        for (int i = 1; i < snakePoints.size() ; i++ ){
            if (snakePoints.get(i).getX() == x  && snakePoints.get(i).getY() == y){
                return true;
            }
        }
            return false;
    }
    
    public boolean isMoving(){
        return isMoving;
    }
    
    public void setIsMoving (boolean x) {
        this.isMoving = x;
    }

    public void increaseSnakeSpeed () {
        this.snakeSpeed = this.snakeSpeed + 3;
    }
    
    public int getSnakeSpeed () {
        return this.snakeSpeed;
    }
}
