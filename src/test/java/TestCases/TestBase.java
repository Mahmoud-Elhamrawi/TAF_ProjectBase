package TestCases;

import Pages.P01_WelcomePage;
import Utility.DataUtility;
import Utility.LogUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

public class TestBase {


    @BeforeMethod
    public static void starting() throws IOException {
        setupDriver(DataUtility.readPropertyFile("ENV","Browser"));
        LogUtility.info("chrome opening......");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(DataUtility.readPropertyFile("ENV","BaseUrl"));
        Assert.assertTrue(new P01_WelcomePage(getDriver()).assertOnUrlHomePage(DataUtility.readPropertyFile("ENV","BaseUrl")));
        LogUtility.info(getDriver().getCurrentUrl());
        LogUtility.info("browser is opening....");
    }


    @AfterMethod
    public static void cleanUp()
    {
       closeDriver();
    }

}
