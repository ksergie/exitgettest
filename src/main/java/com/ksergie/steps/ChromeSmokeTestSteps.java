package com.ksergie.steps;

import com.ksergie.pages.DashboardPage;
import net.thucydides.core.annotations.Step;

public class ChromeSmokeTestSteps {

    DashboardPage dashboardPage;

    @Step("Click the \"Account\" button")
    public void clickAccountButton() {
        dashboardPage.clickAccountButton();
    }


}
