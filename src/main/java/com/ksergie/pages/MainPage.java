package com.ksergie.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://exitget.com/")
public class MainPage extends PageObject {

    private By logInButton = By.xpath("//button[@id='headerLogin']");
    private By titlePage = By.xpath("//div[@id='topImageBox']/h1");



    // Get page title
    public String getTitle() {
        return find(titlePage).waitUntilVisible().getText();
    }


    // Click the LogIn button
    public LogInPage clickLogIn() {
        find(logInButton).click();
        return new LogInPage();
    }


}
