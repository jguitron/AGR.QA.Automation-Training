package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class PLPStepDefs {
    WebDriver driver = Driver.getDriver();

    @When("User chooses {string} in plp")
    public void user_chooses_on_in_pdp(String itemName) {
        driver.findElement(By.xpath("//img[@alt='" + itemName + "']")).click();
    }


    @Then("User clicks on item filters in PLP and asserts change")
    public void user_clicks_on_item_filters_in_plp_and_asserts_change() {
        driver.findElement(By.xpath("//div[@class='refinement lifestyle']")).click();
        driver.findElement(By.xpath("//li /a[@id='lifestyle-cottage']")).click();
        BrowserUtils.sleep(2);
        String filteredQty = driver.findElement(By.xpath("//a[@id='lifestyle-cottage'] /span /span")).getText();
        List <WebElement> pLPFilteredQty = (driver.findElements(By.xpath("//div[@class='product-name']")));
        int numberOfElements = pLPFilteredQty.size();
        String number = String.valueOf(numberOfElements);
        Assert.assertTrue(filteredQty.contains(number));

    }

    @Then("User clicks on item filters in plp and asserts change")
    public void user_clicks_on_item_filters_in_plp_and_asserts_changes() {
        driver.findElement(By.xpath("//a[@class='breadcrumb-element clear-all']")).click();
        driver.findElement(By.xpath("//div[@class='refinement price']")).click();
        BrowserUtils.scrollToElement(driver.findElement(By.xpath("//div[@class='refinement price']")));
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("//li /a[@id='-0000000000']")).click();
        String filteredQty = driver.findElement(By.xpath("//a[@id='-0000000000'] /span /span")).getText();

        if (!Objects.equals(filteredQty, "(16)")) {
            driver.findElement(By.xpath("//a[@class='page-2']")).click();
            int Page1 = 16;
            String Page2Click = driver.findElement(By.xpath("//a[@id='-0000000000'] /span /span")).getText();
            int Page2Total = Integer.parseInt(Page2Click);
            int Total = 0;
            int Sum = 0;
            System.out.println(Sum = Integer.parseInt(Page2Total + Page2Click));


            List <WebElement> pLPFilteredQty = (driver.findElements(By.xpath("//div[@class='product-name']")));
            int numberOfElements = pLPFilteredQty.size();

            String number = String.valueOf(numberOfElements);
            Assert.assertTrue(filteredQty.contains(number));
        }
//        else {
//            driver.findElement(By.xpath("//a[@id='-0000000000'] /span /span")).getText();
//            List <WebElement> pLPFilteredQty = (driver.findElements(By.xpath("//div[@class='product-name']")));
//            int numberOfElements = pLPFilteredQty.size();
//            String number = String.valueOf(numberOfElements);
//            Assert.assertTrue(filteredQty.contains(number));
//        }
    }
}
