package com.apollo_automation.step_definitions;

import com.apollo_automation.pages.desktop_pages.LandingPageLG;
import com.apollo_automation.utilities.BrowserUtils;;
import io.cucumber.java.en.*;

public class StagesStabilityStepDefs {

    LandingPageLG landingPageLG = new LandingPageLG();

    @Then("user scrolls to header")
    public void scrollToHeader() throws InterruptedException {
        BrowserUtils.scrollToElement(landingPageLG.topAshleyBtn);
        BrowserUtils.waitForPageToLoad(5);

    }

}
