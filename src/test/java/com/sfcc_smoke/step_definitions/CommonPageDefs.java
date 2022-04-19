package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.CommonPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class CommonPageDefs {

    WebDriver driver = Driver.getDriver();
    CommonPage commonPage = new CommonPage();

    @When("user finds closest store by {string}")
    public void user_set_the_closet_store_by(String zipcode) {
        BrowserUtils.waitForVisibility(commonPage.Storedownarrow, Duration.ofSeconds(5));
        commonPage.HomeStoreZipcodeBox.sendKeys(zipcode + Keys.ENTER);
    }

    @When("User searches for SKU {string} and clicks on it")
    public void serachitem(String Item) {
        BrowserUtils.waitForVisibility(commonPage.searchbar, Duration.ofSeconds(5));
        commonPage.searchbar.sendKeys(Item + Keys.ENTER);
    }

    @When("User search for a SKU {string} and clicks on item 1 in result set")
    public void serachitem_result1(String Item) {
        BrowserUtils.waitForVisibility(commonPage.searchbar, Duration.ofSeconds(5));
        commonPage.searchbar.sendKeys(Item);
        commonPage.searchbar_result1.click();
    }

    @When("User navigate to cart page")
    public void clickonminicart() {
        BrowserUtils.waitForVisibility(commonPage.minicarticon, Duration.ofSeconds(5));
        commonPage.minicarticon.click();
    }

    @When("User navigate back to cart page")
    public void clickonbacktocart() {
        BrowserUtils.waitForVisibility(commonPage.bacttoCartIcon, Duration.ofSeconds(5));
        commonPage.bacttoCartIcon.click();
    }

    @When("User verifies that Paypal login page is launched")
    public void getpagetitle() {
        Assert.assertEquals("Log in to your PayPal account", driver.getTitle());
        System.out.println(driver.getTitle());

    }
}
