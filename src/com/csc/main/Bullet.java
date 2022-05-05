package com.csc.main;

import java.awt.*;

/**
 * 子弹类
 * */
public class Bullet {
    private int x ;
    private int y;
    private Dir dir;
    private T t = null;
    public Group group;

    public static final int SPEED = 10;  //速度
    public static final int WHIT = 15,HEIGHT = 15;
    public boolean living = true;  //子弹的生存状态
    public static final int WIDTHB = ResourceMrg.bulletD.getWidth();
    public static final int HEIGHTB = ResourceMrg.bulletD.getHeight();


    public Bullet(int x, int y, Dir dir, T t,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.t = t;
        this.group = group;
    }

    //画子弹的方法
    public void paint(Graphics g) {
        if(!living){
            t.bullets.remove(this);
        }
        switch (dir){
            case UP:
                g.drawImage(ResourceMrg.bulletU,x+20,y+23,null);
                break;
            case DOWN:
                g.drawImage(ResourceMrg.bulletD,x+18,y+23,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMrg.bulletR,x+20,y+23,null);
                break;
            case LEFT:
                g.drawImage(ResourceMrg.bulletL,x+20,y+23,null);
        }
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
        if(x < 0 || y <  0 ||  x > 1000 || y > 1000) living = false;

    }

    public void collideWith(MyTank myTank) {
        Rectangle rectangle = new Rectangle(this.x,this.y,WHIT,HEIGHT);
        Rectangle rectangle1 = new Rectangle(myTank.getX(),myTank.getY(),MyTank.WIDTH,MyTank.HEIGHT);
        if(group == myTank.group) return;
        if(rectangle.intersects(rectangle1)){
            myTank.die();
            this.die();
            int eX = myTank.getX() + MyTank.WIDTH/2 - Explodes.WIDTH/2;
            int eY = myTank.getY() + MyTank.HEIGHT - Explodes.HEIGHT/2;
            t.explodes.add(new Explodes(eX,eY,t));
        }
    }

    private void die() {
        this.living = false;
    }
}
