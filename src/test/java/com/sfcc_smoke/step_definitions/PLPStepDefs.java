package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.ProductListPage;
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
    ProductListPage productListPage = new ProductListPage();

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
    @Then("User checks for {string} button is present")
    public void user_checks_for_button_is_present(String Learn) {
        BrowserUtils.scrollToElement(driver.findElement(By.xpath("//a[@aria-label='Add to Wishlist']")));
        BrowserUtils.clickWithJS(driver.findElement(By.xpath("//span[@class='as-low-as-period']")));
        BrowserUtils.sleep(2);
        String learnHow = driver.findElement(By.xpath("//a[@class='as-low-as-learn-more']")).getText();
        Assert.assertEquals(learnHow, Learn);
    }

    @Then("User asserts {string} in learn how popup with {string}")
    public void user_asserts_in_learn_how_popup_with(String button, String Asserted) {
        String textOnScreen = driver.findElement(By.xpath("//a[@class='as-low-as-"+button+"-now as-low-as-learn-more ss-synch-set']")).getText();
        Assert.assertTrue(textOnScreen.contains(Asserted));
        driver.findElement(By.xpath("//span[@class='ui-button-icon ui-icon ui-icon-closethick']")).click();
    }


    @Then("User asserts next button to {string} is {string}")
    public void user_asserts_next_button_to_is(String pageDesired, String pageNumber) {
        driver.findElement(By.xpath("//a[@class='"+pageDesired+"']")).click();
        BrowserUtils.sleep(2);
        String currentPage = driver.findElement(By.xpath("//li[@class='current-page']")).getText();
        Assert.assertTrue(pageNumber.contains(currentPage));
    }

    @Then("User clicks second page of inventory and asserts that {string} is {string}")
    public void user_clicks_second_page_of_inventory_and_asserts_that_is(String pageDesired, String pageNumber) {
        driver.findElement(By.xpath("//a[@class='"+pageDesired+"']")).click();
        BrowserUtils.sleep(2);
        String currentPage = driver.findElement(By.xpath("//li[@class='current-page']")).getText();
        Assert.assertTrue(pageNumber.contains(currentPage));
    }

    @Then("User clicks next button icon and lands user on page {string}")
    public void user_clicks_next_button_icon_and_lands_user_on_page(String pageDesired) {
        driver.findElement(By.xpath("//img[@alt='Next page of Results']")).click();
        BrowserUtils.sleep(2);
        String currentPage = driver.findElement(By.xpath("//li[@class='current-page']")).getText();
        Assert.assertTrue(pageDesired.contains(currentPage));
    }

    @Then("User clicks on last page of inventory and asserts page")
    public void user_clicks_on_last_page_of_inventory_and_asserts_page() {
        driver.findElement(By.xpath("//img[@alt='Last page of Results']")).click();
        BrowserUtils.sleep(2);
        if (driver.findElements(By.xpath("//a[@class='page-switcher page-last']")).isEmpty()) {
            System.out.println("Not present");
        }
    }
}
