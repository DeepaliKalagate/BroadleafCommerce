package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MerchandiseRemoveFromCartPage extends TestBase
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

    @FindBy(xpath = "//div[@id='collapse1']//div[@class='panel-body']//div[1]//label[1]//span[1]//span[1]")
    private WebElement silverPrice;

    @FindBy(xpath = "//div[@class='js-image image card-image']")
    private WebElement shirtImage;

    @FindBy(xpath = "//div[@class='color-inner Silver']")
    private WebElement selectSilver;

    @FindBy(xpath = "//select[@class='selectpicker mobile-device']")
    private WebElement shirtSize;

    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement addToCart;

    @FindBy(xpath = "//li[@class='dropdown js-miniCart open']//a[@class='btn btn-primary goto-full-cart'][contains(text(),'View Your Cart')]")
    private WebElement viewInCart;

    @FindBy(xpath = "//a[@class='btn btn-simple btn-bordered btn-xs remove-from-cart-action js-removeFromCart']")
    private WebElement removeFromCart;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-lg']")
    private WebElement  clickOnContinueShopping;

    public MerchandiseRemoveFromCartPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public boolean verifyMarchandisePageText()
    {
        return marchandisePageText.isDisplayed();
    }

    public void setSortBy()
    {
        sortBy.click();
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
    public void setSortByPrice() throws InterruptedException
    {
        sortByPrice.click();
        Thread.sleep(500);
    }
    public void setSilverPrice()
    {
        silverPrice.click();
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
    public void setViewInCart()
    {
        viewInCart.click();
    }
    public void setRemoveFromCart()
    {
        removeFromCart.click();
    }

    public HomePage verifyMerchandisePage()
    {
        clickOnContinueShopping.click();
        return new HomePage(driver);
    }
}
