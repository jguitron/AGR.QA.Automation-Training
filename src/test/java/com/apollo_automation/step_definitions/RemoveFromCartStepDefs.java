package com.apollo_automation.step_definitions;
import com.ashley_ui.pages.PDPPage;
import com.ashley_ui.pages.SearchPage;
import com.ashley_ui.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class RemoveFromCartStepDefs {
    WebDriver driver = Driver.getDriver();
    com.ashley_ui.pages.SearchPage SearchPage = new SearchPage();
    PDPPage PDPPage = new PDPPage();

    @Then("User search's Whitesburg Dining Table in search bar")
    public void user_search_s_whitesburg_dining_table_in_search_bar() {
        SearchPage.searchBar.click();
        SearchPage.searchBar.sendKeys("Whitesburg Dining Table ");

    }
    @Then("User clicks search icon")
    public void user_clicks_search_icon() {

        SearchPage.searchIcon.click();
    }


    @Then("User clicks on Whitesburg Dining Table")
    public void user_clicks_on_whitesburg_dining_table() throws InterruptedException {
        driver.findElement(By.xpath("//img[@alt='Whitesburg Dining Table, , large']")).click();

    }
    @And("User clicks Add Item to Cart Mobile")
    public void userClicksAddItemToCartMobile() {
        PDPPage.AddToCart.click();
//        driver.findElement(By.xpath("//button[@id='add-to-cart-sticky']")).click();
    }

    @Then("User is in cart page")
    public void user_is_in_cart_page() {
        driver.findElement(By.xpath("//a[@class='mini-cart-link']")).click();
    }


    @When("User validates item in cart")
    public void user_validates_item_in_cart() {
        if (driver.findElement(By.cssSelector("div[class='name'] a[title='Go to Product: Whitesburg Dining Table']")).getAttribute("title").contains("Whitesburg"))
        {
            System.out.println("Whitesburg table added to cart");
        }
    }
    @When("User Removes item from cart")
    public void user_removes_item_from_cart() throws InterruptedException {
        JavascriptExecutor Js1 = (JavascriptExecutor) driver;
        Js1.executeScript("window.scrollBy(0,900)");
        driver.findElement(By.cssSelector("div[class='cart-product-option-mobile'] a[class='remove-cart-item']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@class='remove']")).click();
    }
    @Then("User Validates cart is {int} qty")
    public void user_validates_cart_is_qty(Integer int1) {
        driver.findElement(By.xpath("//div[@class='cart-empty']")).getText();
        System.out.println(driver.findElement(By.xpath("//div[@class='cart-empty']")).getText());

    }


}
