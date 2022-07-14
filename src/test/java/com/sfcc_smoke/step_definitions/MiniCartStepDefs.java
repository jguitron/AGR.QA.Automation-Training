package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.CartPage;
import com.sfcc_smoke.pages.HomePage;
import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MiniCartStepDefs {
    WebDriver driver = Driver.getDriver();
    CartPage cartPage = new CartPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    HomePage homePage = new HomePage();

    @Then("User Removes item from mini cart")
    public void user_removes_item_from_mini_cart() {
        BrowserUtils.hover(homePage.cartIconDeskTopNew);
        BrowserUtils.clickWithJS(cartPage.removeItemMiniCart);
        BrowserUtils.clickWithJS(cartPage.removeitem_YesBtn);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @Then("User clicks on save for later mini cart")
    public void user_clicks_on_save_for_later_mini_cart() {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            cartPage.saveItem.isDisplayed();
            BrowserUtils.clickWithJS(cartPage.saveItem);
//            cartPage.saveItem.click();
        }
    }

    @Then("User asserts items in mini cart is {string} qty")
    public void user_asserts_items_in_mini_cart_is_qty(String Item) {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            BrowserUtils.sleep(5);
            BrowserUtils.waitForVisibility(homePage.miniCartQty,Duration.ofSeconds(4));
            String CartQty = homePage.miniCartQty.getText();
            Assert.assertEquals(Item,CartQty);
        }
    }

    @Then("User asserts {string} saved items in cart with {string} mobile skip")
    public void user_asserts_saved_items_in_cart_with_mobile_skip(String SavedItem, String assertSaved) {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            BrowserUtils.waitForPageToLoad(4);
            String savedItem = driver.findElement(By.xpath("//h2 /*[contains(@href,'" + assertSaved + "')]")).getText();
            Assert.assertTrue(SavedItem.contains(savedItem));
        }
    }
}
