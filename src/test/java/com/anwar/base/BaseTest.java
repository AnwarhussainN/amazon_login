package com.anwar.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.anwar.utils.ConfigReader;
import com.anwar.utils.DriverFactory;
import com.anwar.utils.ScreenshotUtil;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        String browser = ConfigReader.get("browser");
        String url = ConfigReader.get("url");
        int timeout = Integer.parseInt(ConfigReader.get("timeout"));

        driver = DriverFactory.createDriver(browser);

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        // Take screenshot only when test fails
        if (result.getStatus() == ITestResult.FAILURE) {

            String testName = result.getMethod().getMethodName();

            ScreenshotUtil.captureScreenshot(driver, testName);
        }

        // Always close browser
        if (driver != null) {

            driver.quit();

            driver = null;
        }
    }
}