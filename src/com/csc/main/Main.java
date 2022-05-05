package com.csc.main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 主方法
 * */
public class Main {
    public static void main(String[] args) throws  Exception {
        T t = new T();
        for(int i = 0; i < 5; i++){
            t.tanks.add(new MyTank(100 + i * 50,30,Dir.DOWN, t,Group.BOD));
        }
        while (true){
            Thread.sleep(50);
            t.repaint();  //每隔50毫秒调用画笔的方法
        }

    }
}
