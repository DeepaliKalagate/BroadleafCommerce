package com.broadleafcommerce.utility;

import com.broadleafcommerce.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends BaseClass implements ITestListener
{
    Screenshots utility=new Screenshots();
    public CustomListener(WebDriver driver)
    {
    }

    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println("In the OnTestStart Method");
        utility.screenshot(driver,result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("In the OnTestSuccess Method");
        utility.screenshot(driver,result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println("In the OnTestFailure Method");
        utility.screenshot(driver,result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        System.out.println("In the OnTestSkipped Method");
        utility.screenshot(driver,result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {

    }

    @Override
    public void onStart(ITestContext context)
    {
        System.out.println("In the OnStart Method");
        utility.screenshot(driver,context.getClass().getName());
    }

    @Override
    public void onFinish(ITestContext context)
    {
        System.out.println("In the OnFinish Method");
        utility.screenshot(driver,context.getClass().getName());
    }
}
