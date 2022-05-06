package com.csc.main;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertiesMrg {

    private static final Properties properties = new Properties();

    private PropertiesMrg(){

    }

    static {
        try {
            properties.load(ResourceMrg.class.getClassLoader().getResourceAsStream("configs"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getKey(String key){
       return properties.get(key);
    }

}
