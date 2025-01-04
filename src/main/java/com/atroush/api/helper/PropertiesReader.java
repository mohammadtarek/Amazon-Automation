package com.atroush.api.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static String getValue(String key) {
        Properties properties = new Properties();
        try {
            properties.load(new BufferedReader(new FileReader("src/main/java/com/atroush/api/config.properties")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  properties.getProperty(key);
    }
}
