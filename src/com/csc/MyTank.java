package com.csc;

import sun.dc.pr.PRError;

import java.awt.*;

/**
 * 坦克类
 * */
public class MyTank {

    private int x =50,y=50;     //x y 为坦克初始的坐标
    private Dir dir = Dir.DOWN; //使坦克的默认方向向下
    final int SPEED = 10;
    private boolean moving = false;   //坦克的状态
    private T t;  //窗口类

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
    //移动的方法
    private void move() {
        if(!moving) return;  //如果不按键盘
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
    //子弹开火的方法
    public void file() {
        //new 出来一个子弹，在添加到窗口类的子弹集合中 xy和坦克的一致，
        t.bullets.add(new Bullet(x,y,dir));  //x y 为坐标的方向
    }
}
