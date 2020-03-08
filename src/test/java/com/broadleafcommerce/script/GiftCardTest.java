package com.broadleafcommerce.script;

import com.broadleafcommerce.base.Browser;
import com.broadleafcommerce.model.GiftCard;
import com.broadleafcommerce.model.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.broadleafcommerce.base.CustomListener.class)
public class GiftCardTest extends Browser
{
    @Test
    public void giftCardTest() throws InterruptedException
    {
        LoginPage loginPage=new LoginPage(driver);
        Thread.sleep(1000);
        loginPage.setClickLogin();
        loginPage.setEmail("dipakalagate1991@gmail.com");
        loginPage.setPassword("Mysweetfamily@333");
        loginPage.setLogin();
        GiftCard giftCard=new GiftCard(driver);
        giftCard.setGiftCard();
    }
}
