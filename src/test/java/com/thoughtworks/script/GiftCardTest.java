package com.thoughtworks.script;
import com.thoughtworks.base.Listener;
import com.thoughtworks.base.TestBase;
import com.thoughtworks.pages.GiftCardPage;
import com.thoughtworks.pages.HomePage;
import com.thoughtworks.pages.LoginPage;
import com.thoughtworks.pages.ShippingCart;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.List;

@Listeners(Listener.class)
public class GiftCardTest extends TestBase
{
    @Test()
    public void selectGiftCardTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(property.getProperty("email"), property.getProperty("password"));
        Assert.assertEquals(driver.findElement(By.className("material-icons")).isDisplayed(), true, "Verify Login is Successful");

        GiftCardPage giftCardPage;
        HomePage homePage = new HomePage(driver);
        giftCardPage = homePage.clickOnGiftCard();
        Assert.assertTrue(driver.getTitle().equals("Gift Cards - Test Site"));

        giftCardPage.setSelectGiftCard();
        giftCardPage.setPersonalMessage(property.getProperty("message"));
        giftCardPage.setSender(property.getProperty("name"));
        giftCardPage.setEmail(property.getProperty("recepeintEmail"));
        giftCardPage.setName(property.getProperty("recepeintName"));
        giftCardPage.setSelectColor();
        ShippingCart shippingCart = new ShippingCart(driver);
        String element = shippingCart.verifyItemIsPresentOrNot();
        if (element.equals("OUT OF STOCK"))
        {
            driver.navigate().back();
        }
        else
        {
            giftCardPage.setClickAddToCart();
            giftCardPage.setGiftCard();
            List<String> addedProducts = shippingCart.getProductsAddedInCart();
            Assert.assertTrue(addedProducts.contains("$5 GIFT CARD"), "Product name is incorrect");
        }
    }
}
