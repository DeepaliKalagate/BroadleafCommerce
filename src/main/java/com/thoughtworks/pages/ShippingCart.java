package com.thoughtworks.pages;
import com.thoughtworks.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ShippingCart
{
    WebDriver driver;
    BaseTest baseTest;

    public ShippingCart(WebDriver driver)
    {
        this.driver = driver;
        baseTest = new BaseTest();
        PageFactory.initElements(driver, this);
    }

    public String verifyItemIsPresentOrNot()
    {
        String element=driver.findElement(By.xpath("//div[@class='col-sm-10']//button[@class='btn']")).getText();
        return element;
    }

    public List<String> getProductsAddedInCart()
    {
        List<String> addedProduct=new ArrayList<>();
        driver.findElements(By.xpath("//div[@class='col-sm-7']")).forEach(webElement1 -> {addedProduct.add(webElement1.getText());});
        return addedProduct;
    }
}
