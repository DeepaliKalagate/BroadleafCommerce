package com.thoughtworks.base;

import org.openqa.selenium.WebDriver;
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

public class BaseTest
{
    public WebDriver driver;
    public static Properties property;
    public static FileInputStream fileInputStream;
    public static String filePath="src/main/java/com/thoughtworks/config/config.properties";

    public BaseTest()
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

    @BeforeMethod
    @Parameters(value={"browserName"})
    public void setupTest (String browserName) throws MalformedURLException
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browser", browserName);
        driver=new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capabilities);
        String url= property.getProperty("URL");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
