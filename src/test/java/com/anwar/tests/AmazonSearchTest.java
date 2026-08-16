package com.anwar.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.anwar.base.BaseTest;
import com.anwar.pages.AmazonHomePage;
import com.anwar.utils.TestDataProvider;

public class AmazonSearchTest extends BaseTest {

    @Test(
        groups = {"smoke", "regression"},
        dataProvider = "searchProducts",
        dataProviderClass = TestDataProvider.class
    )
    public void searchProduct(String product) {

        AmazonHomePage homePage = new AmazonHomePage(driver);

        homePage.searchProduct(product);

        String currentUrl = driver.getCurrentUrl();
            // Jenkins SCM trigger test
        Assert.assertTrue(
                currentUrl.toLowerCase().contains(product.toLowerCase()),
                "Search results page was not displayed for: " + product
        );
    }
}