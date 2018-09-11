package tests.deezer;

import engine.Driver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    Driver driver = new Driver();

    public void onTestFailure(ITestResult result) {
        try {
            driver.takeSnapShot(Driver.getInstance(), "D:\\personal\\errors");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onTestStart(ITestResult result) {

    }
    public void onTestSuccess(ITestResult result) {

    }
    public void onTestSkipped(ITestResult result) {

    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }
    public void onStart(ITestContext context) {

    }
    public void onFinish(ITestContext context) {

    }

}
