package com.ashley_ui.step_definitions;
import com.ashley_ui.pages.SearchPage;
import com.ashley_ui.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class VerifySaveForLaterMiniCartStepDefs {

    WebDriver driver = Driver.getDriver();
    com.ashley_ui.pages.SearchPage SearchPage = new SearchPage();

    @When("User search's B600008392 in search bar")
    public void user_search_s_b600008392_in_search_bar() {
      SearchPage.searchBar.sendKeys(" B600008392");
      SearchPage.searchIcon.click();
    }

    @Then("User adds Delta Children Mercer Crib to cart")
    public void user_adds_delta_children_mercer_crib_to_cart() {
        JavascriptExecutor Js1 = (JavascriptExecutor) driver;
        Js1.executeScript("window.scrollBy(0,700)");
        SearchPage.addToCart.click();

    }

    @Then("User clicks on save for later")
    public void user_clicks_on_save_for_later() {
        driver.findElement(By.xpath("//button[@class='save-item']")).click();
    }

    @Then("User clicks on cart icon")
    public void user_clicks_on_cart_icon () {
        driver.findElement(By.xpath("//a[@class='mini-cart-link mini-cart-empty']")).click();
        JavascriptExecutor Js1 = (JavascriptExecutor) driver;
        Js1.executeScript("window.scrollBy(0,650)");
    }


        @Then("User asserts saved items in cart")
        public void user_asserts_saved_items_in_cart() {

            String SavedItem = driver.findElement(By.cssSelector("h2 a[tabindex='0']")).getText();
            String expectedItem = "Delta Children Mercer 6-in-1 Convertible Crib with Storage Trundle";
            Assert.assertEquals(expectedItem, SavedItem);
        }


}


