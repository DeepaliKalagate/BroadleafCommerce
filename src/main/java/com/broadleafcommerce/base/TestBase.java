package com.broadleafcommerce.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

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

    @Parameters("browserName")
    @BeforeMethod
    public void setUP(String browserName) throws MalformedURLException {
        if(browserName.equalsIgnoreCase("chrome"))
        {
            DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
            desiredCapabilities.setBrowserName(BrowserType.CHROME);
            driver=new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"),desiredCapabilities);
            String url= property.getProperty("URL");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(url);
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
            desiredCapabilities.setBrowserName(BrowserType.FIREFOX);
            driver=new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"),desiredCapabilities);
            String url= property.getProperty("URL");
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
