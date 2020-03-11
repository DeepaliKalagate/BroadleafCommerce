package com.broadleafcommerce.script;
import com.broadleafcommerce.base.BaseClass;
import com.broadleafcommerce.model.LoginPage;
import com.broadleafcommerce.model.RegisterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class RegisterTest extends BaseClass
{
    public RegisterPage registerPage;
    @BeforeMethod
    public void setUp()
    {
        initiation();
        registerPage = new RegisterPage(driver);
    }
    @Test
    public void givenURL_WhenValid_ThenShouldLaunchSuccessfully() throws InterruptedException
    {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.setLogin();
        Thread.sleep(1000);
        registerPage.setEmail("dipalikalagate1991@gmail.com");
        Thread.sleep(500);
        registerPage.setFirstName("Deepali");
        Thread.sleep(500);
        registerPage.setLastName("Patil");
        Thread.sleep(500);
        registerPage.setPassword("Mysweetfamily@333");
        Thread.sleep(500);
        registerPage.setConfirmPassword("Mysweetfamily@333");
        Thread.sleep(500);
        registerPage.setClickRegister();
    }
}
