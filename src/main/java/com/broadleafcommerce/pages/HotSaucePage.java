package com.broadleafcommerce.pages;


import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotSaucePage extends TestBase
{
    @FindBy(className = "section-title")
    private WebElement hotsauceLable;

    @FindBy(xpath = "//body[@class='locale-en_US index-page']/div[@class='main']/div[@class='container']/div[@id='category']/div[@id='category-search-content']/div[@id='right_column']/div[@id='products']/div[1]/div[1]/a[1]/div[1]")
    private WebElement viewHotSuace;

    public HotSaucePage()
    {
        PageFactory.initElements(driver,this);
    }

    public boolean verifyHotSaucePageLable()
    {
        return hotsauceLable.isDisplayed();
    }

    public String verifyHotSaucePageTitle()
    {
        return driver.getTitle();
    }

    public void setGetHotSauses()
    {
        viewHotSuace.click();
    }


}
