package com.ashley_ui.step_definitions;

import com.ashley_ui.pages.AmazonPage;
import com.ashley_ui.utilities.BrowserUtils;
import com.ashley_ui.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AmazonSearchStepDefs {

    AmazonPage amazonPage = new AmazonPage();

    @Given("User is on Amazon home page")
    public void user_is_on_amazon_home_page() {
        Driver.getDriver().get("https://www.amazon.com/");

    }
    @When("User clicks on amazon search bar")
    public void user_clicks_on_amazon_search_bar() {
        amazonPage.searchBar.click();
    }

    @When("User types {string} in search bar and clicks enter icon")
    public void user_types_in_search_bar_and_clicks_enter_icon(String searchItem) {
        amazonPage.searchBar.sendKeys(searchItem);
        amazonPage.searchButton.click();
    }
    @Then("User should see {string} within results page")
    public void user_should_see_within_results_page(String searchItem) {
        BrowserUtils.sleep(3);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(searchItem));
    }

}
