package com.ksergie.steps;

import com.ksergie.pages.DashboardPage;
import net.thucydides.core.annotations.Step;

public class DashboardTestSteps {

    DashboardPage dashboardPage;

    @Step
    public void clickAccountButton() {
        dashboardPage.clickAccountButton();
    }


}
