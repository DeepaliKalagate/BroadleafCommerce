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

    @FindBy(xpath = "//a[@class='btn btn-primary']")
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

    @FindBy(xpath = "//div[@class='checkbox use-shipping-address-wrapper']//span[@class='check']")
    private WebElement sameAddress;

    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    private WebElement continueShopping;

    @FindBy(xpath = "//div[@class='col-sm-4 checkout-stage-action']//span[contains(text(),'Place Your Order')]")
    private WebElement placeOrder;

    public ShippingPage()
    {
        PageFactory.initElements(driver,this);
    }

    public String verifyShippingPageTitle()
    {
        return driver.getTitle();
    }

    public boolean verifyShippingPageText()
    {
        return shippingPageText.isDisplayed();
    }

    public HomePage VerifyShippingPage(String name,String addressFirst,String addressTwo,String cityName,String selectState,String postalCode,String phoneNo)
    {
        clickOnCheckout.click();
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
        sameAddress.click();
        continueShopping.click();
        placeOrder.click();
        return new HomePage();
    }
}
