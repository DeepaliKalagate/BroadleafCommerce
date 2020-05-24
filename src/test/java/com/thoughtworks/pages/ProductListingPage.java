package com.thoughtworks.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListingPage
{
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"sort\"]/div/a/span/span")
    private WebElement sortBy;

    @FindBy(xpath = "//a[contains(text(),'Price: Low to High')]")
    private WebElement selectPriceLowToHigh;

    public ProductListingPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver,10);
    }

    public void selectSortBy() throws InterruptedException
    {
        sortBy.click();
        wait.until(ExpectedConditions.visibilityOf(selectPriceLowToHigh));
        selectPriceLowToHigh.click();
    }
}
