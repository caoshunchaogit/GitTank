package com.csc;

import sun.dc.pr.PRError;

import java.awt.*;

/**
 * 坦克类
 * */
public class MyTank {

    private int x = 50,y=50;  //为了使方块能根据按键移动  设置为变量
    private Dir dir = Dir.DOWN; //使坦克的默认方向向下
    final int SPEED = 10;
    private boolean moving = false;
    private T t;

    public MyTank(int x, int y, Dir dir,T t) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.t = t;
    }
    public Dir getDir() {
        return dir;
    }
    public void setDir(Dir dir) {
        this.dir = dir;
    }
    public boolean getMoving() {
        return moving;
    }
    public void setMoving(boolean moving) {
        this.moving = moving;
    }
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x,y,50,50);
        //根据dir的方向让坦克移动位置
        move();
    }
    private void move() {
        if(!moving) return;
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

    public void file() {
        t.bullets.add(new Bullet(x,y,dir));
    }
}
