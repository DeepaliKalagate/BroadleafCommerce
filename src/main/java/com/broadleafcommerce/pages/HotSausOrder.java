package com.broadleafcommerce.pages;


import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotSausOrder extends TestBase
{
    @FindBy(xpath = "//div[@id='left-nav']//span[contains(text(),'Hot Sauces')]")
    private WebElement hotSauses;

    @FindBy(xpath = "//body[@class='locale-en_US index-page']/div[@class='main']/div[@class='container']/div[@id='category']/div[@id='category-search-content']/div[@id='right_column']/div[@id='products']/div[1]/div[1]/a[1]/div[1]")
    private WebElement viewHotSuace;

    @FindBy(xpath = "//button[@class='btn btn-primary js-addToCart']")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement viewInCart;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement clickToContinue;

    public HotSausOrder(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setHotSauses()
    {
        hotSauses.click();
    }

    public void setGetHotSauses()
    {
        viewHotSuace.click();
    }

    public void setAddToCart()
    {
        addToCart.click();
    }

    public void setViewInCart()
    {
        viewInCart.click();
    }

    public void setClickToContinue()
    {
        clickToContinue.click();
    }
}
