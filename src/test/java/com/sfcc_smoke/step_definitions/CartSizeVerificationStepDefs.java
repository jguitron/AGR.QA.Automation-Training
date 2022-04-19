package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.SearchPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartSizeVerificationStepDefs {
    WebDriver driver = Driver.getDriver();
    SearchPage searchPage = new SearchPage();

    @When("User search's sofa in search bar")
    public void user_search_s_sofa_in_search_bar() {
       searchPage.searchBar.click();
        searchPage.searchBar.sendKeys("Sofa");
        searchPage.searchIcon.click();
    }

    @When("User clicks on {string}")
    public void userClicksOnSomething(String itemName) {
        driver.findElement(By.xpath("//img[@alt='" + itemName + "']")).click();
    }

    @Given("User backspaces to previous PLP")
    public void user_backspaces_to_previous_plp() {
        searchPage.searchBar.click();
        searchPage.searchBar.sendKeys("Sofa");
        searchPage.searchIcon.click();
    }

    @When("User clicks on Soletren Sofa")
    public void user_clicks_on_soletren_sofa() {
        driver.findElement(By.cssSelector("img[alt='Soletren Sofa, Stone, large']")).click();
    }

    @When("User clicks on Add Item to Cart")
    public void user_clicks_on_add_item_to_cart() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sticky']")).click();
        String Soletren = driver.findElement(By.cssSelector("div[id='ui-id-3'] a[title='Go to Product: Soletren Sofa']")).getText();
        System.out.println("Item added to cart is, " + Soletren);
        driver.findElement(By.cssSelector("div[id='ui-id-3'] a[title=' Continue Shopping']")).click();
    }

    @When("User clicks on Calion Sofa")
    public void user_clicks_on_calion_sofa() {
        searchPage.searchBar.click();
        searchPage.searchBar.sendKeys("Sofa");
        driver.findElement(By.cssSelector("img[alt='Calion Sofa, , large']")).click();
        BrowserUtils.sleep(3);
        driver.findElement(By.xpath("//button[@id='add-to-cart-sticky']")).click();
        String Calion = driver.findElement(By.cssSelector("div[id='ui-id-3'] a[title='Go to Product: Calion Sofa']")).getText();
        System.out.println("Item added to cart is, " + Calion);
    }

    @Given("Asserts total is equal to total added  in cart")
    public void asserts_total_is_equal_to_total_added_in_cart() {
        String MiniCartQty = driver.findElement(By.xpath("//span[@class='minicart-quantity']")).getText();
        System.out.println("Items in Mini Cart are , " + MiniCartQty);

    }
}

