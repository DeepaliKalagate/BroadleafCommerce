package com.broadleafcommerce.base;

import com.broadleafcommerce.base.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Screenshots extends Browser
{
    /*
   Method for capturing screenshots
    */
    public void screenshot(WebDriver driver,String testName)
    {
        try
        {
            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            System.out.println("Driver:"+driver);
            File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile=new File("Screenshots"+testName+ LocalDateTime.now()+".jpg");
            FileUtils.copyFile(sourceFile,destinationFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
