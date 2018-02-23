package com.ksergie.steps;

import com.ksergie.pages.*;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

@DefaultUrl("https://exitget.com/")
public class AccountPageTestSteps {

    MainPage mainPage;
    LogInPage logInPage;
    AccountPage accountPage;
    OverviewPage overviewPage;

    public void openPage(){
        mainPage.open();
        mainPage.clickLogIn();
        logInPage.logInExitget("exitgetest@gmail.com", "20exitget17");
        overviewPage.clickAccountButton();
    }

    @Step
    public String getAccountPageTitle() {
        openPage();
        return accountPage.getTitle();
    }

    @Step
    public String clickCloseButton(){
        openPage();
        accountPage.clickCloseButton();
        return overviewPage.getTitle();
    }
}
