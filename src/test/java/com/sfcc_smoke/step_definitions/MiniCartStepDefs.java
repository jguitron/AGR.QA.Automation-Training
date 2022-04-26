package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.CartPage;
import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MiniCartStepDefs {
    WebDriver driver = Driver.getDriver();
    CartPage cartPage = new CartPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();


    @Then("User Removes item from mini cart")
    public void user_removes_item_from_mini_cart() {
        driver.findElement(By.xpath("//button[@class='remove-cart-item']")).click();
        driver.findElement(By.xpath("//button[@class='remove']")).click();
    }

    @Then("User asserts items removed from mini cart and is {int} qty")
    public void user_asserts_items_removed_from_mini_cart_and_is_qty(Integer int1) {
        int CartQty = Integer.parseInt(driver.findElement(By.xpath("//span[@class='minicart-quantity']")).getText());
        System.out.println(CartQty);
        int ExpectedQty = 0;
        Assert.assertEquals(CartQty, ExpectedQty);

    }
    @Then("User clicks on save for later")
    public void user_clicks_on_save_for_later() {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            cartPage.saveItem.isDisplayed();
            cartPage.saveItem.click();
        }
        /**mobile has different webelement for save for later*/
        else if (ConfigReader.getProperty("platform").equals("mobile")) {
            cartPage.saveItem.isDisplayed();
            cartPage.saveItem.click();
            productDetailPage.continueShopping.click();
        }



    }
}
