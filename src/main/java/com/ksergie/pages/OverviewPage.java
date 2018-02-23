package com.ksergie.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class OverviewPage extends PageObject {

    private By titlePage = By.xpath("//div[contains(@value, 'by unique users')]");
    private By accountButton = By.id("accountButton");
    private By quickStartGuideLink = By.xpath("//a[text()='QuickStart Guide']");

    public String getTitle(){
        return find(titlePage).waitUntilVisible().getText();
    }

    public OverviewPage clickAccountButton() {
        find(accountButton).waitUntilVisible().click();
        return new OverviewPage();
    }

    public QuickStartGuidePage clickQuickStartGuideItem() {
        find(quickStartGuideLink).waitUntilVisible().click();
        return new QuickStartGuidePage();
    }
}
