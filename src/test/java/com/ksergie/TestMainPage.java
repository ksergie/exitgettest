package com.ksergie;

import com.ksergie.steps.MainPageTestStep;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.assertj.core.api.Assertions;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)

public class TestMainPage {

    @Steps
    MainPageTestStep steps;

    @Managed
    WebDriver driver;

    @Test
    @Title("Main page. Test \"Log In\" button")
    public void clickLoginButton() {
        steps.clickLoginButton();
    }

}
