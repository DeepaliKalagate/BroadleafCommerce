package com.broadleafcommerce.base;

import com.broadleafcommerce.constantpaths.IConstants;
import com.broadleafcommerce.property.Library;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;

public class Browser implements IConstants
{
    public static WebDriver driver;
    ChromeOptions chromeOptions=new ChromeOptions();

    // Method for launching the browser
    @BeforeTest(description = "load driver for test")
    public void setUp()
    {
        chromeOptions.addArguments("--disable-notifications");
        System.setProperty(CHROMEKEY,CHROMEVALUE);
        driver=new ChromeDriver(chromeOptions);
        String url= Library.getProperty(CONFIG_PATH,"URL");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get(url);
    }
}
