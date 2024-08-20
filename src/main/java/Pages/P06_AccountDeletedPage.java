package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P06_AccountDeletedPage {
 public WebDriver driver ;

    public P06_AccountDeletedPage(WebDriver driver) {

        this.driver = driver ;
    }
    private final By deleteEle = By.cssSelector("h2[data-qa=\"account-deleted\"]>b");

    public boolean assertOnDeleteTextVisiable()
    {
        new WebDriverWait(driver , Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(deleteEle)) ;
        return driver.findElement(deleteEle).isDisplayed();
    }
}
