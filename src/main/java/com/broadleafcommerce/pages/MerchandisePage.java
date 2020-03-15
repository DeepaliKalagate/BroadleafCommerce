package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MerchandisePage extends TestBase
{
    @FindBy(className = "section-title")
    private WebElement marchandisePageText;

    @FindBy(xpath = "//img[@class='brand-logo']")
    private WebElement marchandisePageLogo;

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

    public MerchandisePage()
    {
        PageFactory.initElements(driver,this);
    }

    public String verifyMerchandisePageTitle()
    {
        return driver.getTitle();
    }

    public boolean verifyMarchandisePageLogo()
    {
        return marchandisePageLogo.isDisplayed();
    }

    public boolean verifyMarchandisePageText()
    {
        return marchandisePageText.isDisplayed();
    }

    public ShippingPage setMerchandisePageFields(String size) throws InterruptedException
    {
        sortBy.click();
        Thread.sleep(1000);
        price.click();
        Thread.sleep(1000);
        filter.click();
        Thread.sleep(1000);
        silver.click();
        Thread.sleep(1000);
        sortByPrice.click();
        Thread.sleep(1000);
        silverPrice.click();
        Thread.sleep(2000);
        shirtImage.click();
        Thread.sleep(1000);
        selectSilver.click();
        Thread.sleep(1000);
        shirtSize.sendKeys(size);
        Thread.sleep(1000);
        addToCart.click();
        Thread.sleep(1000);
        viewInCart.click();
        return new ShippingPage();
    }
}
