package com.csc.main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMrg {
    public static BufferedImage tankL,tankU,tankD,tankR;

    public static BufferedImage bulletR,bulletL,bulletU,bulletD;

    public static BufferedImage[] explodes = new BufferedImage[16];


    static {
        try {
            tankD =  ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankU =  ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankR =  ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankL =  ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/tankL.gif"));

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


}
