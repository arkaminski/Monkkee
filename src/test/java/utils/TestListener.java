package utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListener implements ITestListener {
    public void onTestStart(org.testng.ITestResult result) {
        log.info(">>>>>>>>>>>>>>>TEST START: "+ result.getName() +">>>>>>>>>>>>>>>");
    }
    public void onTestSuccess(org.testng.ITestResult result) {
        log.info(">>>>>>>>>>>>>>>TEST SUCCESS: " + result.getName() + ">>>>>>>>>>>>>>>" );
    }
    public void onTestFailure(org.testng.ITestResult result) {
        log.error(">>>>>>>>>>>>>>>TEST FAILURE: " + result.getName() + ">>>>>>>>>>>>>>>" );
        takeScreenshot(result);
    }
    public void onTestSkipped(org.testng.ITestResult result) {
        log.warn(">>>>>>>>>>>>>>>TEST SKIPPED: " + result.getName() + ">>>>>>>>>>>>>>>" );
    }
    public void onStart(ITestContext iTestContext) {
        log.info(">>>>>>>>>>>>>>>TEST START: " + iTestContext.getName() + ">>>>>>>>>>>>>>>" );
    }
    public void onFinish(ITestContext iTestContext) {
        log.info(">>>>>>>>>>>>>>>TEST FINISH >>>>>>>>>>>>>>>" );
    }

    private byte[] takeScreenshot(ITestResult iTestResult) {
        ITestContext context = iTestResult.getTestContext();
        try {
            WebDriver driver = (WebDriver) context.getAttribute("driver");
            if (driver != null) {
                return AllureUtils.takeScreenshot(driver);
            } else {
                return new byte[]{};
            }
        } catch (NoSuchSessionException | IllegalStateException ex) {
            return new byte[]{};
        }
    }
}
