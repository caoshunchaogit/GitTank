package com.csc.main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMrg {
    public static BufferedImage tankL,tankU,tankD,tankR,tankLD;

    public static BufferedImage bulletR,bulletL,bulletU,bulletD;

    public static BufferedImage[] explodes = new BufferedImage[16];


    static {
        try {
            tankD =  ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankU =  ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankR =  ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankL =  ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/tankL.gif"));

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gd.getDefaultConfiguration();

            tankLD = create(tankD,180,gc);
//            tankR = create(tankD,270,gc);
//            tankL = create(tankD,90,gc);


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


    public static BufferedImage create(BufferedImage image, double angle,
                                       GraphicsConfiguration gc) {
        double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
        int w = image.getWidth(), h = image.getHeight();
        int neww = (int) Math.floor(w * cos + h * sin), newh = (int) Math.floor(h
                * cos + w * sin);
        int transparency = image.getColorModel().getTransparency();
        BufferedImage result = gc.createCompatibleImage(neww, newh, transparency);
        Graphics2D g = result.createGraphics();
        g.translate((neww - w) / 2, (newh - h) / 2);
        g.rotate(angle);
        g.drawRenderedImage(image, null);
        return result;
    }
}
