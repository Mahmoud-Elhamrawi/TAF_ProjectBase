package Pages;

import Utility.FunctionsUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_LoginPage {
    public WebDriver driver ;
    public P05_LoginPage(WebDriver driver)
    {
        this.driver =driver;
    }


    private final By DeleteEle =By.xpath("//ul[contains(@class ,'navbar-nav')]//li[5]");
    public P06_AccountDeletedPage deleteAccount()
    {
        FunctionsUtilities.clickOnEle(driver,DeleteEle);
        return new P06_AccountDeletedPage(driver);
    }



}
