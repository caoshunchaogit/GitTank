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
    public static final int WHIT = 15,HEIGHT = 15;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    //画子弹的方法
    public void paint(Graphics g) {
        Color color = g.getColor();  //获取开始颜色
        g.setColor(Color.RED);  //画出红的子弹
        g.fillOval(x+17,y+17,WHIT,HEIGHT);  //子弹的
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
