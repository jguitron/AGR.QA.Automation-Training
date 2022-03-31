package com.apollo_project.desktop_ui.step_definitions;

import com.apollo_project.desktop_ui.pages.LandingPage;
import com.apollo_project.utilities.BrowserUtils;
import com.apollo_project.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class UrlStabilityStep_Defs {

    WebDriver driver = Driver.getDriver();
    LandingPage landingPage = new LandingPage();

    @Given("user goes to {string}")
    public void userGoesTo(String url) {
        driver.get(url);
    }

    @When("user scrolls down the page to footer")
    public void userScrollsDownThePageToFooter() throws InterruptedException {
        BrowserUtils.scrollToElement(landingPage.footer);
        Thread.sleep(2000);
    }

    @Then("user scrolls up the page back to header")
    public void userScrollsUpThePageBackToHeader() throws InterruptedException {
        BrowserUtils.scrollToElement(landingPage.header);
        Thread.sleep(2000);
    }
}
