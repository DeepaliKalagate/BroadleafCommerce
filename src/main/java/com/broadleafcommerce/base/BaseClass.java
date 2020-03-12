package com.broadleafcommerce.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass
{
    public static WebDriver driver;
    public static Properties property;
    public static FileInputStream fileInputStream;
    public BaseClass()
    {
        property = new Properties();
        try
        {
            fileInputStream = new FileInputStream("java/com/broadleafcommerce/config/config.properties");
            property.load(fileInputStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void initiation()
    {
        if(property.getProperty("browser").equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(property.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(property.getProperty("URL"));
    }

    //Method for Tear Down Browser
    @AfterMethod(description = "close driver after test")
    public void tearDown()
    {
        driver.close();
    }
}
