package com.broadleafcommerce.pages;


import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MerchandisePage extends TestBase
{
    @FindBy(xpath = "//div[@id='left-nav']//span[contains(text(),'Merchandise')]")
    private WebElement merchandise;

    @FindBy(xpath = "//div[@id='left-nav']//ul[@class='nav navbar-nav main-menu']//li[@class='dropdown']//ul[@class='dropdown-menu dropdown-with-icons']//li//a[contains(text(),'Womens')]")
    private WebElement women;

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

    @FindBy(xpath = "")
    private WebElement viewInCart;

    @FindBy(xpath = "")
    private WebElement checkout;

    public MerchandisePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setMerchandise()
    {
        merchandise.click();
    }

    public void setWomen()
    {
        women.click();
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

    public void setSortByPrice()
    {
        sortByPrice.click();
    }

    public void setSilverPrice()
    {
        silverPrice.click();
    }

    public void setShirtImage()
    {
        shirtImage.click();
    }

    public void setSelectSilver(String size)
    {
        shirtSize.sendKeys(size);
    }

    public void setAddToCart()
    {
        addToCart.click();
    }

}
