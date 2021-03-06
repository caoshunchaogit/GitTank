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

    public static final int SPEED = 15;  //速度
    public static final int WHIT = 15,HEIGHT = 15;
    public boolean living = true;  //子弹的生存状态
    public static final int WIDTHB = ResourceMrg.bulletD.getWidth();
    public static final int HEIGHTB = ResourceMrg.bulletD.getHeight();
    Rectangle rectangle = new Rectangle();

    public Bullet(int x, int y, Dir dir, T t,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.t = t;
        this.group = group;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WHIT;
        rectangle.height = HEIGHT;
    }

    //画子弹的方法
    public void paint(Graphics g) {
        if(!living){
            t.bullets.remove(this);
        }
        switch (dir){
            case UP:
                g.drawImage(ResourceMrg.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMrg.bulletD,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMrg.bulletR,x,y,null);
                break;
            case LEFT:
                g.drawImage(ResourceMrg.bulletL,x,y,null);
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

        rectangle.x = x;
        rectangle.y = y;

        if(x < 0 || y <  0 ||  x > 1000 || y > 1000) living = false;

    }

    public void collideWith(MyTank myTank) {
        if(group == myTank.group) return;
        if(rectangle.intersects(myTank.rectangle)){
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

    public void collideWith2(Bullet bullet) {
        if(group == bullet.group) return;
        if(rectangle.intersects(bullet.rectangle)){
            this.die();
        }
    }
}
