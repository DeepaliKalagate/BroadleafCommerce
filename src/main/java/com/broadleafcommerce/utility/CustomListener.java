package com.broadleafcommerce.utility;

import com.broadleafcommerce.base.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.Date;

public class CustomListener extends Browser implements ITestListener
{
    Utility utility=new Utility();
    public CustomListener(WebDriver driver)
    {

    }

    @Override
    public void onTestStart(ITestResult result)
    {
        Date date=new Date();
        String imageName="Image"+date.toString();
        utility.screenshot(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        Date date=new Date();
        String imageName="Image"+date.toString();
        utility.screenshot(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        Date date=new Date();
        String imageName="Image"+date.toString();
        utility.screenshot(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        Date date=new Date();
        String imageName="Image"+date.toString();
        utility.screenshot(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context)
    {
        Date date=new Date();
        String imageName="Image"+date.toString();
        utility.screenshot(context.getClass().getName());
    }

    @Override
    public void onFinish(ITestContext context)
    {
        Date date=new Date();
        String imageName="Image"+date.toString();
        utility.screenshot(context.getClass().getName());
    }
}
