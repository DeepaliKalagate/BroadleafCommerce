package com.broadleafcommerce.pages;


import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotSaucePage extends TestBase
{
    @FindBy(className = "section-title")
    private WebElement hotsauceLable;

    @FindBy(xpath = "//input[@placeholder='search']")
    private WebElement searchSauce;

    @FindBy(xpath = "//ul[@class='js-typeahead--keyword']//a")
    private WebElement viewHotSuace;

    @FindBy(xpath = "//body[@class='locale-en_US index-page']/div[@class='main']/div[@class='container']/div[@id='search']/div[@id='category-search-content']/div[@id='right_column']/div[@id='products']/div[1]/div[1]/a[1]/div[1]")
    private WebElement quickViewOfHotSauce;

    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement viewInCart;

    public HotSaucePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public boolean verifyHotSaucePageLable()
    {
        return hotsauceLable.isDisplayed();
    }

    public ShippingPage verifyToShowHotSauses(String suace1) throws InterruptedException
    {
        searchSauce.sendKeys(suace1);
        Thread.sleep(1000);
        viewHotSuace.click();
        Thread.sleep(1000);
        quickViewOfHotSauce.click();
        Thread.sleep(1000);
        addToCart.click();
        Thread.sleep(1000);
        viewInCart.click();
        Thread.sleep(1000);
        return new ShippingPage(driver);
    }
}
