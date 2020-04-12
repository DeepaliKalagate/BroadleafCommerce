package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductRemoveFromCartPage extends TestBase
{
    WebDriverWait wait=new WebDriverWait(driver,5);
    @FindBy(xpath = "//div[@class='col-md-4']//div[@data-id='8']")
    private WebElement selectItem;

    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement viewInCart;

    @FindBy(xpath = "//a[@class='btn btn-simple btn-bordered btn-xs remove-from-cart-action js-removeFromCart'][contains(text(),'Remove')]")
    private WebElement removeitem;

    @FindBy(xpath = "//li[@class='dropdown']//a[1]/i")
    private WebElement clickOnUserName;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement clickOnLogout;

    public ProductRemoveFromCartPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setSelectItem()
    {
        selectItem.click();
    }

    public void setAddToCart()
    {
        addToCart.click();
        wait.until(ExpectedConditions.visibilityOf(viewInCart));
    }

    public void setViewInCart()
    {
        viewInCart.click();
    }

    public void setRemoveitem()
    {
        removeitem.click();
        wait.until(ExpectedConditions.visibilityOf(clickOnUserName));
    }

    public void setClickOnDropdown()
    {
        clickOnUserName.click();
        wait.until(ExpectedConditions.visibilityOf(clickOnLogout));
    }

    public void setClickOnLogout()
    {
        clickOnLogout.click();
    }
}
