package com.ksergie.steps;

import com.ksergie.pages.LogInPage;
import com.ksergie.pages.MainPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

@DefaultUrl("https://exitget.com/")
public class MainPageTestSteps {

    MainPage mainPage;
    LogInPage logInPage;

    @Step
    public void openMainPage(){
        mainPage.open();
    }

    @Step
    public void clickLoginButton() {
        openMainPage();
        mainPage.clickLogIn();
    }

    @Step
    public String getLoginPageTitle() {
        return logInPage.getTitle();
    }
}
