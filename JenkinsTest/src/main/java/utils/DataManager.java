package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataManager {

    public static String getText(String text){
        try {
            Properties property;
            FileInputStream fis;
            property = new Properties();
            fis = new FileInputStream("src/main/resources/testData.properties");
            property.load(fis);
            return property.getProperty(text);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}