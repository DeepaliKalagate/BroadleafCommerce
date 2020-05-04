package com.thoughtworks.pages;
import com.thoughtworks.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GiftCardPage
{
    private WebDriver driver;
    BaseTest baseTest;
    WebDriverWait wait=new WebDriverWait(driver,10);

    @FindBy(xpath = "//div[@data-id='-15000']")
    private WebElement selectGiftCard;

    @FindBy(xpath = "//textarea[@name='itemAttributes[null]']")
    private WebElement personalMessage;

    @FindBy(xpath = "//div//div//div//div//div//div//div//div[3]//input[1]")
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

    @FindBy(xpath = "//li[@class='dropdown js-miniCart open']//a[@class='btn btn-primary goto-full-cart'][contains(text(),'View Your Cart')]")
    private WebElement viewInCart;

    public GiftCardPage(WebDriver driver)
    {
        this.driver = driver;
        baseTest = new BaseTest();
        PageFactory.initElements(driver, this);
    }

    public void setSelectGiftCard()
    {
        selectGiftCard.click();
    }

    public void setPersonalMessage(String message)
    {
        personalMessage.sendKeys(message);
    }

    public void setSender(String senderName)
    {
        sender.sendKeys(senderName);
    }

    public void setEmail(String recipientEmail)
    {
        email.sendKeys(recipientEmail);
    }

    public void setName(String recipientName)
    {
        name.sendKeys(recipientName);
    }

    public void setSelectColor()
    {
        selectColor.click();
    }

    public void setClickAddToCart()
    {
        clickAddToCart.click();
        wait.until(ExpectedConditions.visibilityOf(clickOnCart));
    }

    public void setClickOnCart()
    {
        clickOnCart.click();
    }

    public ShippingPage setGiftCard()
    {
        viewInCart.click();
        return new ShippingPage(driver);
    }
}
