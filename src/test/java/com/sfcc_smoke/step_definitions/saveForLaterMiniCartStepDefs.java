package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.CartPage;
import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class saveForLaterMiniCartStepDefs {

    WebDriver driver = Driver.getDriver();
    CartPage cartPage = new CartPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();


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

    @Then("User clicks on cart icon")
    public void user_clicks_on_cart_icon() {
        driver.findElement(By.xpath("//a[@class='mini-cart-link mini-cart-empty']")).click();
        JavascriptExecutor Js1 = (JavascriptExecutor) driver;
        Js1.executeScript("window.scrollBy(0,650)");
    }

    @Then("User asserts {string} saved items in cart")
    public void user_asserts_saved_items_in_cart(String item) {
        String SavedItem = driver.findElement(By.cssSelector("h2 a[tabindex='0']")).getText();
        String expectedItem = item;
        Assert.assertEquals(expectedItem, SavedItem);
    }

}


