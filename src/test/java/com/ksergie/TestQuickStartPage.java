package com.ksergie;

import com.ksergie.pages.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;
import org.assertj.core.api.Assertions;
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
        accountPage.clickResetAccountButton();
        accountPage.closeAlertWindow();
        //Asserts
        accountPage.clickCloseButton();
        overviewPage.clickQuickStartGuideItem();
        quickStartGuidePage.fillInstallUrlForm();
        Assertions.assertThat("Development mode").isEqualTo(quickStartGuidePage.getDevModeFormTitle());
        quickStartGuidePage.fillDevModeForm();
        Assertions.assertThat("Choose the advertisement background").isEqualTo(quickStartGuidePage.getTemplateFormTitle());
        quickStartGuidePage.selectFilterDropDown("Redirection only");
        quickStartGuidePage.clickTemplate();
        quickStartGuidePage.clickPersonalDesignButton();
        Assertions.assertThat("Profesional Design Customization").isEqualTo(quickStartGuidePage.getDesignFormTitle());
        quickStartGuidePage.fillRedirectionUrlField("https://exitget.com");
        Assertions.assertThat("Redirect to: https://exitget.com").isEqualTo(quickStartGuidePage.getRedirectionFormTitle());
        quickStartGuidePage.selectTimeDelayIntent();
        Assertions.assertThat("1 rules configred").isEqualTo(quickStartGuidePage.getRulesFormTitle());
        quickStartGuidePage.confirmInstallation();
        Assertions.assertThat("Final step: Confirm installation").isEqualTo(quickStartGuidePage.getFinalFormTitle());
        String mainWindowHandle = driver.getWindowHandle();
        waiting(2000);
        swithBetweenWindows();
        waiting(3000);
        swithBetweenWindows();
        driver.findElement(popupButton).click();
        waiting(2000);
        driver.switchTo().window(mainWindowHandle);
        quickStartGuidePage.clickConfirmButton();
        Assertions.assertThat("Please rate our QuickStart Guide").isEqualTo(quickStartGuidePage.getRateFormTitle());
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
