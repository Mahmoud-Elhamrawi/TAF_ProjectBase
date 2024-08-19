package Listeners;

import Utility.FunctionsUtilities;
import Utility.LogUtility;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import static DriverFactory.DriverFactory.getDriver;

public class IInvokedListenerClass implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        LogUtility.info("BEFORE RUNNING.......");
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        if (testResult.getStatus() == ITestResult.FAILURE)
        {
                LogUtility.info("Tc :" +testResult.getName()+"Fail..");
                FunctionsUtilities.takeScreen(getDriver(),testResult.getName());
        }

    }

}
