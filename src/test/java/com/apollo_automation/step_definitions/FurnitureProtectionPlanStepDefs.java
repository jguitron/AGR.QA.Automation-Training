package com.apollo_automation.step_definitions;

import com.ashley_ui.pages.SearchPage;
import com.ashley_ui.utilities.Driver;
import com.google.gson.annotations.Until;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;


public class FurnitureProtectionPlanStepDefs {
    WebDriver driver = Driver.getDriver();



    @When("User clicks on Location Icon")
    public void user_clicks_on_location_icon()  {



        driver.findElement(By.cssSelector("li[id='mobile-stores-icon']")).click();
    }
    @Then("User changes zipcode to {int}")
    public void user_changes_zipcode_to(Integer int1) {
        driver.findElement(By.cssSelector("input[class='input-text numbers-hypen-only postal required']")).sendKeys("33606");
    }
    @Then("User clicks update button")
    public void user_clicks_update_button() {

        driver.findElement(By.xpath("//div[@class='form-row form-row-button form-row-bottom-zero']")).click();

    }
    @Then("User clicks on the search bar")
    public void user_clicks_on_the_search_bar()  {


        driver.findElement(By.id("q")).click();


    }
    @Then("User search's {int} in search bar")
    public void user_search_s_in_search_bar(Integer int1)   {
        driver.findElement(By.id("q")).sendKeys("7500538");
        driver.findElement(By.className("unbxd-as-popular-product-name popular-title")).click();
    }

    @Then("User Adds Darcy Sofa SKU: {int} to cart")
    public void user_adds_darcy_sofa_sku_to_cart(Integer int1) {

    }
    @Then("User Validates {double} FPP is eligible for furniture")
    public void user_validates_fpp_is_eligible_for_furniture(Double double1) {

    }

}
