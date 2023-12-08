package listenrsUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AppiumUtils;
import utils.ExtentReporterImpl;

import java.io.IOException;


public class Listeners extends AppiumUtils implements ITestListener {

    ExtentReports extentReports = ExtentReporterImpl.getReportObject();
    ExtentTest extentTest;
    AppiumDriver driver;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        extentTest = extentReports.createTest(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        extentTest.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        try {
            driver = (AppiumDriver) iTestResult.getTestClass().getRealClass().getField("driver").get(iTestResult.getInstance());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        try {
            extentTest.addScreenCaptureFromPath(captureScreenshot(iTestResult.getMethod().getMethodName(), driver), iTestResult.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.fail(iTestResult.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        extentTest.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();
        ;
    }
}
