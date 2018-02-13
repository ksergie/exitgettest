package com.ksergie.steps;

import com.ksergie.pages.LogInPage;
import com.ksergie.pages.MainPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

@DefaultUrl("https://exitget.com/")
public class MainPageTestStep {

    MainPage mainPage;
    LogInPage logInPage;

    @Step("Open the exitget.com page")
    public void openMainPage(){
        mainPage.open();
    }

    @Step("Click the \"Log In\" button")
    public void clickLoginButton() {
        openMainPage();
        mainPage.clickLogIn();
    }

    @Step("Get LoginPage title")
    public String getLoginPageTitle() {
        return logInPage.getTitle();
    }
}
