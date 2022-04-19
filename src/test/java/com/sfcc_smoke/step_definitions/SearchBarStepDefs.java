package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.SearchPage;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SearchBarStepDefs {

    WebDriver driver = Driver.getDriver();
    SearchPage search = new SearchPage();

    @Then("user sends {string} in search bar")
    public void sendValue(String searchValue) {
        search.searchBar.sendKeys(searchValue);
        search.searchIcon.click();
    }

    @Given("user clicks on search icon")
    public void clickOnSearchIcon() {
        search.searchIcon.click();
    }

    @When("user should see url ending with {string}")
    public void verifyUrlEndpoint(String expectedHeader) {
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expectedHeader.toLowerCase()));
    }

    @Then("user should see total amount is more than 0")
    public void verifyTotalCount() {
        Assert.assertTrue(search.productCount.getText().length() > 0);
        String totalItemsFound = search.productCount.getText().substring(10, 14);
        System.out.println("Total items found: " + totalItemsFound);

    }

}
