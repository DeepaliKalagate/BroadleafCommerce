package com.broadleafcommerce.base;

import com.broadleafcommerce.properties.Library;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase implements IAutoConstants
{
    public static WebDriver driver;

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
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            String url= Library.getProperty(CONFIG_PATH,"URL");
            driver.get(url);

        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty(GECKO_KEY,GECKO_VALUE);
            driver = new FirefoxDriver();
            String url=Library.getProperty(CONFIG_PATH,"URL");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
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
