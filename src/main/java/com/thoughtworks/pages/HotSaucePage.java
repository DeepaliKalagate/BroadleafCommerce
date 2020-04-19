package com.thoughtworks.pages;
import com.thoughtworks.helper.DropdownHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotSaucePage extends BasePage
{
    @FindBy(xpath = "//div[@class='dropdown']//a[@class='dropdown-toggle']")
    private WebElement sortBy;

    @FindBy(xpath = "//a[contains(text(),'Price: Low to High')]")
    private WebElement selectPriceLowToHigh;

    @FindBy(xpath = "//h4[@class='panel-title'][contains(text(),'Manufacturer')]")
    private WebElement manufacturer;

    @FindBy(xpath = "//div[@id='collapse0']//div[4]//label[1]//span[1]//span[1]")
    private WebElement selectManufacturer;

    @FindBy(xpath = "//h4[contains(text(),'Price')]")
    private WebElement selectPrice;

    @FindBy(xpath = "//div[@id='collapse2']//div[2]//label[1]//span[@class='checkbox-material']//span[1]")
    private WebElement getSelectPrice;

    @FindBy(xpath = "//div[@class='js-image image card-image']")
    private WebElement viewHotSuace;

    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement viewInCart;

    public HotSaucePage(WebDriver driver)
    {
        super(driver);
    }

    public void selectSortBy()
    {
        sortBy.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(selectPriceLowToHigh));
        selectPriceLowToHigh.click();
    }

    public void selectFilterBy()
    {
        manufacturer.click();
        wait.until(ExpectedConditions.visibilityOf(selectManufacturer));
        selectManufacturer.click();
        wait.until(ExpectedConditions.visibilityOf(selectPrice));
        selectPrice.click();
        wait.until(ExpectedConditions.visibilityOf(getSelectPrice));
        getSelectPrice.click();
    }

    public void selectProductImage()
    {
        viewHotSuace.click();
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
