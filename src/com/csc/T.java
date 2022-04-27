package com.csc;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setResizable(false); //设置大小不可变
        f.setSize(1000,1000); //设置宽高
        f.setTitle("曹顺超的坦克大战");  //设置标题
        f.setVisible(true);  //设置窗口可见
        //添加窗口的监听器  通过窗口的适配器
        f.addWindowListener(new WindowAdapter() {
            @Override   //当点小x的时候会触发
            public void windowClosing(WindowEvent e) {
                System.exit(0);  //系统退出
            }
        });

    }
}
