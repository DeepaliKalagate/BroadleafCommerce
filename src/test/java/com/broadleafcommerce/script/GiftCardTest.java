package com.broadleafcommerce.script;

import com.broadleafcommerce.base.BaseClass;
import com.broadleafcommerce.model.GiftCardPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GiftCardTest extends BaseClass
{
    public GiftCardPage giftCardPage;
    @BeforeMethod
    public void setUp()
    {
        initiation();
        giftCardPage = new GiftCardPage(driver);
    }

    @Test
    public void giftCardTest() throws InterruptedException
    {
        GiftCardPage giftCard=new GiftCardPage(driver);
        giftCard.setGiftCard();
    }
}
