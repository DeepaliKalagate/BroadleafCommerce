package com.thoughtworks.pages;
import com.thoughtworks.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductRemoveFromCartPage
{
    private WebDriver driver;
    BaseTest baseTest;
    WebDriverWait wait=new WebDriverWait(driver,10);

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
    private WebElement btnLogout;

    public ProductRemoveFromCartPage(WebDriver driver)
    {
        this.driver = driver;
        baseTest = new BaseTest();
        PageFactory.initElements(driver, this);
    }

    public void selectProduct()
    {
        selectItem.click();
    }

    public void productAddToCart()
    {
        if(addToCart.isDisplayed())
        {
            addToCart.click();
            wait.until(ExpectedConditions.visibilityOf(viewInCart));
            viewInCart.click();
        }
        else
        {
            viewInCart.click();
        }
    }

    public void removeProdutsFromCart()
    {
        removeitem.click();
        wait.until(ExpectedConditions.visibilityOf(clickOnUserName));
    }

    public void clickOnDropdown()
    {
        clickOnUserName.click();
        wait.until(ExpectedConditions.visibilityOf(btnLogout));
    }

    public void clickOnLogout()
    {
        btnLogout.click();
    }
}
