package com.apollo_project.tablet_ui.step_definitions;

import com.apollo_project.tablet_ui.pages.LandingPage;
import com.apollo_project.utilities.BrowserUtils;
import com.apollo_project.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UrlStabilityStepDefs {

    LandingPage landingPage = new LandingPage();

    @Given("user goes to {string}")
    public void userGoesTo(String url) {
        Driver.getDriver().navigate().to(url);
    }

    @When("user scrolls down the page to footer")
    public void userScrollsDownThePageToFooter() throws InterruptedException {
        BrowserUtils.scrollToElement(landingPage.footer);
        Thread.sleep(2000);
    }

    @Then("user scrolls up the page back to header")
    public void userScrollsUpThePageBackToHeader() throws InterruptedException {
        BrowserUtils.scrollToElement(landingPage.header);
        Thread.sleep(3000);
    }
}
