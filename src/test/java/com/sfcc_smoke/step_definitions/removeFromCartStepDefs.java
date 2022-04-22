package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.CartPage;
import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.pages.SearchPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class removeFromCartStepDefs {

    WebDriver driver = Driver.getDriver();
    SearchPage searchPage = new SearchPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    CartPage cartPage = new CartPage();

    @Then("User clicks search icon")
    public void user_clicks_search_icon() {
        searchPage.searchIcon.click();
    }


    @Then("User clicks on cart")
    public void user_clicks_on_cart() {

        driver.findElement(By.xpath("//a[@class='mini-cart-link']")).click();
    }


    @When("User Removes item from cart")
    public void user_removes_item_from_cart() {
        if (ConfigReader.getProperty("platform").equals("desktop")) {
            cartPage.removeitem.click();
            cartPage.removeitem_YesBtn.click();
        } else if (ConfigReader.getProperty("platform").equals("tablet")) {
            cartPage.removeItem_BtnMobileTablet.click();
            cartPage.removeitem_YesBtn.click();
        } else if(ConfigReader.getProperty("platform").equals("mobile")) {
            /**must scroll to add expert services tag above remove item to reach remove item button,
             * cannot scroll too remove button because will be out of screen*/
            BrowserUtils.scrollToElement(driver.findElement(By.className("handy-head")));
            cartPage.removeItem_BtnMobileTablet.click();
            cartPage.removeitem_YesBtn.click();
        }
    }


            @Then("User Validates cart is {int} qty")
            public void user_validates_cart_is_qty (Integer int1){
                String actualQty = driver.findElement(By.xpath("//div[@class='cart-empty']")).getText();
                String expectedQty = "Your Shopping Cart is Empty";
                Assert.assertTrue(expectedQty, actualQty.contains("Your Shopping Cart is Empty"));

            }
        }
