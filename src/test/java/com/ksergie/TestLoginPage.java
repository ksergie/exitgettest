package com.ksergie;


import com.ksergie.steps.LoginPageTestSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)

public class TestLoginPage {

    @Steps
    LoginPageTestSteps steps;

    @Managed
    WebDriver driver;

    @Before
    public void maxSizeWindow() {
        driver.manage().window().maximize();
    }

    @Test
//    @Pending
    @Title("Login page. Login with correct data")
    public void loginWithCorrectData() {
        steps.loginExitget("exitgetest@gmail.com", "20exitget17");
        Assertions.assertThat("VISITATIONS").isEqualTo(steps.getOverviewPageTitle());
    }

    @Test
//    @Pending
    @Title("Login page. Login without data")
    public void loginWithoutData() {
        steps.loginExitget("", "");
        Assertions.assertThat("You must provide the email address you registered with.").isEqualTo(steps.getToolTip());
    }

    @Test
//    @Pending
    @Title("Login page. Login without password")
    public void loginWithoutPasswd() {
        steps.loginExitget("exitgetest@gmail.com", "");
        Assertions.assertThat("You must provide a password to login.").isEqualTo(steps.getToolTip());
    }

    @Test
//    @Pending
    @Title("Login page. Login with incorrect email")
    public void loginWithIncorrectEmail() {
        steps.loginExitget("123qwer", "");
        Assertions.assertThat("You must provide a valid email address.").isEqualTo(steps.getToolTip());
    }

    @Test
//    @Pending
    @Title("Login page. Login with correct email and incorrect password")
    public void loginWithCorrectEmailIncorrectPasswd() {
        steps.loginExitget("exitgetest@gmail.com", "00000");
        Assertions.assertThat("The login information you provided was not correct.").isEqualTo(steps.getToolTip());
    }

    @Test
//    @Pending
    @Title("Login page. Login with unregistered email")
    public void loginWithUnregisteredEmail() {
        steps.loginExitget("test_test@gmail.com", "0000");
        Assertions.assertThat("The login information you provided was not correct.").isEqualTo(steps.getToolTip());
    }

    @Test
//    @Pending
    @Title("Login page. Test the \"Forgot password\" link")
    public void resetPassword() {
        steps.resetPasswd();
        Assertions.assertThat("Reset").isEqualTo(steps.getResetPageTitle());
    }

    @Test
//    @Pending
    @Title("Login page. Test the \"Close\" icon")
    public void closeLoginPage() {
        steps.closeLoginPage();
        Assertions.assertThat("A Popup Platform for Everyone").isEqualTo(steps.getMainPageTitle());
    }

}
