package com.ksergie.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class QuickStartGuidePage extends PageObject {

    private By installUrlFormTitle = By.xpath("//div[@id='inputUrl']//span[2]");
    private By installUrlField = By.xpath("//input[@id='installUrl']");
    private By urlNextButton = By.xpath("//div[@id='inputUrl']//input[@value='Next']");
    private String targetSiteUrl = "https://exitgetester.tumblr.com";
    private By switchDevMode = By.xpath("//div[@class='switch-button-background']");
    private By devModeNetxButton = By.xpath("//div[@id='debugMode']//button[text()='Next']");
    private By devModeFormTitle = By.xpath("(//div[@id='debugMode']//span[2])[1]");
    private By filterDropDown = By.xpath("//div[@id='chooseImage']//select");
    private By blackFridayTemplate = By.xpath("//img[@src='//exitget.com/static/images/templates/PurpleBlackFriday3for1Button.png']");

    public String getInstallUrlFormTitle(){
        return find(installUrlFormTitle).waitUntilVisible().getText();
    }

    public QuickStartGuidePage fillInstallUrlForm() {
        find(installUrlField).waitUntilVisible().sendKeys(targetSiteUrl);
        find(urlNextButton).waitUntilVisible().click();
        return this;
    }

    public String getDevModeFormTitle() {
        return find(devModeFormTitle).waitUntilVisible().getText();
    }

    public QuickStartGuidePage fillDevModeForm() {
        find(switchDevMode).waitUntilVisible().click();
        find(devModeNetxButton).waitUntilVisible().click();
        return this;
    }

    public QuickStartGuidePage selectFilterDropDown(String typeOfBanner){
        find(filterDropDown).selectByVisibleText(typeOfBanner).click();
        return this;
    }

    public QuickStartGuidePage clickTemplate(){
        find(blackFridayTemplate).waitUntilVisible().click();
        return this;
    }
}
