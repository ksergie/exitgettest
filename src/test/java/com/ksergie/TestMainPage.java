package com.ksergie;

import com.ksergie.steps.MainPageTestSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.assertj.core.api.Assertions;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)

public class TestMainPage {

    @Steps
    MainPageTestSteps steps;

    @Managed
    WebDriver driver;

    @Before
    public void maxSizeWindow() {
        driver.manage().window().maximize();
    }

    @Test
//    @Pending
    @Title("Main page. Test \"Log In\" button")
    public void clickLoginButton() {
        steps.clickLoginButton();
        Assertions.assertThat("Login").isEqualTo(steps.getLoginPageTitle());
    }

}
