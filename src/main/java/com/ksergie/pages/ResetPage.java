package com.ksergie.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPage extends PageObject{

    private By titlePage = By.xpath("//div[@id='forgot_frame']/div/div[1]");

    public String getTitle(){
        return find(titlePage).getText();
    }
}
