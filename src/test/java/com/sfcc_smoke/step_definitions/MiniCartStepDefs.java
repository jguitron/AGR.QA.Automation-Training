package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.CartPage;
import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.utilities.BrowserUtils;
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

    @Then("User clicks on save for later")
    public void user_clicks_on_save_for_later() {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            cartPage.saveItem.isDisplayed();
            cartPage.saveItem.click();
        } else if (ConfigReader.getProperty("platform").equals("mobile")) {
            cartPage.saveItem.isDisplayed();
            cartPage.saveItem.click();
            productDetailPage.continueShopping.click();
        }
    }
    @Then("User asserts items in mini cart is {string} qty")
    public void user_asserts_items_in_mini_cart_is_qty(String Item) {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            BrowserUtils.sleep(5);
            int CartQty = Integer.parseInt(driver.findElement(By.xpath("//span[@class='minicart-quantity']")).getText());
            System.out.println(CartQty);
            int ExpectedQty = Integer.parseInt(Item);
            Assert.assertEquals(CartQty, ExpectedQty);
        }
    }
}
