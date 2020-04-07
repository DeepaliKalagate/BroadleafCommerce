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

    @FindBy(id = "fulfillmentOptionId1")
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
    }
    public HomePage VerifyShippingPage(String name,String addressFirst,String addressTwo,String cityName,String selectState,String postalCode,String phoneNo) throws InterruptedException
    {
        Thread.sleep(1000);
        fullName.sendKeys(name);
        address1.sendKeys(addressFirst);
        address2.sendKeys(addressTwo);
        city.sendKeys(cityName);
        Select select = new Select(state);
        select.selectByVisibleText(selectState);
        postal.sendKeys(postalCode);
        phoneNumber.sendKeys(phoneNo);
        shippingMethod.click();
        clickToContinue.click();
        cashOnDelivery.click();
        continueShopping.click();
        placeOrder.click();
        clickOnDropDown.click();
        clickOnLogout.click();
        return new HomePage(driver);
    }
}
