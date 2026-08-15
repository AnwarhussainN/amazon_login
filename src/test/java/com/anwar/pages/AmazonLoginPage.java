package com.anwar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class AmazonLoginPage extends BasePage {

    private By accountList =
            By.id("nav-link-accountList");

    public AmazonLoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click Amazon Account and Lists")
    public void clickAccount() {

        click(accountList);
    }
}