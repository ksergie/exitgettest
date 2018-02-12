package com.ksergie.steps;

import com.ksergie.pages.DashboardPage;
import com.ksergie.pages.LogInPage;
import com.ksergie.pages.MainPage;
import com.ksergie.pages.ResetPage;
import net.thucydides.core.annotations.Step;


public class LoginPageTestSteps {

    LogInPage logInPage;
    MainPage mainPage;
    DashboardPage dashboardPage;
    ResetPage resetPage;

    @Step("Login to ExitGet.com")
    public void loginExitget(String email, String passwd){
        mainPage.open();
        mainPage.clickLogIn();
        logInPage.logInExitget(email, passwd);
    }

    @Step("Click the \"Forgot password\" link")
    public void resetPasswd(){
        logInPage.resetPasswd();
    }

    @Step("Click the \"Close\" icon")
    public void closeLoginPage(){
        logInPage.closeWindow();
    }

    @Step("Get tooltip message")
    public void getToolTip() {
        logInPage.getToolTip();
    }

    @Step("Get Dashboard title")
    public String getDashboardTitle() {
        loginExitget("exitgetest@gmail.com", "20exitget17");
        return dashboardPage.getTitle();
    }

    @Step("Get MainPage title")
    public String getMainPageTitle() {
        return mainPage.getTitle();
    }

    @Step("Get ResetPage title")
    public String getResetPageTitle() {
        loginExitget("exitgetest@gmail.com", "20exitget17");
        return resetPage.getTitle();
    }
}
