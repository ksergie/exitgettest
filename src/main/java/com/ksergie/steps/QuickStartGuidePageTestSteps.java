package com.ksergie.steps;

import com.ksergie.pages.*;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

@DefaultUrl("https://exitget.com/")
public class QuickStartGuidePageTestSteps {

    OverviewPage overviewPage;
    QuickStartGuidePage quickStartGuidePage;
    MainPage mainPage;
    LogInPage logInPage;
    AccountPage accountPage;

    @Step
    public String getInstallUrlFormTitle(){
        overviewPage.clickQuickStartGuideItem();
        return quickStartGuidePage.getInstallUrlFormTitle();
    }

    @Step
    public void quickStart(){
        mainPage.open();
        mainPage.clickLogIn();
        logInPage.logInExitget("exitgetest@gmail.com", "20exitget17");
        overviewPage.clickAccountButton();
        accountPage.fillCurrentPasswordField("20exitget17");
        accountPage.clickResetAccountButton();
        accountPage.closeAlertWindow();
        accountPage.clickCloseButton();
        overviewPage.clickQuickStartGuideItem();
        quickStartGuidePage.fillInstallUrlForm();
        quickStartGuidePage.fillDevModeForm();
        quickStartGuidePage.selectFilterDropDown("Redirection only");
        quickStartGuidePage.clickTemplate();
        quickStartGuidePage.clickPersonalDesignButton();
        quickStartGuidePage.fillRedirectionUrlField("https://exitget.com");
        quickStartGuidePage.selectTimeDelayIntent();
        quickStartGuidePage.confirmInstallation();
        quickStartGuidePage.swithTabs();
    }

}
