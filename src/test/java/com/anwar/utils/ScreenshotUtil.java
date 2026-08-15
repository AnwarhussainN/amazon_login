package com.anwar.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String testName) {

        if (driver == null) {
            return;
        }

        try {

            // Capture screenshot as bytes
            byte[] screenshot =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BYTES);

            // Timestamp
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            // Save screenshot locally
            File destination = new File(
                    "screenshots/" + testName + "_" + timestamp + ".png"
            );

            destination.getParentFile().mkdirs();

            Files.copy(
                    new ByteArrayInputStream(screenshot),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            // Attach screenshot to Allure
            Allure.addAttachment(
                    testName + " - Failure Screenshot",
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    ".png"
            );

            System.out.println(
                    "Screenshot saved: "
                            + destination.getAbsolutePath()
            );

            System.out.println(
                    "Screenshot attached to Allure report."
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}