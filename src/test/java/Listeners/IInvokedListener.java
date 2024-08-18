package Listeners;

import Utility.FunctionsUtilities;
import Utility.LogUtility;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.IOException;

import static DriverFactory.DriverFactory.getDriver;

public class IInvokedListener  implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        LogUtility.info("BEFORE RUNNING.......");
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

        LogUtility.info("AFTER RUNNING.....");

    if (testResult.getStatus() == ITestResult.FAILURE)
    {
        try {
            LogUtility.error("taking screenshot.......");
            FunctionsUtilities.takeScreen(getDriver(),testResult.getName());
        } catch (IOException e) {
            LogUtility.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }




    }

}
