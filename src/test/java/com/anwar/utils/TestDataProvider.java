package com.anwar.utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "searchProducts")
    public Object[][] searchProducts() {

        return new Object[][] {
            {"Laptop"},
            {"Mobile"},
            {"Headphones"},
            {"Keyboard"}
        };
    }
}