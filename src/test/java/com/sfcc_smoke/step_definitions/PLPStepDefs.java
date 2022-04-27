package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PLPStepDefs {
    WebDriver driver = Driver.getDriver();

    @When("User chooses {string} in plp")
    public void user_chooses_on_in_pdp(String itemName) {
        driver.findElement(By.xpath("//img[@alt='" + itemName + "']")).click();
    }
}
