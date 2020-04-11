package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClearancePage extends TestBase
{
    WebDriverWait wait=new WebDriverWait(driver,5);

    @FindBy(className = "section-title")
    private WebElement clearancePageText;

    @FindBy(xpath = "//input[@placeholder='search']")
    private WebElement searchSauce;

    @FindBy(xpath = "//strong[contains(text(),'blazin')]")
    private WebElement viewHotSuace;

    @FindBy(xpath = "//div[@class='col-md-4']//div[@data-id='8']")
    private WebElement clearanceItem;

    @FindBy(xpath = "//button[@class='btn btn-primary js-addToCart']")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement viewInCart;

    public ClearancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyClearancePageText() {
        return clearancePageText.isDisplayed();
    }

   public void setSearchSauce(String serachItem)
   {
       searchSauce.sendKeys(serachItem);
       wait.until(ExpectedConditions.visibilityOf(viewHotSuace));
   }

   public void setViewHotSuace()
   {
       viewHotSuace.click();
   }

    public void setClearanceItem()
    {
        clearanceItem.click();
    }

    public void setAddToCart()
    {
       addToCart.click();
    }

    public ShippingPage verifyClearancePage()
    {
        viewInCart.click();
        return new ShippingPage(driver);
    }
}