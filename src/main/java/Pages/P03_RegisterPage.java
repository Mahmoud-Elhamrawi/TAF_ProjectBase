package Pages;

import Utility.FunctionsUtilities;
import Utility.LogUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P03_RegisterPage {
    public WebDriver driver ;
    public P03_RegisterPage(WebDriver driver) {
        this.driver =driver ;
    }



    private final By titleInp = By.id("id_gender1");
    private final By passwordInp = By.id("password");
    private final By selectDay =By.id("days");
    private final By selectMonth = By.id("months");
    private final By selectYear =  By.id("years");
    private final By firstNameInp = By.id("first_name");
    private final By lastNameInp = By.id("last_name");
    private final By addressInp = By.id("address1");
    private final By countryInp = By.id("country");
    private final By stateInp = By.id("state");
    private final By cityInp = By.id("city");
    private final By zipcodeInp = By.id("zipcode");
    private final By mobileNumberInp = By.id("mobile_number");
    private final By createAccBtn = By.xpath("//button[@data-qa=\"create-account\"]");

    private final By assertOnTitleEle = By.xpath("//b[.=\"Enter Account Information\"]");

    // Verify that 'ENTER ACCOUNT INFORMATION' is visible
    public boolean assertOnTitleFillData()
    {
        new WebDriverWait(driver , Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(assertOnTitleEle));
        LogUtility.info(driver.findElement(assertOnTitleEle).getText());
        return driver.findElement(assertOnTitleEle).isDisplayed();
    }
public P04_AccountCreated fillDataRegistration(String password , String day ,String month , String year,String fName , String lName ,String address,String country ,String state , String city , String zipcode , String mobileNum)
{
    FunctionsUtilities.clickOnEle(driver,titleInp);
    FunctionsUtilities.enterText(driver,passwordInp,password);
    FunctionsUtilities.selectOption(driver,selectDay,day);
    FunctionsUtilities.selectOption(driver,selectMonth,month);
    FunctionsUtilities.selectOption(driver,selectYear,year);
    FunctionsUtilities.enterText(driver,firstNameInp,fName);
    FunctionsUtilities.enterText(driver,lastNameInp,lName);
    FunctionsUtilities.enterText(driver,addressInp ,address);
    FunctionsUtilities.selectOption(driver,countryInp,country);
    FunctionsUtilities.enterText(driver,stateInp,state);
    FunctionsUtilities.enterText(driver,cityInp,city);
    FunctionsUtilities.enterText(driver,zipcodeInp,zipcode);
    FunctionsUtilities.enterText(driver,mobileNumberInp,mobileNum);
    FunctionsUtilities.clickOnEle(driver,createAccBtn);

    return new P04_AccountCreated(driver);
}





}
