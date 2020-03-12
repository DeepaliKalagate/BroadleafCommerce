package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShippingPage extends BaseClass
{
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

    public ShippingPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setFullName(String name)
    {
        fullName.sendKeys(name);
    }

    public void setAddress1(String addressFirst)
    {
        address1.sendKeys(addressFirst);
    }

    public void setAddress2(String addressTwo)
    {
        address2.sendKeys(addressTwo);
    }

    public void setCity(String cityName)
    {
        city.sendKeys(cityName);
    }

    public void setState(String selectState)
    {
        Select select = new Select(state);
        select.selectByVisibleText(selectState);
    }

    public void setPostal(String postalCode)
    {
        postal.sendKeys(postalCode);
    }

    public void setPhoneNumber(String phoneNo)
    {
        phoneNumber.sendKeys(phoneNo);
    }

    public void setShippingMethod()
    {
        shippingMethod.click();
    }

    public void setClickToContinue()
    {
        clickToContinue.click();
    }

    public void setDefineCard()
    {
        cashOnDelivery.click();
    }

    public void setSameAddress()
    {
        sameAddress.click();
    }

    public void setContinueShopping()
    {
        continueShopping.click();
    }

    public void setPlaceOrder()
    {
        placeOrder.click();
    }
}
