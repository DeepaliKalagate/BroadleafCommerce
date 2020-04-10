package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductRemoveFromCartPage extends TestBase
{
    @FindBy(xpath = "//div[@class='col-md-4']//div[@data-id='8']")
    private WebElement selectItem;

    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement viewInCart;

    @FindBy(xpath = "//a[@class='btn btn-simple btn-bordered btn-xs remove-from-cart-action js-removeFromCart'][contains(text(),'Remove')]")
    private WebElement removeitem;

    public ProductRemoveFromCartPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setSelectItem()
    {
        selectItem.click();
    }

    public void setAddToCart()
    {
        addToCart.click();
    }

    public void setViewInCart()
    {
        viewInCart.click();
    }

    public void setRemoveitem()
    {
        removeitem.click();
    }
}
