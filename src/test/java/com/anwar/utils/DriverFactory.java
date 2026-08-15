package com.anwar.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

            return new ChromeDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            return new EdgeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            return new FirefoxDriver();

        } else {

            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser);
        }
    }
}