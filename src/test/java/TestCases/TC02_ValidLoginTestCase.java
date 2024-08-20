package TestCases;

import Pages.P01_WelcomePage;
import Pages.P02_loginOrRegiterPage;
import Pages.P05_LoginPage;
import Pages.P06_AccountDeletedPage;
import Utility.DataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.*;

public class TC02_ValidLoginTestCase extends TestBase{


    private final String email = DataUtility.readJsonFile("initialRegister","email") ;
    private final String password = DataUtility.readJsonFile("userRegister","password");
    @Test
    public void validLoginTC()
    {

        new P01_WelcomePage(getDriver()).goToLoginOrRegisterPage();
        //Verify 'Login to your account' is visible
        Assert.assertTrue(new P02_loginOrRegiterPage(getDriver()).assertOnLoginToAccount());
        new P02_loginOrRegiterPage(getDriver()).validLoginSteps(email , password);
       // Verify that 'Logged in as username' is visible
        Assert.assertTrue(new P01_WelcomePage(getDriver()).assertOnLoggingLink());
        new P05_LoginPage(getDriver()).deleteAccount();
        //Verify that 'ACCOUNT DELETED!' is visible
        new P06_AccountDeletedPage(getDriver()).assertOnDeleteTextVisiable();



    }


}
