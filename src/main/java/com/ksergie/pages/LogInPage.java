package com.ksergie.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import static jdk.nashorn.internal.objects.NativeString.trim;


public class LogInPage extends PageObject {
    
    private By emailField = By.xpath("//input[@id='login_email']");
    private By passwordField = By.xpath("//input[@id='login_password']");
    private By loginButton = By.xpath("//input[@id='login_password']/following-sibling::button[@type='submit']");
    private By fogotPasswordLink = By.xpath("//a[@class='forgotlink']");
    private By closeIcon = By.xpath("//div[@id='login_frame']//img");
    private By titlePage = By.xpath("//div[@id='login_frame']/div/div[1]");
    private By toolTip = By.xpath("//div[@id='login_frame']//div[@class='_logicstatus']");

    // Get page title
    public String getTitle() {
        return find(titlePage).waitUntilVisible().getText();
    }

    // Input Email
    public LogInPage typeEmail(String email) {
        find(emailField).waitUntilVisible().sendKeys(email);
        return this;
    }

    // Input password
    public LogInPage typePassword(String passwd) {
        find(passwordField).waitUntilVisible().sendKeys(passwd);
        return this;
    }

    // Click the "Login" button
    public LogInPage clickLoginButton(){
        find(loginButton).waitUntilVisible().click();
        return this;
    }

    public void logInExitget(String email, String passwd) {
        typeEmail(email);
        typePassword(passwd);
        clickLoginButton();
    }

    // Click the "Fogot password" link
    public ResetPage clickResetPasswdLink(){
        find(fogotPasswordLink).waitUntilVisible().click();
        return new ResetPage();
    }

    // Click the "Close" icon
    public MainPage closeWindow() {
        find(closeIcon).waitUntilVisible().click();
        return new MainPage();
    }

    public String getToolTip(){
        return trim(find(toolTip).waitUntilVisible().getText());
    }
}
