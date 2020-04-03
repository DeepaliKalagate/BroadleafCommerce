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

    @FindBy(xpath = "//span[contains(text(),'Checkout')]")
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

    @FindBy(xpath = "//div[@class='col-sm-6 shipping-methods-wrapper']//div[1]//label[1]//span[1]")
    private WebElement shippingMethod;

    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    private WebElement clickToContinue;

    @FindBy(xpath = "//a[contains(text(),'Collect On Delivery')]")
    private WebElement cashOnDelivery;

    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    private WebElement continueShopping;

    @FindBy(xpath = "//div[@class='col-sm-4 checkout-stage-action']//span[contains(text(),'Place Your Order')]")
    private WebElement placeOrder;

    @FindBy(xpath = "//body[@class='locale-en_US index-page']/nav[@id='sectionsNav']/div[@class='container-fluid']/div[@class='collapse navbar-collapse nav-wrapper']/ul[@class='nav navbar-nav navbar-right']/li[@class='dropdown']/a[1]")
    private WebElement clickOnDropDown;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement clickOnLogout;

    public ShippingPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setClickOnCheckout() throws InterruptedException
    {
        clickOnCheckout.click();
        Thread.sleep(1000);
    }

    public HomePage verifyShippingPage(String name, String addressFirst, String addressTwo, String cityName, String selectState, String postalCode, String phoneNo) throws InterruptedException
    {
        fullName.sendKeys(name);
        Thread.sleep(1000);
        address1.sendKeys(addressFirst);
        Thread.sleep(1000);
        address2.sendKeys(addressTwo);
        Thread.sleep(1000);
        city.sendKeys(cityName);
        Thread.sleep(1000);
        Select select = new Select(state);
        select.selectByVisibleText(selectState);
        Thread.sleep(1000);
        postal.sendKeys(postalCode);
        Thread.sleep(1000);
        phoneNumber.sendKeys(phoneNo);
        Thread.sleep(1000);
        shippingMethod.click();
        Thread.sleep(1000);
        clickToContinue.click();
        Thread.sleep(1000);
        cashOnDelivery.click();
        Thread.sleep(1000);
        continueShopping.click();
        Thread.sleep(1000);
        placeOrder.click();
        Thread.sleep(1000);
        clickOnDropDown.click();
        Thread.sleep(1000);
        clickOnLogout.click();
        return new HomePage(driver);
    }
}
