package com.anwar.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.anwar.base.BaseTest;
import com.anwar.pages.AmazonLoginPage;

public class AmazonLoginTest extends BaseTest {

   @Test(groups = "smoke")
public void verifyLoginPage()  {

        AmazonLoginPage loginPage = new AmazonLoginPage(driver);

        loginPage.clickAccount();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("signin"),
                "Login page was not displayed"
        );
    }
}