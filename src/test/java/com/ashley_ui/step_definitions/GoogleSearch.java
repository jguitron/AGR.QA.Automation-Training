package com.ashley_ui.step_definitions;

import com.ashley_ui.pages.GooglePage;
import com.ashley_ui.utilities.ConfigurationReader;
import com.ashley_ui.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class GoogleSearch {

    WebDriver driver = Driver.getDriver();
    GooglePage googlePage = new GooglePage();

    @Given("User is on google home page")
    public void user_is_on_google_home_page() {
//        driver.get(ConfigurationReader.getProperty("googleUrl"));
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.google.com/"));
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
        Assert.assertTrue(driver.getCurrentUrl().contains(value));
    }

}
