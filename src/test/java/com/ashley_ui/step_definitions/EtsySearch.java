package com.ashley_ui.step_definitions;

import com.ashley_ui.pages.EtsyPage;
import com.ashley_ui.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EtsySearch {

    EtsyPage etsyPage = new EtsyPage();

    @Given("User is on Etsy home page")
    public void user_is_on_etsy_home_page() {
        Driver.getDriver().get("https://www.etsy.com/");
    }

    @When("User clicks on main search bar")
    public void user_clicks_on_main_search_bar() {
        etsyPage.search.click();
    }

    @When("User types {string} in search bar")
    public void user_types_in_search_bar(String value) {
        etsyPage.search.sendKeys(value);
    }

    @When("User clicks on search icon")
    public void user_clicks_on_search_icon() {
        etsyPage.clickSearch.click();
    }

    @Then("User should be able to see {string} in results page")
    public void user_should_be_able_to_see_in_results_page(String value1) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(value1));
    }

}
