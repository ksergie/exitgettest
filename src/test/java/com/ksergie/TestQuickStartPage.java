package com.ksergie;

import com.ksergie.steps.QuickStartGuidePageTestSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class TestQuickStartPage {
    @Steps
    QuickStartGuidePageTestSteps steps;

    @Managed
    WebDriver driver;

    @Before
    public void maxSizeWindow() {
        driver.manage().window().maximize();
    }

    @Test
    @Title("Test the QuickStart Guide")
    public void quickStartGuide(){
        steps.quickStart();
    }
}
