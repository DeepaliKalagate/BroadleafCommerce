package com.broadleafcommerce.script;
import com.broadleafcommerce.base.Browser;
import com.broadleafcommerce.base.CustomListener;
import com.broadleafcommerce.model.RegisterPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.broadleafcommerce.base.CustomListener.class)
public class RegisterTest extends Browser
{
    @Test
    public void givenURL_WhenValid_ThenShouldLaunchSuccessfully() throws InterruptedException
    {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.setLogin();
        Thread.sleep(1000);
        registerPage.setEmail("dipakalagate1991@gmail.com");
        registerPage.setFirstName("Deepali");
        registerPage.setLastName("Patil");
        registerPage.setPassword("Mysweetfamily@333");
        registerPage.setConfirmPassword("Mysweetfamily@333");
        registerPage.setClickRegister();
    }
}
