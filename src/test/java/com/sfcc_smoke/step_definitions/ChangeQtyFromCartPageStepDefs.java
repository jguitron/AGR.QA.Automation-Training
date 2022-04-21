package com.sfcc_smoke.step_definitions;
import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.pages.SearchPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class ChangeQtyFromCartPageStepDefs {
    WebDriver driver = Driver.getDriver();
    SearchPage searchPage = new SearchPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();


    @When("User clicks on the search bar")
    public void user_clicks_on_the_search_bar() {
        searchPage.searchBar.click();
    }


    @When("User search's {string} in search bar")
    public void user_search_s_in_search_bar(String item) {
        searchPage.searchBar.sendKeys(item);
    }

    @When("User clicks on {string} in pdp")
    public void user_clicks_on_in_pdp(String itemName) {
        /**all items contain same anchor and tag. img and @alt are same for all items, just add element for alt for item needed
         * ex:8//img[@alt='8 Inch Chime Innerspring Twin Mattress in a Box, White, large']  */

        driver.findElement(By.xpath("//img[@alt='" + itemName + "']")).click();
    }

    @When("User clicks on Add Item to Cart")
    public void user_clicks_on_add_item_to_cart() {
        String currentHandle = driver.getWindowHandle();
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
             productDetailPage.addtocart.isDisplayed();
                productDetailPage.addtocart.click(); }
                /**mobile has different webelement for add to cart*/
            else if (productDetailPage.AddToCart_mob.isDisplayed()) {
                BrowserUtils.scrollToElement(productDetailPage.AddToCart_mob);
                productDetailPage.AddToCart_mob.click();
            }
        }


    @Then("User changes Qty from 1 to 2 in cart")
    public void user_changes_qty_from_to_in_cart() {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            driver.findElement(By.xpath("//select[@name='dwfrm_cart_shipments_i0_items_i0_quantity']")).click();
            BrowserUtils.scrollToElement(driver.findElement(By.xpath("//option[@value='2']")));
            driver.findElement(By.xpath("//option[@value='2']")).click();
        }
        else if (ConfigReader.getProperty("platform").equals("mobile")) {
            JavascriptExecutor Js1 = (JavascriptExecutor) driver;
            Js1.executeScript("window.scrollBy(0,400)");
            BrowserUtils.sleep(3);
            driver.findElement(By.xpath("//select[@name='dwfrm_cart_shipments_i0_items_i0_quantity']")).click();
            BrowserUtils.scrollToElement(driver.findElement(By.xpath("//option[@value='2']")));
            driver.findElement(By.xpath("//option[@value='2']")).click();
        }


    }

    @Then("Assert total number of items in cart is {int}")
    public void assert_total_number_of_items_in_cart_is(Integer int1) {

        String MyCart = driver.findElement(By.xpath("//h1[@class='cart-title']")).getText();
        System.out.println(MyCart);
        String expectedQty = "My Cart (2 items)";
        Assert.assertEquals(expectedQty, MyCart);
    }

}