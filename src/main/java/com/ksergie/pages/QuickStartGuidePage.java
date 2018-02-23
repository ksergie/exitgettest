package com.ksergie.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class QuickStartGuidePage extends PageObject {

    private By installUrlFormTitle = By.xpath("//div[@id='inputUrl']//span[2]");
    private By installUrlField = By.id("installUrl");
    private By urlNextButton = By.xpath("//div[@id='inputUrl']//input[@value='Next']");
    private String targetSiteUrl = "https://exitgetester.tumblr.com";
    private By switchDevMode = By.xpath("//div[@class='switch-button-background']");
    private By devModeNetxButton = By.xpath("//div[@id='debugMode']//button[text()='Next']");
    private By devModeFormTitle = By.xpath("(//div[@id='debugMode']//span[2])[1]");
    private By filterDropDown = By.xpath("//div[@id='chooseImage']//select");
    private By blackFridayTemplate = By.xpath("//img[@src='//exitget.com/static/images/templates/PurpleBlackFriday3for1Button.png']");
    private By personalDesignNextButton = By.xpath(".//*[@id='customizeDesign']//button[1]");
    private By redirectionUrlField = By.id("redirectionUrl");
    private By redirectUrlNextButton = By.xpath("//div[@id='inputRedirectionUrl']//input[@value='Next']");
    private By selectIntentNextButton = By.xpath(".//*[@id='triggerType']//button");
    private By confirmOpenButton = By.xpath("//button[text()='Open']");

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

    public QuickStartGuidePage clickPersonalDesignButton() {
        find(personalDesignNextButton).waitUntilVisible().click();
        return this;
    }

    public QuickStartGuidePage fillRedirectionUrlField(String path){
        find(redirectionUrlField).waitUntilVisible().sendKeys(path);
        find(redirectUrlNextButton).waitUntilVisible().click();
        return this;
    }

    public QuickStartGuidePage selectTimeDelayIntent() {
        find(selectIntentNextButton).waitUntilVisible().click();
        return this;
    }

    public QuickStartGuidePage confirmInstallation() {
        find(confirmOpenButton).waitUntilVisible().click();
        return this;
    }

    public QuickStartGuidePage swithTabs() {
        find(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
        return this;
    }
}
