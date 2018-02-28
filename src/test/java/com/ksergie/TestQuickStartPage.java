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
        //Asserts
        accountPage.clickCloseButton();
        overviewPage.clickQuickStartGuideItem();
        quickStartGuidePage.fillInstallUrlForm();
        Assert.assertEquals("ERROR IS APPEARED AFTER INPUT INSTALLATION URL AND CLICKING NEXT BUTTON", "Development mode", quickStartGuidePage.getDevModeFormTitle());
//        Assertions.assertThat("Development mode").isEqualTo(quickStartGuidePage.getDevModeFormTitle());
        quickStartGuidePage.fillDevModeForm();
        Assert.assertEquals("ERROR IS APPEARED AFTER FILLING DEVELOPMENT MODE FORM", "Choose the advertisement background", quickStartGuidePage.getTemplateFormTitle());
//        Assertions.assertThat("Choose the advertisement background").isEqualTo(quickStartGuidePage.getTemplateFormTitle());
        quickStartGuidePage.selectFilterDropDown("Redirection only");
        quickStartGuidePage.clickTemplate();
        quickStartGuidePage.clickPersonalDesignButton();
        Assert.assertEquals("ERROR IS APPEARED AFTER CLICKING THE NEXT BUTTON ON THE PERSONAL DESIGN FORM", "Profesional Design Customization", quickStartGuidePage.getDesignFormTitle());
//        Assertions.assertThat("Profesional Design Customization").isEqualTo(quickStartGuidePage.getDesignFormTitle());
        quickStartGuidePage.fillRedirectionUrlField("https://exitget.com");
        Assert.assertEquals("ERROR IS APPEAR AFTER FILLING REDIRECT URL FIELD AND CLICKING THE NEXT BUTTON", "Redirect to: https://exitget.com", quickStartGuidePage.getRedirectionFormTitle());
//        Assertions.assertThat("Redirect to: https://exitget.com").isEqualTo(quickStartGuidePage.getRedirectionFormTitle());
        quickStartGuidePage.selectTimeDelayIntent();
        Assert.assertEquals("ERROR IS APPEAR AFTER SELECTING THE TIME DELAY INTEND", "1 rules configred", quickStartGuidePage.getRulesFormTitle());
//        Assertions.assertThat("1 rules configred").isEqualTo(quickStartGuidePage.getRulesFormTitle());
        quickStartGuidePage.confirmInstallation();
        Assert.assertEquals("ERROR IS APPEAR AFTER CLICKING CONFIRM INSTALLATION BUTTON", "Final step: Confirm installation", quickStartGuidePage.getFinalFormTitle());
//        Assertions.assertThat("Final step: Confirm installation").isEqualTo(quickStartGuidePage.getFinalFormTitle());
        String mainWindowHandle = driver.getWindowHandle();
        waiting(2000);
        swithBetweenWindows();
        waiting(3000);
        swithBetweenWindows();
        driver.findElement(popupButton).click();
        waiting(2000);
        driver.switchTo().window(mainWindowHandle);
        quickStartGuidePage.clickConfirmButton();
//        Assertions.assertThat("Please rate our QuickStart Guide").isEqualTo(quickStartGuidePage.getRateFormTitle());
        Assert.assertEquals("ERROR IS APPEARED AFTER CLICKING \"CONFIRM\" BUTTON", "Please rate our QuickStart Guide1", quickStartGuidePage.getRateFormTitle());
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
