package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCardPage extends TestBase
{
    @FindBy(xpath = "//h2[@class='section-title']")
    private WebElement giftCardPageText;

    @FindBy(xpath = "//body[@class='locale-en_US index-page']/div[@class='main']/div[@class='container']/div[@id='category']/div[@id='category-search-content']/div[@id='right_column']/div[@id='products']/div[1]/div[1]/a[1]/div[1]")
    private WebElement selectGiftCard;

    @FindBy(xpath = "//textarea[@name='itemAttributes[null]']")
    private WebElement personalMessage;

    @FindBy(css = "body.locale-en_US.index-page:nth-child(2) div.main:nth-child(7) div.container div.product-page:nth-child(1) div.main-product.js-productContainer.card-product.row div.col-sm-5 div.js-productOptions:nth-child(4) div.js-productOptionGroup.product-options:nth-child(3) div.form-group.label-floating.is-empty > input.form-control")
    private WebElement sender;

    @FindBy(xpath = "//div//div//div//div//div//div//div[4]//input[1]")
    private WebElement email;

    @FindBy(xpath = "//div[5]//div[1]//input[1]")
    private WebElement name;

    @FindBy(xpath = "//div[@class='color-inner Blue']")
    private WebElement selectColor;

    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement clickAddToCart;

    @FindBy(xpath = "//li[@class='dropdown js-miniCart open']//i[@class='material-icons'][contains(text(),'shopping_cart')]")
    private WebElement clickOnCart;

    @FindBy(className = "//a[@class='btn btn-primary goto-full-cart']")
    //@FindBy(xpath="//li[@class='dropdown js-miniCart open']//a[@class='btn btn-primary goto-full-cart'][contains(text(),'View Your Cart')]")
    private WebElement viewInCart;

    public GiftCardPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public ShippingPage setGiftCard(String message,String senderName,String recipientEmail,String recipientName) throws InterruptedException
    {
        selectGiftCard.click();
        Thread.sleep(1000);
        personalMessage.sendKeys(message);
        Thread.sleep(1000);
        sender.sendKeys(senderName);
        Thread.sleep(1000);
        email.sendKeys(recipientEmail);
        Thread.sleep(1000);
        name.sendKeys(recipientName);
        Thread.sleep(1000);
        selectColor.click();
        Thread.sleep(1000);
        clickAddToCart.click();
        Thread.sleep(2000);
        clickOnCart.click();
        Thread.sleep(1000);
        viewInCart.click();
        Thread.sleep(1000);
        return new ShippingPage(driver);
    }
}
