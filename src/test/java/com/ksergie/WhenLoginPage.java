package com.ksergie;


import com.ksergie.steps.LoginPageTestSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)

public class WhenLoginPage {

    @Steps
    LoginPageTestSteps steps;

    @Managed
    WebDriver drv;

    @Test
    public void loginWithCorrectData() {
        steps.loginExitget("exitgetest@gmail.com", "20exitget17");
        Assertions.assertThat("exitgettest").isEqualTo(steps.getDashboardTitle());
    }

    @Test
    public void loginWithoutData() {
        steps.loginExitget("", "");
        Assertions.assertThat("You must provide the email address you registered with.").isEqualTo(steps.getToolTip());
    }

    @Test
    public void loginWithoutPasswd() {
        steps.loginExitget("exitgetest@gmail.com", "");
        Assertions.assertThat("You must provide a password to login.").isEqualTo(steps.getToolTip());
    }

    @Test
    public void loginWithIncorrectEmail() {
        steps.loginExitget("123qwer", "");
        Assertions.assertThat("You must provide a valid email address.").isEqualTo(steps.getToolTip());
    }

    @Test
    public void loginWithCorrectEmailIncorrectPasswd() {
        steps.loginExitget("exitgetest@gmail.com", "00000");
        Assertions.assertThat("The login information you provided was not correct.").isEqualTo(steps.getToolTip());
    }

    @Test
    public void loginWithUnregisteredEmail() {
        steps.loginExitget("test_test@gmail.com", "0000");
        Assertions.assertThat("The login information you provided was not correct.").isEqualTo(steps.getToolTip());
    }

    @Test
    public void resetPassword() {
        steps.resetPasswd();
        Assertions.assertThat("Reset").isEqualTo(steps.getResetPageTitle());
    }

    @Test
    public void closeLoginPage() {
        steps.closeLoginPage();
        Assertions.assertThat("A Popup Platform for Everyone").isEqualTo(steps.getMainPageTitle());
    }

}
