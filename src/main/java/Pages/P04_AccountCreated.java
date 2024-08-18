package Pages;

import Utility.FunctionsUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P04_AccountCreated {
    public WebDriver driver ;
    public P04_AccountCreated(WebDriver driver) {
        this.driver = driver ;

    }
////ul[contains(@class ,'navbar-nav')]//li[10]

    private final By assertOnAccountCreatedEle = By.xpath("//b[.=\"Account Created!\"]");
    private final By continueBtn = By.xpath("//a[.='Continue']");


    public boolean assertOnAccountCreated(String text)
    {
        new WebDriverWait(driver , Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(assertOnAccountCreatedEle));
        return driver.findElement(assertOnAccountCreatedEle).getText().contains(text);
    }

    public P01_WelcomePage continueRegister()
    {
        FunctionsUtilities.clickOnEle(driver,continueBtn);
        return new  P01_WelcomePage(driver);
    }




}
