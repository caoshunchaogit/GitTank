package com.csc;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T extends Frame {
    public T(){
        this.setResizable(false); //设置大小不可变
        this.setSize(1000,1000); //设置宽高
        this.setTitle("曹顺超的坦克大战");  //设置标题
        this.setVisible(true);  //设置窗口可见
        //添加窗口的监听器  通过窗口的适配器
        this.addWindowListener(new WindowAdapter() {
            @Override   //当点小x的时候会触发
            public void windowClosing(WindowEvent e) {
                System.exit(0);  //系统退出
            }
        });
    }

    @Override
    public void paint(Graphics g) {  //当窗口重新绘画的时候会被调用
        System.out.println("paint");
        g.fillRect(50,50,50,50);
    }
}
