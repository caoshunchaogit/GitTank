package com.csc;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T extends Frame {
    int x = 50,y=50;  //为了使方块能根据按键移动  设置为变量
    Dir dir = Dir.DOWN; //使坦克的默认方向向下
    final int SPEED = 10;

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


    //每隔50毫秒就会调用一次这个方法 会根据当前的方向进行移动
    @Override
    public void paint(Graphics g) {  //当窗口重新绘画的时候会被调用
        g.setColor(Color.BLUE);
        g.fillRect(x,y,50,50);
        //根据dir的方向让坦克移动位置
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


    //创建匿名内部类  处理对键盘的监听
    class MyKeyList extends KeyAdapter{

        //默认为false
        boolean BL = false;
        boolean BR = false;
        boolean BD = false;
        boolean BU = false;

        @Override  //按下去 之后需要重画
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:  //向左
                    BL = true;
                    break;
                case KeyEvent.VK_DOWN:  //向下
                    BD = true;
                    break;
                case KeyEvent.VK_RIGHT: //向右
                    BR = true;
                    break;
                case KeyEvent.VK_UP:   //向上
                    BU = true;
                    break;
            }
            setMainTankDir();
        }

        @Override  //抬起来
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            //当键按下去的时候改变状态
            switch (keyCode) {
                case KeyEvent.VK_LEFT:  //向左
                    BL = false;
                    break;
                case KeyEvent.VK_DOWN:  //向下
                    BD = false;
                    break;
                case KeyEvent.VK_RIGHT: //向右
                    BR = false;
                    break;
                case KeyEvent.VK_UP:   //向上
                    BU = false;
                    break;
            }
            //根据状态判断方向
            setMainTankDir();
        }
        //按键结束抬起修改坦克方向  结束之后会调用重画的方法
        private void setMainTankDir() {
            if(BL) dir = Dir.LEFT;
            if(BD) dir = Dir.DOWN;
            if(BR) dir = Dir.RIGHT;
            if(BU) dir = Dir.UP;
        }
    }
}
