package com.broadleafcommerce.property;

import com.broadleafcommerce.base.Browser;

import java.io.FileInputStream;
import java.util.Properties;

public class Library extends Browser
{
    public static String getProperty(String CONFIG_PATH, String key)
    {
        String property="";
        Properties properties=new Properties();
        try
        {
            properties.load(new FileInputStream(CONFIG_PATH));
            property=properties.getProperty(key);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return property;
    }
}
