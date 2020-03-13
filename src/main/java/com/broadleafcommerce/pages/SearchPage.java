package com.broadleafcommerce.pages;


import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends TestBase
{
    @FindBy(xpath = "//div[@id='left-nav']//span[contains(text(),'Hot Sauces')]")
    private WebElement hotSauses;

    @FindBy(xpath = "//input[@placeholder='search']")
    private WebElement searchSauce;

  /*  @FindBy(xpath = "//strong[contains(text(),'ghost')]")
    private WebElement sauceName;*/

    @FindBy(xpath = "//ul[@class='js-typeahead--keyword']//a")
    private WebElement viewHotSuace;

    @FindBy(xpath = "//body[@class='locale-en_US index-page']/div[@class='main']/div[@class='container']/div[@id='search']/div[@id='category-search-content']/div[@id='right_column']/div[@id='products']/div[1]/div[1]/a[1]/div[1]")
    private WebElement quickView;

    @FindBy(xpath = "//button[@class='btn btn-primary js-addToCart']")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement viewInCart;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement clickOnContinue;

    public SearchPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void setHotSauses()
    {
        hotSauses.click();
    }

    public void setSearchSauce(String suace1)
    {
        searchSauce.sendKeys(suace1);
    }

    public void setViewHotSuace()
    {
        viewHotSuace.click();
    }

    public void setQuickView()
    {
        quickView.click();
    }

    public void setAddToCart()
    {
        addToCart.click();
    }

    public void setViewInCart()
    {
        viewInCart.click();
    }

    public void setClickOnContinue()
    {
        clickOnContinue.click();
    }
}
