package com.broadleafcommerce.base;

import com.broadleafcommerce.constantpaths.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass implements IConstants
{
    public static WebDriver driver;
    public static Properties property;
    public static FileInputStream fileInputStream;
    public BaseClass()
    {
        property = new Properties();
        try
        {
            fileInputStream = new FileInputStream("Config/config.properties");
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
        else
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
