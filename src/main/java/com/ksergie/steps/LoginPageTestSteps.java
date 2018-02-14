package com.ksergie.steps;

import com.ksergie.pages.DashboardPage;
import com.ksergie.pages.LogInPage;
import com.ksergie.pages.MainPage;
import com.ksergie.pages.ResetPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

@DefaultUrl("https://exitget.com/")
public class LoginPageTestSteps {

    LogInPage logInPage;
    MainPage mainPage;
    DashboardPage dashboardPage;
    ResetPage resetPage;

    @Step("Login page. Login to ExitGet.com")
    public void loginExitget(String email, String passwd){
        mainPage.open();
        mainPage.clickLogIn();
        logInPage.logInExitget(email, passwd);
    }

    @Step("Login page. Click the \"Forgot password\" link")
    public void resetPasswd(){
        mainPage.open();
        mainPage.clickLogIn();
        logInPage.clickResetPasswdLink();
    }

    @Step("Login page. Click the \"Close\" icon")
    public void closeLoginPage(){
        mainPage.open();
        mainPage.clickLogIn();
        logInPage.closeWindow();
    }

    @Step("Login page. Get tooltip message")
    public String getToolTip() {
        return logInPage.getToolTip();
    }

    @Step("Login page. Get Dashboard title")
    public String getDashboardTitle() {
        loginExitget("exitgetest@gmail.com", "20exitget17");
        return dashboardPage.getTitle();
    }

    @Step("Login page. Get MainPage title")
    public String getMainPageTitle() {
        return mainPage.getTitle();
    }

    @Step("Login page. Get ResetPage title")
    public String getResetPageTitle() {
        mainPage.open();
        mainPage.clickLogIn();
        logInPage.clickResetPasswdLink();
        return resetPage.getTitle();
    }
}
