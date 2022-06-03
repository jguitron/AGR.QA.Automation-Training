package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.SearchPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SearchBarStepDefs {

    WebDriver driver = Driver.getDriver();
    SearchPage search = new SearchPage();
    SearchPage searchPage = new SearchPage();

    @Then("User sends {string} in search bar")
    public void sendValue(String searchValue) {
        search.searchBar.sendKeys(searchValue);
        search.searchIcon.click();
    }

    @Given("User clicks on search icon")
    public void clickOnSearchIcon() {
        BrowserUtils.waitForClickability(search.searchIcon, Duration.ofSeconds(5)).click();
    }

    @When("User should see url ending with {string}")
    public void verifyUrlEndpoint(String expectedHeader) {
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedHeader.toLowerCase()));
    }

    @Then("User should see total amount is more than 0")
    public void verifyTotalCount() {
        Assert.assertTrue(search.productCount.getText().length() > 0);
        String totalItemsFound = search.productCount.getText().substring(10, 14);
        System.out.println("Total items found: " + totalItemsFound);
    }

    @When("User search's {string} in search bar")
    public void user_search_s_in_search_bar(String item) {
        searchPage.searchBar.sendKeys(item + Keys.ENTER);
    }

//    @When("User clicks on search bar")
//    public void user_clicks_on_search_bar() {
//        BrowserUtils.waitForClickability(searchPage.searchBar, Duration.ofSeconds(7)).click();
//
//    }
}
