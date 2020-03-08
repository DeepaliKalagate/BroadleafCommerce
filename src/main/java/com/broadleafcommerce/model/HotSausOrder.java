package com.broadleafcommerce.model;

import com.broadleafcommerce.base.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotSausOrder extends Browser
{
    @FindBy(xpath = "//div[@id='left-nav']//span[contains(text(),'Hot Sauces')]")
    private WebElement hotSauses;

    @FindBy(xpath = "//body[@class='locale-en_US index-page']/div[@class='main']/div[@class='container']/div[@id='category']/div[@id='category-search-content']/div[@id='right_column']/div[@id='products']/div[1]/div[1]/div[1]/button[1]")
    private WebElement getHotSauses;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm btn-detailsview']")
    private WebElement viewDetails;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement addToCart;

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
        getHotSauses.click();
    }

    public void setViewDetails()
    {
        viewDetails.click();
    }

    public void setAddToCart()
    {
        addToCart.click();
    }
}
