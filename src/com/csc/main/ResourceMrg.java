package com.csc.main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMrg {
    public static BufferedImage goodTankL,goodTankU,goodTankD,goodTankR;  //好坦克

    public static BufferedImage badTankL,badTankU,badTankD,badTankR;   //坏的

    public static BufferedImage bulletR,bulletL,bulletU,bulletD;

    public static BufferedImage[] explodes = new BufferedImage[16];


    static {
        try {
            goodTankU =  ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/goodTank1.png"));
            goodTankD =  ImageUtil.rotateImage(goodTankU,180);
            goodTankR =  ImageUtil.rotateImage(goodTankU,90);
            goodTankL =  ImageUtil.rotateImage(goodTankU,270);

            badTankU = ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankD = ImageUtil.rotateImage(badTankU,180);
            badTankL = ImageUtil.rotateImage(badTankU,270);
            badTankR = ImageUtil.rotateImage(badTankU,90);

//            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//            GraphicsDevice gd = ge.getDefaultScreenDevice();
//            GraphicsConfiguration gc = gd.getDefaultConfiguration();

//            tankLD = create(tankD,180,gc);
////            tankR = create(tankD,270,gc);
////            tankL = create(tankD,90,gc);


            bulletD =  ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            bulletU =  ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletR =  ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletL =  ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));





            for(int i = 0; i<explodes.length;i++){
                explodes[i] = ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) +".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public static BufferedImage create(BufferedImage image, double angle,
//                                       GraphicsConfiguration gc) {
//        double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
//        int w = image.getWidth(), h = image.getHeight();
//        int neww = (int) Math.floor(w * cos + h * sin), newh = (int) Math.floor(h
//                * cos + w * sin);
//        int transparency = image.getColorModel().getTransparency();
//        BufferedImage result = gc.createCompatibleImage(neww, newh, transparency);
//        Graphics2D g = result.createGraphics();
//        g.translate((neww - w) / 2, (newh - h) / 2);
//        g.rotate(angle);
//        g.drawRenderedImage(image, null);
//        return result;
//    }
}
