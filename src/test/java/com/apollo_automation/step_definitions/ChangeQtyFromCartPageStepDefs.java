package com.apollo_automation.step_definitions;

import com.ashley_ui.pages.SearchPage;
import com.ashley_ui.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ChangeQtyFromCartPageStepDefs {
    WebDriver driver = Driver.getDriver();
    com.ashley_ui.pages.SearchPage SearchPage = new SearchPage();



    @When("User search's {int} Inch Innerspring Twin Mattress in a Box in Search bar")
    public void user_search_s_inch_innerspring_twin_mattress_in_a_box_in_search_bar(Integer int1) {
        SearchPage.searchBar.sendKeys("8 Inch Innerspring Twin Mattress in a Box");
    }

    @When("User clicks on {int} Inch Innerspring Twin Mattress in a Box")
    public void user_clicks_on_inch_innerspring_twin_mattress_in_a_box(Integer int1) {
        driver.findElement(By.xpath("//img[@alt='8 Inch Chime Innerspring Twin Mattress in a Box, White, large']")).click();
    }

    @Then("User changes Qty from {int} to {int}")
    public void user_changes_qty_from_to(Integer int1, Integer int2) throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor Js1 = (JavascriptExecutor) driver;
        Js1.executeScript("window.scrollBy(0,400)");
        Thread.sleep(3000);
        String Total = driver.findElement(By.xpath("//option[@value='1']")).getText();
        System.out.println("1st Qty check is " + Total);

    }

    @Then("Assert total number of items in cart is {int}")
    public void assert_total_number_of_items_in_cart_is(Integer int1) throws InterruptedException {
        JavascriptExecutor Js1 = (JavascriptExecutor) driver;
        Js1.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.xpath("//option[@value='2']")).click();
        Thread.sleep(3000);
        String Total2 = driver.findElement(By.xpath("//option[@value='2']")).getText();
        System.out.println("2nd Qty check is " + Total2);

        String MyCart = driver.findElement(By.xpath("//h1[@class='cart-title']")).getText();
        String expectedQty = "My Cart (2 items)";
        Assert.assertEquals(expectedQty, MyCart);
    }
}
