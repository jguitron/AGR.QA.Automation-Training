package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class removeFromMiniCartStepDefs {

    WebDriver driver = Driver.getDriver();


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
}
