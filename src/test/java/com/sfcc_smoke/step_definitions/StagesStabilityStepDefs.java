package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.LandingPageLG;
import com.sfcc_smoke.utilities.BrowserUtils;;
import io.cucumber.java.en.*;

public class StagesStabilityStepDefs {
    LandingPageLG landingPageLG = new LandingPageLG();

    @Then("User scrolls to header")
    public void scrollToHeader() {
        BrowserUtils.scrollToElement(landingPageLG.header);
        BrowserUtils.waitForPageToLoad(5);
    }
}
