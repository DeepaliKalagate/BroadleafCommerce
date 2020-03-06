package com.broadleafcommerce.utility;

import com.broadleafcommerce.base.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Utility extends Browser
{
    /*
   Method for capturing screenshots
    */
    public void screenshot(String testName)
    {
        try
        {
            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
            Date date=new Date();
            File destinationFile=new File("Screenshots"+date.toString());
            FileUtils.copyFile(sourceFile,destinationFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @AfterMethod(description = "close driver after test")
    public void tearDown()
    {
        driver.close();
    }
}
