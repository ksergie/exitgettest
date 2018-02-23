package com.ksergie;

import com.ksergie.steps.AccountPageTestSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)


public class TestAccountPage {

    @Steps
    AccountPageTestSteps steps;

    @Managed
    WebDriver driver;

    @Before
    public void maxSizeWindow() {
        driver.manage().window().maximize();
    }

    @Test
    @Pending
    @Title("Account page. Get Account page")
    public void getAccountPage() {
        Assertions.assertThat("a12f41728769c1").isEqualTo(steps.getAccountPageTitle());
    }

    @Test
    @Pending
    @Title("Account page. Test the \"Close\" button")
    public void clickCloseButton() {
        Assertions.assertThat("VISITATIONS").isEqualTo(steps.clickCloseButton());
    }
}
