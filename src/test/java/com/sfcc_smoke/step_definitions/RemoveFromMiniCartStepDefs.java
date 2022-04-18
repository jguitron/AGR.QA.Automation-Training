package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.pages.SearchPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RemoveFromMiniCartStepDefs {

    WebDriver driver = Driver.getDriver();
    SearchPage searchPage = new SearchPage();

    @Then("User search's Boise {int}\" Single Bathroom Vanity Set in search bar")
    public void user_search_s_boise_single_bathroom_vanity_set_in_search_bar(Integer int1) {
        searchPage.searchBar.sendKeys("Boise 24 Single Bathroom Vanity Set" + Keys.ENTER);
    }

    @Then("User clicks on Boise {int}\" Single Bathroom Vanity Set")
    public void user_clicks_on_boise_single_bathroom_vanity_set(Integer int1) {
        driver.findElement(By.xpath("//img[@alt='Boise  24\" Bathroom Vanity, Walnut Brown, large']")).click();
    }

    @Then("User clicks Add Item to Cart DeskTop")
    public void user_clicks_add_item_to_cart_desk_top() {
        JavascriptExecutor Js1 = (JavascriptExecutor) driver;
        Js1.executeScript("window.scrollBy(0,900)");
        driver.findElement(By.xpath(" //button[@id='add-to-cart-sticky']")).click();
    }

    @Then("User Removes item from mini cart")
    public void user_removes_item_from_mini_cart() {
        driver.findElement(By.xpath("//button[@class='remove-cart-item']")).click();
        //this is to select yes to remove item from cart
        driver.findElement(By.xpath("//button[@class='remove']")).click();
        BrowserUtils.sleep(3);
    }

    @Then("User asserts items removed from mini cart and is {int} qty")
    public void user_asserts_items_removed_from_mini_cart_and_is_qty(Integer int1) {
        int CartQty = Integer.parseInt(driver.findElement(By.xpath("//span[@class='minicart-quantity']")).getText());
        System.out.println(CartQty);
        int ExpectedQty = 0;
        Assert.assertEquals(CartQty, ExpectedQty);
    }
}
