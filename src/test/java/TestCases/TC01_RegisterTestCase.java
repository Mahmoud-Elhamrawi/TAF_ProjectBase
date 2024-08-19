package TestCases;

import Pages.P01_WelcomePage;
import Pages.P02_loginOrRegiterPage;
import Pages.P03_RegisterPage;
import Pages.P04_AccountCreated;
import Utility.DataUtility;
import Utility.FunctionsUtilities;
import com.github.javafaker.Faker;
import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.IInvokedListenerClass;
import Listeners.ITestListenerClass;



import static DriverFactory.DriverFactory.*;
@Listeners({ITestListenerClass.class, IInvokedListenerClass.class})
public class TC01_RegisterTestCase extends TestBase {


    public String name = DataUtility.readJsonFile("initialRegister", "name") + FunctionsUtilities.createTime();
    public String email = DataUtility.readJsonFile("initialRegister", "email") + FunctionsUtilities.generateRandomNumber(10);

    public String password = DataUtility.readJsonFile("userRegister", "password");
    public String day = DataUtility.readJsonFile("userRegister", "day");
    public String month = DataUtility.readJsonFile("userRegister", "month");
    public String year = DataUtility.readJsonFile("userRegister", "year");
    public String firstName = DataUtility.readJsonFile("userRegister", "firstName");
    public String lastName = DataUtility.readJsonFile("userRegister", "lastName");
    public String address = DataUtility.readJsonFile("userRegister", "address");
    public String country = DataUtility.readJsonFile("userRegister", "country");
    public String state = DataUtility.readJsonFile("userRegister", "state");
    public String city = DataUtility.readJsonFile("userRegister", "city");
    public String zipcode = new Faker().number().digit();
    public String phoneNumber = new Faker().phoneNumber().phoneNumber();


    @Test
    public void validRegisterTC() {
        new P01_WelcomePage(getDriver())
                .goToLoginOrRegisterPage();
 //Verify 'New User Signup!' is visible
        Assert.assertTrue(new P02_loginOrRegiterPage(getDriver()).assertOnSignupVisible());

        new P02_loginOrRegiterPage(getDriver())
                .navigateToRegisterPage(name, email);
 //Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(new P03_RegisterPage(getDriver()).assertOnTitleFillData());

        new P03_RegisterPage(getDriver())
                .fillDataRegistration(password, day, month, year, firstName, lastName, address, country, state, city, zipcode, phoneNumber);
 //Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(new P04_AccountCreated(getDriver()).assertOnAccountCreated());
        new P04_AccountCreated(getDriver()).continueRegister();
  //Verify that 'Logged in as username' is visible
        Assert.assertTrue(new P01_WelcomePage(getDriver()).assertOnLoggingLink());
  //Verify that 'ACCOUNT DELETED!' is visible
        Assert.assertTrue(new P01_WelcomePage(getDriver()).assertOnDeleteLink());
    }


}
