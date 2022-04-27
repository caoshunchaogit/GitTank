package com.csc;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        while (true){
            Thread.sleep(50);
            t.repaint();  //每隔50毫秒调用画笔的方法
        }
    }
}
