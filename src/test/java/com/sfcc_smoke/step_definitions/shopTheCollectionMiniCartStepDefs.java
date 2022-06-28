package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.pages.SearchPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class shopTheCollectionMiniCartStepDefs {
    WebDriver driver = Driver.getDriver();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    SearchPage searchPage = new SearchPage();

    @Then("User Clicks plus button for {string} in shop the collection")
    public void user_clicks_plus_button_for_in_shop_the_collection(String sku) {
        if (ConfigReader.getProperty("platform").equals("tablet") || ConfigReader.getProperty("platform").equals("desktop")) {
            driver.findElement(By.cssSelector("div[data-itemid='" + sku + "']  [class='plus']")).click();
        } else if (ConfigReader.getProperty("platform").equals("mobile")) {
            BrowserUtils.scrollToElement(driver.findElement(By.xpath("//div[@class='bundle-cards']")));
            driver.findElement(By.cssSelector("div[data-itemid='" + sku + "']  [class='plus']")).click();
        }
    }

    @Then("User clicks on Add Item to Cart PDP scroll")
    public void user_clicks_on_add_item_to_cart_pdp_scroll() {
        if (ConfigReader.getProperty("platform").equals("tablet") || ConfigReader.getProperty("platform").equals("desktop"))  {
            BrowserUtils.clickWithJS(productDetailPage.addtocart);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }  else if (productDetailPage.AddToCart_mob.isDisplayed()) {
            BrowserUtils.scrollToElement(productDetailPage.AddToCart_mob);
            productDetailPage.AddToCart_mob.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    @Then("User Clicks Add to Cart in Shop the Collection for {string}")
    public void user_clicks_add_to_cart_in_shop_the_collection_for(String sku) {
        if (ConfigReader.getProperty("platform").equals("tablet") || ConfigReader.getProperty("platform").equals("desktop")) {
            BrowserUtils.clickWithJS(driver.findElement(By.xpath("//label[@for='bundle-anchor-atc-" + sku + "']")));

//            BrowserUtils.scrollToElement(productDetailPage.addtocart);
        }
        if (ConfigReader.getProperty("platform").equals("mobile")) {
            BrowserUtils.scrollToElement(productDetailPage.shopTheCollectionBundledCards);
            driver.findElement(By.xpath("//label[@for='bundle-anchor-atc-" + sku + "']")).click();
            BrowserUtils.scrollToElement(productDetailPage.AddToCart_mob);
        }
    }
}
