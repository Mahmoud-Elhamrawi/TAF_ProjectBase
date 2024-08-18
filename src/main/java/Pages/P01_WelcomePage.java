package Pages;

import Utility.FunctionsUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P01_WelcomePage {


   public  WebDriver driver ;
    public P01_WelcomePage(WebDriver driver)
    {
        this.driver =driver;
    }

    private final By registerLink = By.xpath("//li/a[@href=\"/login\"]") ;

    private final By assertOnLoggingEle =By.xpath("//ul[contains(@class ,'navbar-nav')]//li[10]");



    public P02_loginOrRegiterPage goToLoginOrRegisterPage()
    {
        FunctionsUtilities.clickOnEle(driver , registerLink);
        return new P02_loginOrRegiterPage(driver);
    }

   //Verify that home page is visible successfully
    public boolean assertOnUrlHomePage(String expectHomePage)
    {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(expectHomePage));
    }


    public boolean assertOnLoggingLink()
    {
        new WebDriverWait(driver , Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(assertOnLoggingEle));
        return driver.findElement(assertOnLoggingEle).isDisplayed();
    }
}
