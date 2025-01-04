package com.atroush.gui.helper;

import org.json.JSONObject;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class JsonFileParser {
    private JSONObject jsonObject;

    public JsonFileParser() throws IOException {

        StringBuilder jsonData = new StringBuilder();
        String baseDir = System.getProperty("user.dir");
        System.out.println("Base" + baseDir);
        BufferedReader reader = new BufferedReader(new FileReader(baseDir + "//src//Helper//java//com//atroush//gui//testdata//AdressDetails.json"));
        String line;
        while ((line = reader.readLine()) != null) {
            jsonData.append(line);
        }
        reader.close();
        jsonObject = new JSONObject(jsonData.toString());
    }

    public String getValue(String key) {
        return jsonObject.getString(key);
    }
}