package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.BasePage;
import com.sfcc_smoke.pages.SearchPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class BaseStepDefs {

    WebDriver driver = Driver.getDriver();
    BasePage basePage = new BasePage();
    SearchPage searchPage = new SearchPage();

    @When("user finds closest store by {string}")
    public void user_set_the_closet_store_by(String zipcode) {
        BrowserUtils.waitForVisibility(basePage.Storedownarrow, Duration.ofSeconds(5));
        basePage.HomeStoreZipcodeBox.sendKeys(zipcode + Keys.ENTER);
    }

    @When("User searches for SKU {string} and clicks on it")
    public void serachitem(String Item) {
        BrowserUtils.waitForVisibility(basePage.searchbar, Duration.ofSeconds(5));
        basePage.searchbar.sendKeys(Item + Keys.ENTER);
    }

    @When("User search for a SKU {string} and clicks on item 1 in result set")
    public void serachitem_result1(String Item) {
        BrowserUtils.waitForVisibility(basePage.searchbar, Duration.ofSeconds(5));
        basePage.searchbar.sendKeys(Item);
        basePage.searchbar_result1.click();
    }

    @When("User navigate to cart page")
    public void clickonminicart() {
        BrowserUtils.waitForVisibility(basePage.minicarticon, Duration.ofSeconds(5));
        basePage.minicarticon.click();
    }

    @When("User navigate back to cart page")
    public void clickonbacktocart() {
        BrowserUtils.waitForVisibility(basePage.bacttoCartIcon, Duration.ofSeconds(5));
        basePage.bacttoCartIcon.click();
    }

    @When("User verifies that Paypal login page is launched")
    public void getpagetitle() {
        Assert.assertEquals("Log in to your PayPal account", driver.getTitle());
        System.out.println(driver.getTitle());

    }

    @Then("User clicks search icon")
    public void user_clicks_search_icon() {
        searchPage.searchIcon.click();
    }

}
