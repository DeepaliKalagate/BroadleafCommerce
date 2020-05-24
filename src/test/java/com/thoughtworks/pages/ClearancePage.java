package com.thoughtworks.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClearancePage
{
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@placeholder='search']")
    private WebElement searchSauce;

    @FindBy(xpath = "//ul[@class='js-typeahead--keyword']//a")
    private WebElement viewHotSuace;

    @FindBy(xpath = "//div[@class='col-md-4']//div[@data-id='8']")
    private WebElement clearanceItem;

    @FindBy(xpath = "//button[@class='btn btn-primary js-addToCart']")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement viewInCart;

    public ClearancePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver,10);
    }

    public void searchProductByname(String serachItem)
    {
        searchSauce.sendKeys(serachItem);
    }

    public void selectSearchedProduct()
    {
        viewHotSuace.click();
    }

    public void selectProductImage()
    {
        clearanceItem.click();
    }

    public ShippingPage productAddToCart()
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
        return new ShippingPage(driver);
    }
}