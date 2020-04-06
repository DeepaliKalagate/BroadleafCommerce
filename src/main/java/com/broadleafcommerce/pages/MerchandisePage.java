package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MerchandisePage extends TestBase
{
    @FindBy(className = "section-title")
    private WebElement marchandisePageText;

    @FindBy(xpath = "//div[@class='dropdown']//a[@class='dropdown-toggle']")
    private WebElement sortBy;

    @FindBy(xpath = "//a[contains(text(),'Price: Low to High')]")
    private WebElement price;

    @FindBy(xpath = "//div[@id='heading0']//i[@class='material-icons'][contains(text(),'keyboard_arrow_down')]")
    private WebElement filter;

    @FindBy(xpath = "//div[@class='panel panel-default filter-panel js-filter-panel']//div[3]//label[1]//span[1]//span[1]")
    private WebElement silver;

    @FindBy(xpath = "//div[@id='heading1']//i[@class='material-icons'][contains(text(),'keyboard_arrow_down')]")
    private WebElement sortByPrice;

    @FindBy(xpath = "price-range%5B10.00000%3A15.00000%5D")
    private WebElement silverPrice;

    @FindBy(xpath = "//div[@class='js-image image card-image']")
    private WebElement shirtImage;

    @FindBy(xpath = "//div[@class='color-inner Silver']")
    private WebElement selectSilver;

    @FindBy(xpath = "//select[@class='selectpicker mobile-device']")
    private WebElement shirtSize;

    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-primary goto-full-cart']")
    private WebElement viewInCart;

    public MerchandisePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public boolean verifyMarchandisePageText()
    {
        return marchandisePageText.isDisplayed();
    }

    public void setSortBy() throws InterruptedException
    {
        sortBy.click();
        Thread.sleep(500);
    }

    public void setPrice()
    {
        price.click();
    }
    public void setFilter()
    {
        filter.click();
    }
    public void setSilver()
    {
        silver.click();
    }
    public void setShirtImage()
    {
        shirtImage.click();
    }
    public void setSelectSilver()
    {
        selectSilver.click();
    }
    public void setShirtSize(String size)
    {
        shirtSize.sendKeys(size);
    }
    public void setAddToCart()
    {
        addToCart.click();
    }
    public ShippingPage verifyMerchandisePage()
    {
        viewInCart.click();
        return new ShippingPage(driver);
    }
}
