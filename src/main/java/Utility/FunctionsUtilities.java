package Utility;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class FunctionsUtilities {
    //TODO:: click ele
    public static void clickOnEle(WebDriver driver , By ele)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(ele));
        driver.findElement(ele).click();
    }

    //TODO::enter text
    public static void enterText(WebDriver driver , By ele , String text)
    {
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(ele));
        driver.findElement(ele).sendKeys(text);
    }

    //TODO::Get text from Ele
    public static String getTextValue(WebDriver driver , By ele)
    {
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(ele));
        return driver.findElement(ele).getText();
    }

    //TODO:Scrolling
    public static void scrollViaPage(WebDriver driver ,By ele)
    {
        ((JavascriptExecutor)driver).
                executeScript("arguments[0].scrollIntoView();",driver.findElement(ele));
    }

    //TODO::Take screenshot
    public static String screenPath= "test-outputs/screenShots/";
    public static void takeScreen(WebDriver driver ,String screenName) throws IOException {

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File Dis = new File(screenPath+screenName+"_"+createTime()+".png");
        FileUtils.copyFile(src,Dis);

    }

    //TODO::time stemp
   public static String createTime()
   {
       return new SimpleDateFormat("yyyy-MM-dd || h:m:ss a").format(new Date());
   }


    //TODO:: Select options
    public static void selectOption(WebDriver driver , By ele , String option)
    {
        new Select(driver.findElement(ele)).selectByValue(option);
    }

    //TODO:: Generate Random numbers
    public static int generateRandomNumber(int upper)
    {
        return new Random().nextInt(upper)+1;
    }
    //TODO:: Generate set of random Numbers uniqe
    public static Set<Integer> uniqeRandomNumber(int needNum  , int totalNum)
    {
        Set<Integer> uniqeNum = new HashSet<>();
        while (uniqeNum.size()<needNum)
        {
            int random = generateRandomNumber(totalNum) ;
            uniqeNum.add(random);
        }
return uniqeNum;

    }


    //TODO::convert By to WebEle
    public static WebElement converter(WebDriver driver ,By ele)
    {
        return driver.findElement(ele);
    }

    //TODO::Get latest file from list of files
    public static File getLatestFile(String path)
    {
      File file =new File(path);
      File[]files=file.listFiles();
        assert files != null;
        if (files.length==0)
          return null;
        Arrays.sort(files,Comparator.comparingLong(File::lastModified).reversed());
       return files[0];
    }


    //TODO::Cookies


     public static Set<Cookie> getAllCookies(WebDriver driver)
     {
         return driver.manage().getCookies();
     }

     public static void restoreCookies(WebDriver driver , Set<Cookie> cookies)
     {
         for (Cookie cookie:cookies)
             driver.manage().addCookie(cookie);
     }











}
