package com.apollo_automation.step_definitions;

import com.ashley_ui.pages.CommonPage;
import com.ashley_ui.pages.HomePage;
import com.ashley_ui.utilities.BrowserUtils;
import com.ashley_ui.utilities.Driver;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CommonPageDefs {

    WebDriver driver = Driver.getDriver();
    CommonPage CommonPage = new CommonPage();

    @When("user set the closet store by {string}")
    public void user_set_the_closet_store_by(String zipcode) {
        CommonPage.Storedownarrow.click();
        CommonPage.HomeStoreZipcodeBox.sendKeys(zipcode + Keys.ENTER);
        BrowserUtils.sleep(2);
    }

    @When("User search for a SKU {string} and clicks on it")
    public void serachitem(String Item) {
       CommonPage.searchbar.click();
       CommonPage.searchbar.sendKeys(Item + Keys.ENTER);
    }

    @When("User search for a SKU {string} and clicks on item 1 in result set")
    public void serachitem_result1(String Item) {
        CommonPage.searchbar.click();
        CommonPage.searchbar.sendKeys(Item);
        CommonPage.searchbar_result1.click();
    }

    @When("User navigate to cart page")
    public void clickonminicart(){
        CommonPage.minicarticon.click();
    }

    @When("User navigate back to cart page")
    public void clickonbacktocart(){
        CommonPage.bacttoCartIcon.click();
    }

    @When("User closes browser")
    public void closebrowser(){
        driver.close();
    }

    @When("User verifies that Paypal login page is launched")
    public void getpagetitle(){
        Assert.assertEquals("Log in to your PayPal account", driver.getTitle());
        System.out.println(driver.getTitle());;
    }

}
