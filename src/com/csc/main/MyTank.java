package com.csc.main;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.awt.*;
import java.util.Random;

/**
 * 坦克类
 * */
public class MyTank {
    public int x ,y;     //x y 为坦克初始的坐标

    private Dir dir = Dir.UP; //使坦克的默认方向向上
    final int SPEED = 5;
    private boolean moving = true;   //坦克的状态
    private T t;  //窗口类
    public static final int WIDTH = ResourceMrg.tankD.getWidth();
    public static final int HEIGHT = ResourceMrg.tankD.getHeight();
    public boolean living = true;  //坦克的生死状态
    public Random random = new Random();
    public Group group = Group.BOD;

    public boolean getLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public MyTank(int x, int y, Dir dir, T t,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.t = t;
        this.group = group;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics g) {

        if(!living) t.tanks.remove(this);
        switch (dir){
            case UP:
                g.drawImage(ResourceMrg.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMrg.tankD,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMrg.tankR,x,y,null);
                break;
            case LEFT:
                g.drawImage(ResourceMrg.tankL,x,y,null);
        }
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

        if(y + HEIGHT >= 1000){
            y  = 1000 - HEIGHT;
        }
        if(y <= HEIGHT / 2){
            y  = HEIGHT / 2;
        }

        if(x + WIDTH >= 1000){
            x  = 1000 - WIDTH;
        }
        if(x <= 0){
            x  = 0;
        }

        if(this.group == Group.BOD && (random.nextInt(100) > 95))
            this.file();
        if(this.group == Group.BOD && random.nextInt(100)> 95){
            randomDir();
        }

    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    //子弹开火的方法
    public void file() {
        //new 出来一个子弹，在添加到窗口类的子弹集合中 xy和坦克的一致，
        t.bullets.add(new Bullet(x,y,dir,this.t,this.group));  //x y 为坐标的方向
    }

    //坦克死亡的方法
    public void die() {
        this.living = false;
    }
}
