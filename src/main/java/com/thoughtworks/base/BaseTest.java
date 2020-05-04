package com.thoughtworks.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
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
    DesiredCapabilities capabilities;
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

    @Parameters("browserName")
    @BeforeMethod
    public void setUp(String browser) throws MalformedURLException
    {
        if(browser.equals("chrome"))
        {
            capabilities = DesiredCapabilities.chrome();
        }
        else if(browser.equals("firefox"))
        {
            capabilities = DesiredCapabilities.firefox();
        }
        driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capabilities);
        String url = property.getProperty("URL");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
    }

    //Method for Tear Down Browser
    @AfterMethod(description = "close driver after test")
    public void tearDown()
    {
        driver.close();
    }
}
