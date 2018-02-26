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
    private By templateFormTitle = By.xpath("//div[@id='chooseImage']//span[2]");
    private By redirectionFormTitle = By.xpath("//div[@id='inputRedirectionUrl']//span[2]");
    private By rulesFormTitle = By.xpath("(//div[@id='triggerType']//span[2])[1]");
    private By finalFormTitle = By.xpath("//div[@id='testInstallation']//span[2]");
    private By rateFormTitle = By.xpath("(//div[@id='testInstallation']//div[@class='listTitle'])[2]");
    private By designFormTitle = By.xpath("//div[@id='customizeDesign']//span[2]");
    private By filterDropDown = By.xpath("//div[@id='chooseImage']//select");
    private By blackFridayTemplate = By.xpath("//img[@src='//exitget.com/static/images/templates/PurpleBlackFriday3for1Button.png']");
    private By personalDesignNextButton = By.xpath(".//*[@id='customizeDesign']//button[1]");
    private By redirectionUrlField = By.id("redirectionUrl");
    private By redirectUrlNextButton = By.xpath("//div[@id='inputRedirectionUrl']//input[@value='Next']");
    private By selectIntentNextButton = By.xpath(".//*[@id='triggerType']//button");
    private By confirmOpenButton = By.xpath("//button[text()='Open']");
    private By confirmButton = By.xpath("//button[text()='Confirm']");

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

    public String getTemplateFormTitle() {
        return find(templateFormTitle).waitUntilVisible().getText();
    }

    public String getDesignFormTitle() {
        return find(designFormTitle).waitUntilVisible().getText();
    }

    public String getRedirectionFormTitle() {
        return find(redirectionFormTitle).waitUntilVisible().getText();
    }

    public String getRulesFormTitle() {
        return find(rulesFormTitle).waitUntilVisible().getText();
    }

    public String getFinalFormTitle() {
        return find(finalFormTitle).waitUntilVisible().getText();
    }

    public String getRateFormTitle() {
        return find(rateFormTitle).waitUntilVisible().getText();
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

    public QuickStartGuidePage clickConfirmButton() {
        find(confirmButton).waitUntilVisible().click();
        return this;
    }
}
