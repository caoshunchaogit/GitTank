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
    public static final int WIDTH = ResourceMrg.goodTankD.getWidth();
    public static final int HEIGHT = ResourceMrg.goodTankD.getHeight();
    public boolean living = true;  //坦克的生死状态
    public Random random = new Random();

    Rectangle rectangle = new Rectangle();

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

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
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
                g.drawImage( this.group== Group.GOOD ? ResourceMrg.goodTankU : ResourceMrg.badTankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group== Group.GOOD ? ResourceMrg.goodTankD : ResourceMrg.badTankD,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group== Group.GOOD ? ResourceMrg.goodTankR : ResourceMrg.badTankR,x,y,null);
                break;
            case LEFT:
                g.drawImage(this.group== Group.GOOD ? ResourceMrg.goodTankL : ResourceMrg.badTankL,x,y,null);
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
        rectangle.x = x;
        rectangle.y = y;

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
        int bX = this.x + MyTank.WIDTH/2 - Bullet.WIDTHB/2;
        int bY = this.y + MyTank.HEIGHT/2 - Bullet.HEIGHTB/2;
        //new 出来一个子弹，在添加到窗口类的子弹集合中 xy和坦克的一致，
        t.bullets.add(new Bullet(bX,bY,dir,this.t,this.group));  //x y 为坐标的方向
    }

    //坦克死亡的方法
    public void die() {
        this.living = false;
    }
}
