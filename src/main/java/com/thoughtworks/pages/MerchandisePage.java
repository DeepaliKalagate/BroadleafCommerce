package com.thoughtworks.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class MerchandisePage extends BasePage
{
    @FindBy(xpath = "//h4[contains(text(),'Color')]")
    private WebElement filter;

    @FindBy(xpath = "//div[@id='collapse0']//div[@class='panel-body']//div[1]//label[1]//span[1]//span[1]")
    private WebElement silver;

    @FindBy(xpath = "//h4[contains(text(),'Price')]")
    private WebElement filterByPrice;

    @FindBy(xpath = "//div[@id='collapse1']//div[2]//label[1]//span[1]//span[1]")
    private WebElement selectPrice;

    @FindBy(xpath = "//div[@class='js-image image card-image']")
    private WebElement shirtImage;

    @FindBy(xpath = "//div[@class='color-inner Silver']")
    private WebElement selectSilver;

    @FindBy(xpath = "//select[@class='selectpicker mobile-device']")
    private WebElement shirtSize;

    @FindBy(xpath = "//i[contains(text(),'favorite_border')]")
    private WebElement addToWishlist;

    @FindBy(xpath = "//li[@class='dropdown']//a[1]/i")
    private WebElement clickOnUserName;

    @FindBy(xpath = "//a[contains(text(),'My Profile')]")
    private WebElement clickOnProfile;

    @FindBy(xpath = "//a[contains(text(),'Manage Wishlist')]")
    private WebElement clickOnManageWishlist;

    public MerchandisePage(WebDriver driver)
    {
        super(driver);
    }


    public void selectFilterByColor()
    {
        filter.click();
        silver.click();
    }

    public void selectFilterByPrice()
    {
        filterByPrice.click();
        selectPrice.click();
    }

    public void selectProductImage()
    {
        shirtImage.click();
    }
    public void selectSilverColor()
    {
        selectSilver.click();
    }
    public void selectShirtSize(String size)
    {
        shirtSize.sendKeys(size);
    }

    public void productAddToWishlist()
    {
        addToWishlist.click();
        wait.until(ExpectedConditions.visibilityOf(clickOnUserName));
    }
    public void clickOnDropdown()
    {
        clickOnUserName.click();
        wait.until(ExpectedConditions.visibilityOf(clickOnProfile));
    }
    public void clickOnProfile()
    {
        clickOnProfile.click();
    }
    public void clickOnManageWishlist()
    {
        clickOnManageWishlist.click();
    }
}
