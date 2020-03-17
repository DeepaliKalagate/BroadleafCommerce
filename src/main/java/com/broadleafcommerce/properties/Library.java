package com.broadleafcommerce.properties;

import com.broadleafcommerce.base.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Library extends TestBase
{
    public static String getProperty(String CONFIG_PATH,String key)
    {
        String property="";
        Properties properties=new Properties();
        try
        {
            properties.load(new FileInputStream(CONFIG_PATH));
            property=properties.getProperty(key);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return property;
    }
}
