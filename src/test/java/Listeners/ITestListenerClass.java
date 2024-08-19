package Listeners;

import Utility.LogUtility;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class ITestListenerClass implements org.testng.ITestListener {


    public void onTestStart(ITestResult result) {
        LogUtility.info("Tc :" +result.getName()+"started..");
    }

    public void onTestSuccess(ITestResult result) {
        LogUtility.info("Tc :" +result.getName()+"Success..");

    }

    public void onTestFailure(ITestResult result) {
        LogUtility.info("Tc :" +result.getName()+"Fail..");

    }

    public void onTestSkipped(ITestResult result) {
        LogUtility.info("Tc :" +result.getName()+"Skip..");

    }
    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }

}
