package com.broadleafcommerce.base;

import com.broadleafcommerce.constantpaths.IConstants;
import com.broadleafcommerce.property.Library;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class Browser implements IConstants
{
    public static WebDriver driver;

    // Method for launching the browser
    @Parameters("browser")
    @BeforeTest(description = "load driver for test")
    public void setUp(String browser)
    {
        ChromeOptions chromeOptions=new ChromeOptions();
        if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty(CHROMEKEY,CHROMEVALUE);
            chromeOptions.addArguments("--disable-notifications");
            driver=new ChromeDriver();
            String url=Library.getProperty(CONFIG_PATH,"URL");
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
            driver.get(url);
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty(FIREFOXKEY,FIREFOXVALUE);
            driver=new FirefoxDriver();
            String url=Library.getProperty(CONFIG_PATH,"URL");
            driver.manage().window().maximize();
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
