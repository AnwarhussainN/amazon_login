package com.anwar.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {

            FileInputStream file =
                    new FileInputStream("src/test/resources/config.properties");

            properties = new Properties();

            properties.load(file);

            file.close();

        } catch (IOException e) {

            e.printStackTrace();
            throw new RuntimeException("Unable to load config.properties");
        }
    }

    public static String get(String key) {

        return properties.getProperty(key);
    }
}