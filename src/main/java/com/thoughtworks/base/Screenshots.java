package com.thoughtworks.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

public class Screenshots extends TestBase
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
            File destinationFile=new File("Screenshots/"+testName+".jpg");
            FileUtils.copyFile(sourceFile,destinationFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
