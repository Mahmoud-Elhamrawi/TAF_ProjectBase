package Pages;

import Utility.FunctionsUtilities;
import Utility.LogUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P02_loginOrRegiterPage {
    public WebDriver driver;

    public P02_loginOrRegiterPage(WebDriver driver) {

        this.driver = driver;
    }


    private final By nameRegisterInp = By.xpath("//input[@data-qa=\"signup-name\"]");
    private final By emailRegisterInp = By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By registerBtn = By.xpath("//button[@data-qa=\"signup-button\"]");

    private final By emailLoginInp = By.cssSelector("input[data-qa=\"login-email\"]");
    private final By passwordLoginInp = By.cssSelector("input[data-qa=\"login-password\"]");
    private final By loginBtn = By.cssSelector("button[data-qa=\"login-button\"]");


    private final By newUserSignUpEle = By.xpath("//h2[.='New User Signup!']");
    private final By loginToAccountEle = By.cssSelector("div[class=\"login-form\"] h2");

    //Verify 'New User Signup!' is visible
    public boolean assertOnSignupVisible()
    {
        new WebDriverWait(driver , Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(newUserSignUpEle));
        LogUtility.info(driver.findElement(newUserSignUpEle).getText());
        return driver.findElement(newUserSignUpEle).isDisplayed();
    }

    public P03_RegisterPage navigateToRegisterPage(String name , String email)  {
        FunctionsUtilities.enterText(driver, nameRegisterInp, name);
        FunctionsUtilities.enterText(driver, emailRegisterInp,email);
        FunctionsUtilities.clickOnEle(driver,registerBtn);
        return  new P03_RegisterPage(driver);
    }

    //Verify 'Login to your account' is visible
    public boolean assertOnLoginToAccount()
    {
        new WebDriverWait(driver , Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(loginToAccountEle));
        LogUtility.info(driver.findElement(loginToAccountEle).getText());
        return driver.findElement(loginToAccountEle).isDisplayed();
    }
    public P04_AccountCreated validLoginSteps(String email , String password)
    {
        FunctionsUtilities.enterText(driver ,emailLoginInp ,email);
        FunctionsUtilities.enterText(driver ,passwordLoginInp , password);
        FunctionsUtilities.clickOnEle(driver ,loginBtn);
        return new P04_AccountCreated(driver) ;

    }



}
