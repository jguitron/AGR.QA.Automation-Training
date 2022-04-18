package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.desktop_pages.LandingPageLG;
import com.sfcc_smoke.utilities.BrowserUtils;;
import io.cucumber.java.en.*;

public class StagesStabilityStepDefs {

    LandingPageLG landingPageLG = new LandingPageLG();

    @Then("user scrolls to header")
    public void scrollToHeader() {
        BrowserUtils.scrollToElement(landingPageLG.topAshleyBtn);
        BrowserUtils.waitForPageToLoad(5);

    }
}
