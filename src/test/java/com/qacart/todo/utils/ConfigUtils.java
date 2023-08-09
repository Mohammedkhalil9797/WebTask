package com.qacart.todo.utils;

import java.io.*;
import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    public static ConfigUtils configUtils;
    public static ConfigUtils getInstance()
    {
        if(configUtils==null)
        {
            configUtils=new ConfigUtils();
        }
        return configUtils;
    }
    /*
    private ConfigUtils()
    {
        String env=System.getProperty("env","PRODUCTION");
        switch (env)
        {
            case "PRODUCTION":
                properties=PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/productions.properties");
                break;
            case "LOCAL":
                properties=PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/local.properties");
                break;
            default:
                throw new RuntimeException("the file does not support");
        }

    }*/
    public String getBaseUrl()
    {
        String prop=properties.getProperty("baseUrl");
        if(prop!=null)
        return prop;
        throw new RuntimeException("could not find url in file");
    }
    public String getEmail()
    {
        String prop=properties.getProperty("email");
        if(prop!=null)
            return prop;
        throw new RuntimeException("could not find email in file");
    }
    public String getPass()
    {
        String prop=properties.getProperty("pass");
        if(prop!=null)
            return prop;
        throw new RuntimeException("could not find pass in file");
    }
    public String getRunner()
    {
        properties=loadProperties("src/test/java/com/qacart/todo/config/productions.properties");
        String prop=properties.getProperty("browser");
        if(prop!=null)
            return prop;
        throw new RuntimeException("could not find pass in file");
    }
    public static Properties loadProperties(String filePath)
    {
        File file=new File(filePath);

        try {
            InputStream inputStream=new FileInputStream(file);
            Properties properties=new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException("File is Not Found");
        } catch (IOException e) {
            throw new RuntimeException("Error while loading properties");
        }
    }
}
