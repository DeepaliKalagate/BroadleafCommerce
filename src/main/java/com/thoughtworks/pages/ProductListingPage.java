package com.thoughtworks.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductListingPage extends BasePage
{
    @FindBy(xpath = "//div[@class='dropdown']//a[@class='dropdown-toggle']")
    private WebElement sortBy;

    @FindBy(xpath = "//a[contains(text(),'Price: Low to High')]")
    private WebElement selectPriceLowToHigh;

    public ProductListingPage(WebDriver driver)
    {
        super(driver);
    }

    public void selectSortBy()
    {
        sortBy.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(selectPriceLowToHigh));
        selectPriceLowToHigh.click();
    }
}
