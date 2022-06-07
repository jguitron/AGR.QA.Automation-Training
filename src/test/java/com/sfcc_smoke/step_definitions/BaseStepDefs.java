package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.BasePage;
import com.sfcc_smoke.pages.LandingPage;
import com.sfcc_smoke.pages.SearchPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseStepDefs {

    WebDriver driver = Driver.getDriver();
    BasePage basePage = new BasePage();
    SearchPage searchPage = new SearchPage();
    LandingPage landingPage = new LandingPage();

    @When("User finds closest store by {string}")
    public void user_set_the_closet_store_by(String zipcode) {
        String platform = ConfigReader.getProperty("platform");
        BrowserUtils.waitForPageToLoad(10);
        if (platform.equals("desktop")) {
            BrowserUtils.waitForVisibility(basePage.chooseLocalStore, Duration.ofSeconds(5));
            BrowserUtils.clickWithJS(basePage.chooseLocalStore);
            BrowserUtils.waitForVisibility(basePage.zipCodeBox, Duration.ofSeconds(5));
            basePage.zipCodeBox.sendKeys(zipcode + Keys.ENTER);
            BrowserUtils.sleep(2);
        }
        else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            BrowserUtils.waitForVisibility(landingPage.mobileMenu, Duration.ofSeconds(5));
            BrowserUtils.clickWithJS(landingPage.mobileMenu);
            BrowserUtils.waitForVisibility(basePage.mobStoreLink, Duration.ofSeconds(5));
            BrowserUtils.clickWithJS(basePage.mobStoreLink);
            BrowserUtils.waitForVisibility(basePage.zipCodeBox, Duration.ofSeconds(5));
            basePage.zipCodeBox.sendKeys(zipcode + Keys.ENTER);
            BrowserUtils.sleep(2);
        }
    }

    @When("User searches for SKU {string} and clicks on it")
    public void serachitem(String Item) {
        BrowserUtils.sleep(3);
        basePage.searchBar.sendKeys(Item + Keys.ENTER);
    }

    @When("User search for a SKU {string} and clicks on item 1 in result set")
    public void serachitem_result1(String Item) {
        BrowserUtils.waitForVisibility(basePage.searchBar, Duration.ofSeconds(5));
        basePage.searchBar.sendKeys(Item);
        basePage.searchBarResultOne.click();
    }

    @When("User navigate to cart page")
    public void clickonminicart() {
        BrowserUtils.waitForVisibility(basePage.miniCartIcon, Duration.ofSeconds(5));
        basePage.miniCartIcon.click();
    }

    @When("User navigate back to cart page")
    public void clickonbacktocart() {
        BrowserUtils.waitForVisibility(basePage.backToCartIcon, Duration.ofSeconds(5));
        basePage.backToCartIcon.click();
    }

    @When("User verifies that Paypal login page is launched")
    public void getpagetitle() {
        Assert.assertEquals("Log in to your PayPal account", driver.getTitle());

    }

    @Then("User clicks search icon")
    public void user_clicks_search_icon() {
        searchPage.searchIcon.click();
    }


    @Then("User clicks on Heart Icon in plp")
    public void user_clicks_on_heart_icon_in_plp() {
        BrowserUtils.hover(driver.findElement(By.xpath("//a[@aria-label='Add to Wishlist']")));
        driver.findElement(By.xpath("//a[@aria-label='Add to Wishlist']")).click();
    }
}
