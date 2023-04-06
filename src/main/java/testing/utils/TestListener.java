package testing.utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testing.driver.DriverManager;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class TestListener implements ITestListener {

    private static final Logger LOG = LogManager.getRootLogger();

    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("{} started", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.info("{} failed", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info("{} success", result.getName());
    }

    private void takeScreenShot() {
        File screenShot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File(String.format(".//target/screenshots/%s.png", LocalDate.now())));
        } catch (IOException e) {
            LOG.error("Failed take screenshot: {}", e.getMessage());
        }
    }

}
