package com.atroush.gui.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;


    public ConfigReader() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/java/com/atroush/gui/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("IO Exception" + e.getMessage());
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
