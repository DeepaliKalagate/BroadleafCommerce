package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClearancePage extends TestBase
{
    @FindBy(className = "section-title")
    private WebElement clearancePageText;

    @FindBy(xpath = "//body[@class='locale-en_US index-page']/div[@class='main']/div[@class='container']/div[@id='category']/div[@id='category-search-content']/div[@id='right_column']/div[@id='products']/div[1]/div[1]/a[1]/div[1]")
    private WebElement clearanceItem;

    @FindBy(xpath = "//button[@class='btn btn-primary js-addToCart']")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement viewInCart;

    public ClearancePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public String verifyClearancePageTitle()
    {
        return driver.getTitle();
    }

    public boolean verifyClearancePageText()
    {
        return clearancePageText.isDisplayed();
    }

    public ShippingPage verifyClearancePageFields() throws InterruptedException
    {
        clearanceItem.click();
        Thread.sleep(1000);
        addToCart.click();
        Thread.sleep(1000);
        viewInCart.click();
        Thread.sleep(1000);
        return new ShippingPage(driver);
    }


}
