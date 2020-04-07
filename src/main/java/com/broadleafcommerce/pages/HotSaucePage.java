package com.broadleafcommerce.pages;


import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotSaucePage extends TestBase
{
    @FindBy(className = "section-title")
    private WebElement hotsauceLable;

    @FindBy(xpath = "//div[@class='dropdown']//a[@class='dropdown-toggle']")
    private WebElement sortBy;

    @FindBy(xpath = "//a[contains(text(),'Price: Low to High')]")
    private WebElement price;

    @FindBy(xpath = "//div[@id='heading0']//i[@class='material-icons'][contains(text(),'keyboard_arrow_down')]")
    private WebElement manufacturer;

    @FindBy(xpath = "//div[@id='collapse0']//div[4]//label[1]//span[1]//span[1]")
    private WebElement selectManufacturer;

    @FindBy(xpath = "//div[@id='heading1']//i[@class='material-icons'][contains(text(),'keyboard_arrow_down')]")
    private WebElement heatRange;

    @FindBy(xpath = "//div[@id='collapse1']//div[2]//label[1]//span[1]//span[1]")
    private WebElement selectHeatRange;

    @FindBy(xpath = "//div[@class='js-image image card-image']")
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

    public void setSortBy() throws InterruptedException
    {
        sortBy.click();
        Thread.sleep(500);
    }

    public void setPrice()
    {
        price.click();
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
        //addToCart.click();
    }

    public ShippingPage verifyToShowHotSauses()
    {
        viewInCart.click();
        return new ShippingPage(driver);
    }
}
