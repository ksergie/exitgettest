package com.ksergie;

import com.ksergie.pages.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class TestQuickStartPage {

    MainPage mainPage;
    LogInPage logInPage;
    OverviewPage overviewPage;
    AccountPage accountPage;
    QuickStartGuidePage quickStartGuidePage;

    private By popupButton = By.xpath("//button[@id='exitget_input_3']");

    @Managed
    WebDriver driver;

    @Before
    public void maxSizeWindow() {
        driver.manage().window().maximize();
    }

    @Test
    @Title("Test the QuickStart Guide")
    public void quickStartGuide(){
        driver.get("https://exitget.com");
        mainPage.clickLogIn();
        logInPage.logInExitget("exitgetest@gmail.com", "20exitget17");
        overviewPage.clickAccountButton();
        accountPage.fillCurrentPasswordField("20exitget17");
        waiting(2000);
        accountPage.clickResetAccountButton();
        accountPage.closeAlertWindow();
        accountPage.clickCloseButton();
        overviewPage.clickQuickStartGuideItem();
        quickStartGuidePage.fillInstallUrlForm();
        Assert.assertEquals("ERROR PLACE - INPUT INSTALLATION URL FORM", "Development mode", quickStartGuidePage.getDevModeFormTitle());
        quickStartGuidePage.fillDevModeForm();
        Assert.assertEquals("ERROR PLACE - DEVELOPMENT MODE FORM", "Choose the advertisement background", quickStartGuidePage.getTemplateFormTitle());
        quickStartGuidePage.selectFilterDropDown("Redirection only");
        quickStartGuidePage.clickTemplate();
        quickStartGuidePage.clickPersonalDesignButton();
        Assert.assertEquals("ERROR PLACE - PERSONAL DESIGN FORM", "Profesional Design Customization", quickStartGuidePage.getDesignFormTitle());
        quickStartGuidePage.fillRedirectionUrlField("https://exitget.com");
        Assert.assertEquals("ERROR PLACE - INPUT REDIRECT URL FORM", "Redirect to: https://exitget.com", quickStartGuidePage.getRedirectionFormTitle());
        quickStartGuidePage.selectTimeDelayIntent();
        Assert.assertEquals("ERROR PLACE - SELECT THE INTEND FORM", "1 rules configred", quickStartGuidePage.getRulesFormTitle());
        quickStartGuidePage.confirmInstallation();
        Assert.assertEquals("ERROR PLACE - CONFIRM INSTALLATION FORM", "Final step: Confirm installation", quickStartGuidePage.getFinalFormTitle());
        String mainWindowHandle = driver.getWindowHandle();
        waiting(2000);
        swithBetweenWindows();
        waiting(3000);
        swithBetweenWindows();
        driver.findElement(popupButton).click();
        waiting(2000);
        driver.switchTo().window(mainWindowHandle);
        quickStartGuidePage.clickConfirmButton();
        Assert.assertEquals("ERROR PLACE - RETURN AFTER CLOSING POPUP", "Please rate our QuickStart Guide", quickStartGuidePage.getRateFormTitle());
    }

    private void swithBetweenWindows(){
        for (String tab: driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
    }

    private void waiting(Integer sec){
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
