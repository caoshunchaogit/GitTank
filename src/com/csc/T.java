package com.csc;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
        //添加按键控制坦克的移动
        this.addKeyListener(new MyKeyList());
    }

    int x = 50,y=50;  //为了使方块能根据按键移动  设置为变量
    @Override
    public void paint(Graphics g) {  //当窗口重新绘画的时候会被调用
        g.setColor(Color.BLUE);
        g.fillRect(x,y,50,50);
        x += 10;
        y += 10;
    }


    //创建匿名内部类  处理对键盘的监听
    class MyKeyList extends KeyAdapter{
        @Override  //按下去 之后需要重画
        public void keyPressed(KeyEvent e) {
          //  x += 200;
           // repaint(); //会默认调用paint的方法

        }

        @Override  //抬起来
        public void keyReleased(KeyEvent e) {

        }
    }
}
