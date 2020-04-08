package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShippingPage extends TestBase
{
    @FindBy(id = "checkout")
    private WebElement shippingPageText;

    @FindBy(xpath = "//*[@id=\"cart\"]/div[3]/div[1]/div[2]/div[5]/div[1]/a/i")
    private WebElement clickOnCheckout;

    @FindBy(id = "fullName")
    private WebElement fullName;

    @FindBy(id = "addressLine1")
    private WebElement address1;

    @FindBy(id = "addressLine2")
    private WebElement address2;

    @FindBy(id="city")
    private WebElement city;

    @FindBy(id="stateProvinceRegion")
    private WebElement state;

    @FindBy(id="postalCode")
    private WebElement postal;

    @FindBy(id="phonePrimary")
    private WebElement phoneNumber;

    @FindBy(xpath = "//div[@class='col-sm-6 shipping-methods-wrapper']//div[2]//label[1]//span[1]")
    private WebElement shippingMethod;

    @FindBy(xpath = "//a[@class='btn btn-primary']//span[contains(text(),'Checkout')]")
    private WebElement clickToContinue;

    @FindBy(xpath = "//a[contains(text(),'Collect On Delivery')]")
    private WebElement cashOnDelivery;

    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    private WebElement continueShopping;

    @FindBy(xpath = "//div[@class='col-sm-4 checkout-stage-action']//span[contains(text(),'Place Your Order')]")
    private WebElement placeOrder;

    public ShippingPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public HomePage VerifyShippingPage(String name,String addressFirst,String addressTwo,String cityName,String selectState,String postalCode,String phoneNo) throws InterruptedException
    {
        clickOnCheckout.click();
        Thread.sleep(500);
        fullName.sendKeys(name);
        address1.sendKeys(addressFirst);
        address2.sendKeys(addressTwo);
        city.sendKeys(cityName);
        Select select = new Select(state);
        select.selectByVisibleText(selectState);
        postal.sendKeys(postalCode);
        phoneNumber.sendKeys(phoneNo);
        Thread.sleep(500);
        shippingMethod.click();
        Thread.sleep(500);
        clickToContinue.click();
        Thread.sleep(500);
        cashOnDelivery.click();
        continueShopping.click();
        placeOrder.click();
        return new HomePage(driver);
    }
}
