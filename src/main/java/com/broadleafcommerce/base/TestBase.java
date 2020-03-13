package com.broadleafcommerce.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase
{
    public static WebDriver driver;
    public static Properties property;
    public static FileInputStream fileInputStream;

    /**
     * TestBase class constructor: Used to initialize the properties object to fetch
     * config(environment) variable from config.properties file
     */
    public TestBase()
    {
        property = new Properties();
        try
        {
            fileInputStream = new FileInputStream("src/main/java/com/broadleafcommerce/config/config.properties");
            property.load(fileInputStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Function Name:initiation This is used to initialize all the pre-requisites
     * Webdriver: reference initialization on the basis of browser
     * Property: Maximizing the window
     * get method: is used to get the application URL from property file
     */
    public static void initiation()
    {
        String browserName=property.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox"))
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
