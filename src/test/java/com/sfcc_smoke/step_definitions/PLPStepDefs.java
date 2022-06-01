package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.ProductListPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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
    @Then("User clicks on quick view in PLP")
    public void user_clicks_on_quick_view_in_plp() {
        if (ConfigReader.getProperty("platform").equals("desktop")) {
            BrowserUtils.scrollToElement(driver.findElement(By.xpath("//img[@class='primary-image']")));
            BrowserUtils.hover(driver.findElement(By.xpath("//img[@class='primary-image']")));
            driver.findElement(By.xpath("//a[@id='quickviewbutton']")).click();
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        } else if (ConfigReader.getProperty("platform").equals("tablet")) {
            JavascriptExecutor Js1 = (JavascriptExecutor) driver;
            Js1.executeScript("window.scrollBy(0,800)");
            BrowserUtils.hover(driver.findElement(By.xpath("//img[@class='primary-image']")));
            driver.findElement(By.xpath("//a[@id='quickviewbutton']")).click();
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        }
    }
    @Then("User clicks on arrows switching between products in PLP")
    public void user_clicks_on_arrows_switching_between_products_in_plp() {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            String item1 = driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();
            driver.findElement(By.xpath("//i[@class='quickview-next']")).click();
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            String item2 = driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();
            Assert.assertNotSame(item1, item2);
        }
    }
    @Then("User clicks on learn more and closes")
    public void user_clicks_on_learn_more_and_closes() {
        if (ConfigReader.getProperty("platform").equals("desktop")) {
            driver.findElement(By.xpath("//a[@class='pdp-threshold-modal']")).click();
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            String LearnMorePopUp = driver.findElement(By.xpath("//span[@id='ui-id-3']")).getText();
            String PopUpVerify = "Available Delivery Options";
            Assert.assertEquals(LearnMorePopUp, PopUpVerify);
            driver.findElement(By.xpath("(//button[@class='ui-button ui-corner-all ui-widget ui-button-icon-only ui-dialog-titlebar-close'])[2]")).click();
        } else if (ConfigReader.getProperty("platform").equals("tablet")) {
            driver.findElement(By.xpath("//a[@class='pdp-threshold-modal']")).click();
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            String LearnMorePopUp = driver.findElement(By.xpath("(//span[@class='delivery-msg'])[17]")).getText();
            String PopUpVerify = "No-Hassle Delivery + Assembly";
            Assert.assertEquals(LearnMorePopUp, PopUpVerify);
        }
    }
    @Then("User change qty from {int} to {int} in PLP quick view")
    public void user_change_qty_from_to_in_plp_quick_view(Integer int1, Integer int2) {
        if (ConfigReader.getProperty("platform").equals("desktop")) {
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//input[@name='plus']")).click();
        } else if (ConfigReader.getProperty("platform").equals("tablet")) {
//            BrowserUtils.scrollToElement(driver.findElement(By.xpath("//input[@name='plus']")));
            JavascriptExecutor Js1 = (JavascriptExecutor) driver;
            Js1.executeScript("window.scrollBy(0,400)");
            driver.findElement(By.xpath("//input[@name='plus']")).click();
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        }
    }
    @Then("User clicks x to exit quick view")
    public void user_clicks_x_to_exit_quick_view() {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            driver.findElement(By.xpath("//button[@title='Close']")).click();
        }
    }
}
