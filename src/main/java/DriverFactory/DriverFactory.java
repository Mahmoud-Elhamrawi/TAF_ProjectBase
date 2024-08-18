package DriverFactory;

import Utility.LogUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Arrays;
import java.util.List;

public class DriverFactory {

    //WebDriver
    public static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public static void setupDriver(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-popup-blocking");
                driverThreadLocal.set(new ChromeDriver(options));
            break;
            case "firefox":
                FirefoxOptions options2 = new FirefoxOptions();
                options2.addArguments("--start-maximized");
                options2.addArguments("--disable-popup-blocking");
                driverThreadLocal.set(new FirefoxDriver(options2));
                break;
            default:
                EdgeOptions options1 = new EdgeOptions();
                options1.addArguments("--start-maximized");
                driverThreadLocal.set(new EdgeDriver(options1));
        }
    }


        public static WebDriver getDriver()
        {
            return driverThreadLocal.get();
        }

        public static void closeDriver()
        {
             getDriver().quit();
             driverThreadLocal.remove();
            LogUtility.info("diver is quit......");
        }

}
