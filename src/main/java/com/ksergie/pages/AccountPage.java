package com.ksergie.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class AccountPage extends PageObject {

    private By titlePage = By.xpath("(//div[@id='account']/form//b)[1]");
    private By currentPasswordField = By.xpath("//input[@id='accountpass2']");
    private By newPasswordField = By.xpath("//input[@id='accountpass1']");
    private By resetAccountButton = By.xpath("//button[text()='RESET ACCOUNT']");
    private By closeButton = By.xpath("//button[text()='CLOSE']");
    private By saveButton = By.xpath("//button[text()='SAVE']");

    public String getTitle(){
        return find(titlePage).waitUntilVisible().getText();
    }

    public AccountPage fillCurrentPasswordField(String passwd) {
        find(currentPasswordField).waitUntilVisible().sendKeys(passwd);
        return this;
    }

    public AccountPage clickResetAccountButton() {
        find(resetAccountButton).waitUntilVisible().click();
        return this;
    }

    public AccountPage clickCloseButton(){
        find(closeButton).waitUntilVisible().click();
        return this;
    }

    public AccountPage clickSaveButton(){
        find(saveButton).waitUntilVisible().click();
        return this;
    }

    public AccountPage fillNewPasswordField(String passwd) {
        find(newPasswordField).waitUntilVisible().sendKeys(passwd);
        return this;
    }
}
