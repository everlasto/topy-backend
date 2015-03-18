package com.topybackend.utils;

import com.topybackend.entities.exceptions.InvalidConfigValueException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.util.Properties;

/**
 * Singleton pattern for config service. READ ONLY.
 */
public class ConfigService {

    public static Properties config;

    static{
        InputStream in = ConfigService.class.getClassLoader().getResourceAsStream("application.properties");
        config = new Properties();
        try {
            config.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            //--log config load failed.
        }
        System.out.println("CONFIG LOADED SUCCESSFULLY.");
        //--log log that config had been loaded
    }

    public int getIntConfig(String key, int def){
        return getStringConfig(key, "").isEmpty()?def:Integer.parseInt(getStringConfig(key, ""));
    }

    public boolean getBoolConfig(String key){
        return getStringConfig(key, "").equals("true");
    }

    public float getFloatConfig(String key, float def){
        return getStringConfig(key, "").isEmpty()?def:Float.parseFloat(getStringConfig(key, ""));
    }

    public String getStringConfig(String key, String def){
        return config.getProperty(key, def);
    }

}
