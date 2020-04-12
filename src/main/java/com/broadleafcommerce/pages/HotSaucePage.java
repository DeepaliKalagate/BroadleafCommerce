package com.broadleafcommerce.pages;
import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotSaucePage extends TestBase
{
    WebDriverWait wait=new WebDriverWait(driver,10);

    @FindBy(className = "section-title")
    private WebElement hotsauceLable;

    @FindBy(xpath = "//div[@class='dropdown']//a[@class='dropdown-toggle']")
    private WebElement sortBy;

    @FindBy(xpath = "//a[contains(text(),'Price: Low to High')]")
    private WebElement sortByPrice;

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
        PageFactory.initElements(driver,this);
    }

    public boolean verifyHotSaucePageLable()
    {
        return hotsauceLable.isDisplayed();
    }

    public void setSortBy() throws InterruptedException
    {
        sortBy.click();
        wait.until(ExpectedConditions.visibilityOf(sortByPrice));
        sortByPrice.click();
    }

    public void setManufacturer()
    {
        manufacturer.click();
        wait.until(ExpectedConditions.visibilityOf(selectManufacturer));
        selectManufacturer.click();
    }

    public void setSelectPrice()
    {
        selectPrice.click();
        wait.until(ExpectedConditions.visibilityOf(getSelectPrice));
        getSelectPrice.click();
    }

    public void setViewHotSuace()
    {
        viewHotSuace.click();
    }

    public ShippingPage verifyToShowHotSauses()
    {
        addToCart.click();
        wait.until(ExpectedConditions.visibilityOf(viewInCart));
        viewInCart.click();
        return new ShippingPage(driver);
    }
}
