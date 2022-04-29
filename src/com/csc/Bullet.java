package com.csc;

import java.awt.*;

/**
 * 子弹类
 * */
public class Bullet {
    private int x ;
    private int y;
    private Dir dir;

    public static final int SPEED = 5;  //速度
    public static final int WHIT = 20,HEIGHT = 20;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }


    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WHIT,HEIGHT);
        g.setColor(color);
        move();
    }

    private void move() {
        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
    }
}
