package com.thoughtworks.script;
import com.thoughtworks.base.Listener;
import com.thoughtworks.base.TestBase;
import com.thoughtworks.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.List;

@Listeners(Listener.class)
public class ShippingPageTest extends TestBase
{
    @Test()
    public void verifyShippingPageTest()
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login(property.getProperty("email"),property.getProperty("password"));
        Assert.assertEquals(driver.findElement(By.className("material-icons")).isDisplayed(),true,"Verify Login is Successful");
        HotSaucePage hotSaucePage=new HotSaucePage(driver);
        ShippingPage shippingPage=new ShippingPage(driver);
        hotSaucePage.selectProductImage();
        ShippingCart shippingCart=new ShippingCart(driver);
        String element=shippingCart.verifyItemIsPresentOrNot();
        if(element.equals("OUT OF STOCK"))
        {
            driver.navigate().back();
        }
        else
        {
            hotSaucePage.productAddToCart();
            List<String> addedProducts = shippingCart.getProductsAddedInCart();
            System.out.println("Product Name : "+addedProducts);
            Assert.assertTrue(addedProducts.contains("GREEN GHOST"),"Product name is incorrect");
            HomePage homePage=new HomePage(driver);
            shippingPage.VerifyShippingPage(property.getProperty("fullName"),
                    property.getProperty("address1"),property.getProperty("address2"),
                    property.getProperty("city"),property.getProperty("state"),
                    property.getProperty("postal"),property.getProperty("mobileno"));
            Assert.assertTrue(homePage.verifyUserName());
        }
    }
}
