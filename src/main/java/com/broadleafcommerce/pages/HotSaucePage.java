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

    @FindBy(xpath = "//div[@id='heading0']//i[@class='material-icons'][contains(text(),'keyboard_arrow_down')]")
    private WebElement manufacturer;

    @FindBy(id = "mfg-Dave%27s+Gourmet")
    private WebElement selectManufacturer;

    @FindBy(xpath = "//div[@id='heading1']//i[@class='material-icons'][contains(text(),'keyboard_arrow_down')]")
    private WebElement heatRange;

    @FindBy(xpath = "//div[@id='collapse1']//div[2]//label[1]//span[1]//span[1]")
    private WebElement selectHeatRange;

    @FindBy(xpath = "//div[@id='heading2']//i[@class='material-icons'][contains(text(),'keyboard_arrow_down')]")
    private WebElement price;

    @FindBy(xpath = "//div[@id='collapse2']//div[2]//label[1]//span[1]//span[1]")
    private WebElement selectPrice;


    @FindBy(xpath = "//body[@class='locale-en_US index-page']/div[@class='main']/div[@class='container']/div[@id='category']/div[@id='category-search-content']/div[@id='right_column']/div[@id='products']/div[1]/div[1]/a[1]/div[1]/div[1]")
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

    public void setManufacturer()
    {
        manufacturer.click();
    }
    public void setSelectManufacturer() throws InterruptedException
    {
        Thread.sleep(500);
        selectManufacturer.click();
    }

    public void setHeatRange()
    {
        heatRange.click();
    }
    public void setSelectHeatRange()
    {
        selectHeatRange.click();
    }

    public void setPrice()
    {
        price.click();
    }

    public void setSelectPrice()
    {
        selectPrice.click();
    }
    public void setViewHotSuace()
    {
        viewHotSuace.click();
    }

    public void setQuickViewOfHotSauce()
    {
        quickViewOfHotSauce.click();
    }

    public void setAddToCart()
    {
        addToCart.click();
    }

    public ShippingPage verifyToShowHotSauses()
    {
        viewInCart.click();
        return new ShippingPage(driver);
    }
}
