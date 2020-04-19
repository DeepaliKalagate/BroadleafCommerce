package com.thoughtworks.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends TestBase implements ITestListener
{
    Screenshots screenshots =new Screenshots();

    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println("In the OnTestStart Method");
        screenshots.screenshot(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("In the OnTestSuccess Method");
        screenshots.screenshot(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println("In the OnTestFailure Method");
        screenshots.screenshot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        System.out.println("In the OnTestSkipped Method");
        screenshots.screenshot(result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {

    }

    @Override
    public void onStart(ITestContext context)
    {

    }

    @Override
    public void onFinish(ITestContext context)
    {

    }
}
