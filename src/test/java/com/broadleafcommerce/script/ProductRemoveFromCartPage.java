package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductRemoveFromCartPage extends TestBase
{


    @FindBy(xpath = "//a[@class='btn btn-simple btn-bordered btn-xs remove-from-cart-action js-removeFromCart']")
    private WebElement removeitem;

    public ProductRemoveFromCartPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
}
