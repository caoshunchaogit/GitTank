package com.csc.test;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        try {
            BufferedImage read = ImageIO.read(Test.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
