package com.thoughtworks.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotSauce
{
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='col-md-4']//div[@data-id='1']")
    private WebElement viewHotSauce;

    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement viewInCart;

    public HotSauce(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver,10);
    }

    public void viewHotSuaceProduct()
    {
        viewHotSauce.click();
    }

    public HomePage productAddToCart()
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
        return new HomePage(driver);
    }
}
