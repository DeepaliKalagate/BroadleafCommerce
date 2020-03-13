package com.broadleafcommerce.pages;


import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase
{
    @FindBy(className = "material-icons")
    private WebElement userNameLable;

    @FindBy(xpath = "//div[@id='left-nav']//span[contains(text(),'Hot Sauces')]")
    private WebElement hotSauses;

    @FindBy(xpath="//div[@id='left-nav']//span[contains(text(),'Merchandise')]")
    private WebElement clickOnMerchandise;

    @FindBy(xpath = "//div[@id='left-nav']//span[contains(text(),'Clearance')]")
    private WebElement clickOnClearance;

    @FindBy(xpath = "//div[@id='left-nav']//span[contains(text(),'Gift Cards')]")
    private WebElement clickOnGiftCard;

    //Initializing the Page Objects
    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }

    public boolean verifyUserName()
    {
        return userNameLable.isDisplayed();
    }

    public HotSaucePage clickOnHotsauce()
    {
        hotSauses.click();
        return new HotSaucePage();
    }

    public MerchandisePage clickOnMerchandise()
    {
        clickOnMerchandise.click();
        return new MerchandisePage();
    }

    public ClearancePage clickOnClearance()
    {
        clickOnClearance.click();
        return new ClearancePage();
    }

    public GiftCardPage clickOnGiftCard()
    {
        clickOnGiftCard.click();
        return new GiftCardPage();
    }
}
