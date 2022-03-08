package com.ashley_ui.step_definitions;

import com.ashley_ui.pages.GooglePage;
import com.ashley_ui.utilities.BrowserUtils;
import com.ashley_ui.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleSearchStepDefs {

    GooglePage googlePage = new GooglePage();

    @Given("User is on google home page")
    public void user_is_on_google_home_page() {
        Driver.getDriver().get("https://google.com");
        System.out.println(Driver.getDriver().getCurrentUrl());
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://www.google.com/"));
    }

    @When("User clicks on search bar")
    public void user_clicks_on_search_bar() {
        googlePage.searchBar.click();
    }

    @When("User types {string} in search bar and clicks enter")
    public void user_types_in_search_bar_and_clicks_enter(String value) {
        googlePage.searchBar.sendKeys(value+ Keys.ENTER);
    }

    @Then("User should see {string} in results page")
    public void user_should_see_in_results_page(String value) {
        BrowserUtils.sleep(3);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(value));
    }

}
