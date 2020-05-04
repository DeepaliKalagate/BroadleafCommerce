package com.thoughtworks.pages;
import com.thoughtworks.base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListingPage
{
    WebDriver driver;
    BaseTest baseTest;
    WebDriverWait wait=new WebDriverWait(driver,10);

    @FindBy(xpath = "//div[@class='dropdown']//a[@class='dropdown-toggle']")
    private WebElement sortBy;

    @FindBy(xpath = "//a[contains(text(),'Price: Low to High')]")
    private WebElement selectPriceLowToHigh;

    public ProductListingPage(WebDriver driver)
    {
        this.driver = driver;
        baseTest = new BaseTest();
        PageFactory.initElements(driver, this);
    }

    public void selectSortBy()
    {
        sortBy.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(selectPriceLowToHigh));
        selectPriceLowToHigh.click();
    }
}
