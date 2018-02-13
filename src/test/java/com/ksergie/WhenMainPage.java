package com.ksergie;

import com.ksergie.steps.MainPageTestStep;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)

public class WhenMainPage {

    @Steps
    MainPageTestStep steps;

    @Managed
    WebDriver drv;

    @Test
    public void clickLoginButton() {
        steps.clickLoginButton();
    }

}
