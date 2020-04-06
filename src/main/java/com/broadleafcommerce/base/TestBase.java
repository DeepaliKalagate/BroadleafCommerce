package com.broadleafcommerce.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase implements IAutoConstants
{
    public static WebDriver driver;
    public static Properties property;
    public static FileInputStream fileInputStream;
    public static String filePath="src/main/java/com/broadleafcommerce/config/config.properties";

    public TestBase()
    {
        property = new Properties();
        try
        {
            fileInputStream = new FileInputStream(filePath);
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

    @Parameters("browserName")
    @BeforeMethod
    public void setUP(String browserName) throws InterruptedException
    {
        if(browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty(CHROME_KEY,CHROME_VALUE);
            driver = new ChromeDriver();
            String url= property.getProperty("URL");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
            driver.get(url);

        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty(GECKO_KEY,GECKO_VALUE);
            driver = new FirefoxDriver();
            String url= property.getProperty("URL");
            //Maximize window
            driver.manage().window().maximize();
            //Delete all page coockies
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
            driver.get(url);
        }
    }
    //Method for Tear Down Browser
    @AfterMethod(description = "close driver after test")
    public void tearDown()
    {
        driver.close();
    }
}
