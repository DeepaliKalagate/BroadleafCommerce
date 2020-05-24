package com.thoughtworks.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotSaucePage
{
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h4[@class='panel-title'][contains(text(),'Manufacturer')]")
    private WebElement manufacturer;

    @FindBy(xpath = "//div[@id='collapse0']//div[2]//label[1]//span[1]//span[1]")
    private WebElement selectManufacturer;

    @FindBy(xpath = "//h4[contains(text(),'Price')]")
    private WebElement selectPrice;

    @FindBy(xpath = "//div[@id='collapse2']//div[2]//label[1]//span[@class='checkbox-material']//span[1]")
    private WebElement getSelectPrice;

    @FindBy(xpath = "//*[@id=\"products\"]/div[2]/div")
    private WebElement viewHotSauce;

    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement viewInCart;

    public HotSaucePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver,10);
    }

    public void selectFilterBy() throws InterruptedException
    {
        selectPrice.click();
        wait.until(ExpectedConditions.visibilityOf(getSelectPrice));
        getSelectPrice.click();
        wait.until(ExpectedConditions.visibilityOf(manufacturer));
        manufacturer.click();
        selectManufacturer.click();
    }

    public void selectProductImage() throws InterruptedException
    {
        Thread.sleep(300);
        viewHotSauce.click();
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
