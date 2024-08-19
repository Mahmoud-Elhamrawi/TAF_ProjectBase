package Pages;

import Utility.DataUtility;
import Utility.FunctionsUtilities;
import Utility.LogUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.time.Duration;

public class P02_loginOrRegiterPage {
    public WebDriver driver;

    public P02_loginOrRegiterPage(WebDriver driver) {

        this.driver = driver;
    }


    private final By nameInp = By.xpath("//input[@data-qa=\"signup-name\"]");
    private final By emailInp = By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By registerBtn = By.xpath("//button[@data-qa=\"signup-button\"]");

    private final By newUserSignUpEle = By.xpath("//h2[.='New User Signup!']");

    //Verify 'New User Signup!' is visible
    public boolean assertOnSignupVisible()
    {
        new WebDriverWait(driver , Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(newUserSignUpEle));
        LogUtility.info(driver.findElement(newUserSignUpEle).getText());
        return driver.findElement(newUserSignUpEle).isDisplayed();
    }

    public P03_RegisterPage navigateToRegisterPage(String name , String email)  {
        FunctionsUtilities.enterText(driver,nameInp, name);
        FunctionsUtilities.enterText(driver,emailInp,email);
        FunctionsUtilities.clickOnEle(driver,registerBtn);
        return  new P03_RegisterPage(driver);
    }



}
