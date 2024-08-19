package Pages;

import Utility.FunctionsUtilities;
import Utility.LogUtility;
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
    private final By assertOnDeleteEle =By.xpath("//ul[contains(@class ,'navbar-nav')]//li[5]");



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
        LogUtility.info(driver.findElement(assertOnLoggingEle).getText());
        return driver.findElement(assertOnLoggingEle).isDisplayed();
    }

    public boolean assertOnDeleteLink()
    {
        new WebDriverWait(driver , Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(assertOnDeleteEle));
        LogUtility.info(driver.findElement(assertOnDeleteEle).getText());
        return driver.findElement(assertOnDeleteEle).isDisplayed();
    }
}
