package com.csc.main;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 窗口类
 * */
public class T extends Frame {
    MyTank tank = new MyTank(500,800,Dir.DOWN,this,Group.GOOD);
    List<Bullet> bullets = new ArrayList<>();  //子弹集合
    List<MyTank> tanks = new ArrayList<>();  //敌方坦克的集合
    List<Explodes> explodes = new ArrayList<>();
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

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(1000, 1000);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, 1000, 1000);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }


    //每隔50毫秒就会调用一次这个方法 会根据当前的方向进行移动
    @Override
    public void paint(Graphics g) {//当窗口重新绘画的时候会被调用
        //在坦克类里创建方法，把画笔传进去，让坦克自己画自己

        tank.paint(g);  //画出主站坦克
        for(int i = 0;i < bullets.size(); i++){    //画出子弹
            bullets.get(i).paint(g);
        }
//        for(int i = 0;i < tanks.size(); i++){   //画出敌军坦克
//            tanks.get(i).paint(g);
//        }

        for(int i = 0;i < explodes.size(); i++){   //画出坦克爆炸
            explodes.get(i).paint(g);
        }

        //碰撞检测
        for(int i = 0; i < bullets.size(); i++ ){
            for(int j = 0; j < tanks.size(); j++){
                bullets.get(i).collideWith(tanks.get(j));
            }
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
                case KeyEvent.VK_CONTROL:
                    tank.file();
                    break;
            }
            //根据状态判断方向
            setMainTankDir();
        }
        //按键结束抬起修改坦克方向  结束之后会调用重画的方法
        private void setMainTankDir() {
            //如果都松开了，让moving为false
            if(!BL && !BD && !BR &&!BU) {
                tank.setMoving(false);
            } else {
                tank.setMoving(true); //按下去设置为true
                if(BL) tank.setDir( Dir.LEFT);
                if(BD) tank.setDir( Dir.DOWN);
                if(BR) tank.setDir( Dir.RIGHT);
                if(BU) tank.setDir( Dir.UP);
            }
        }
    }
}
