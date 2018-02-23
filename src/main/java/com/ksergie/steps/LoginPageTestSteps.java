package com.ksergie.steps;

import com.ksergie.pages.*;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

@DefaultUrl("https://exitget.com/")
public class LoginPageTestSteps {

    LogInPage logInPage;
    MainPage mainPage;
    ResetPage resetPage;
    OverviewPage overviewPage;

    public void openPage() {
        mainPage.open();
        mainPage.clickLogIn();
    }

    @Step("Login page. Login to ExitGet.com")
    public void loginExitget(String email, String passwd){
        openPage();
        logInPage.logInExitget(email, passwd);
    }

    @Step("Login page. Click the \"Forgot password\" link")
    public void resetPasswd(){
        openPage();
        logInPage.clickResetPasswdLink();
    }

    @Step("Login page. Click the \"Close\" icon")
    public void closeLoginPage(){
        openPage();
        logInPage.closeWindow();
    }

    @Step
    public String getToolTip() {
        return logInPage.getToolTip();
    }

    @Step
    public String getOverviewPageTitle() {
        loginExitget("exitgetest@gmail.com", "20exitget17");
        return overviewPage.getTitle();
    }

    @Step
    public String getMainPageTitle() {
        return mainPage.getTitle();
    }

    @Step
    public String getResetPageTitle() {
        openPage();
        logInPage.clickResetPasswdLink();
        return resetPage.getTitle();
    }
}
