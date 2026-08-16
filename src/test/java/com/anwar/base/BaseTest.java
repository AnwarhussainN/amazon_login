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

        System.out.println(
                "========== BaseTest.setUp() CALLED =========="
        );

        // Read browser
        String browser = ConfigReader.get("browser");

        System.out.println(
                "Browser from config: " + browser
        );

        // Create driver
        driver = DriverFactory.createDriver(browser);

        System.out.println(
                "Driver created: " + driver
        );

        // Read timeout
        int timeout = Integer.parseInt(
                ConfigReader.get("timeout")
        );

        // Maximize browser
        driver.manage().window().maximize();

        // Create explicit wait
        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(timeout)
        );

        // Read URL
        String url = ConfigReader.get("url");

        System.out.println(
                "Opening URL: " + url
        );

        // Open application
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        System.out.println(
                "Test completed: " + result.getName()
        );

        // Take screenshot when test fails
        if (result.getStatus() == ITestResult.FAILURE) {

            System.out.println(
                    "Test failed. Capturing screenshot..."
            );

            if (driver != null) {

                ScreenshotUtil.captureScreenshot(
                        driver,
                        result.getName()
                );
            }
        }

        // Close browser
        if (driver != null) {

            System.out.println(
                    "Closing browser..."
            );

            driver.quit();
        }
    }
}