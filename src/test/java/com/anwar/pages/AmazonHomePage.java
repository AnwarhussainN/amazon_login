package com.anwar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class AmazonHomePage extends BasePage {

    private By searchBox =
            By.id("twotabsearchtextbox");

    private By searchButton =
            By.id("nav-search-submit-button");

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Search for product: {product}")
    public void searchProduct(String product) {

        type(searchBox, product);

        click(searchButton);
    }
}