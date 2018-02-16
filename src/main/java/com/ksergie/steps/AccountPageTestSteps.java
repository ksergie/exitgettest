package com.ksergie.steps;

import com.ksergie.pages.AccountPage;
import com.ksergie.pages.DashboardPage;
import com.ksergie.pages.LogInPage;
import com.ksergie.pages.MainPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

@DefaultUrl("https://exitget.com/")

public class AccountPageTestSteps {

    MainPage mainPage;
    LogInPage logInPage;
    AccountPage accountPage;
    DashboardPage dashboardPage;


    @Step
    public String getAccountPageTitle() {
        mainPage.open();
        mainPage.clickLogIn();
        logInPage.logInExitget("exitgetest@gmail.com", "20exitget17");
        dashboardPage.clickAccountButton();
        return accountPage.getTitle();
    }
}
