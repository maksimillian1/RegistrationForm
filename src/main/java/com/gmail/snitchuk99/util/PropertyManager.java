package com.gmail.snitchuk99.util;

import java.io.*;
import java.util.Properties;

public class PropertyManager {

    private FileInputStream fis;
    private Properties props = new Properties();

    public void setPath(String path){
        try {
            fis = new FileInputStream(new File(path));
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key){
        return props.getProperty(key);
    }
}
