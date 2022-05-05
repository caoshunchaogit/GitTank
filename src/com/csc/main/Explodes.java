package com.csc.main;

import java.awt.*;

/**
 * 子弹类
 * */
public class Explodes {
    public static final int WIDTH = ResourceMrg.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMrg.explodes[0].getHeight();

    private int x ;
    private int y;
    private T t = null;

    private int step = 0;


    public Explodes(int x, int y, T t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMrg.explodes[step++],x,y,null);
        if(step >= 16){
            t.explodes.remove(this);
        }
    }


}
