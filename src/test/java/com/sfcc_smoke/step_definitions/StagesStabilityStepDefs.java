package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.LandingPage;
import com.sfcc_smoke.utilities.BrowserUtils;;
import io.cucumber.java.en.*;

public class StagesStabilityStepDefs {
    LandingPage landingPage = new LandingPage();

    @Then("User scrolls to header")
    public void scrollToHeader() {
        BrowserUtils.scrollToElement(landingPage.header);
        BrowserUtils.waitForPageToLoad(5);
    }
}
