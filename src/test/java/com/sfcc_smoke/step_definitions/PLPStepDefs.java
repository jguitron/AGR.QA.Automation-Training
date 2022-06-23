package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.ProductListPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class PLPStepDefs {
    WebDriver driver = Driver.getDriver();
    ProductListPage productListPage = new ProductListPage();

    @Given("User clicks on PLP Show {string} per page button")
    public void user_clicks_on_plp_show_per_page_button(String qtyShowPerPage) {
        if (ConfigReader.getProperty("platform").equals("desktop")) {
            driver.findElement(By.xpath("//select[@id='grid-paging-header'] /*[contains(@value,'"+qtyShowPerPage+"')]")).click();
        BrowserUtils.waitForPageToLoad(5);
        }
    }

    @When("User chooses {string} in plp")
    public void user_chooses_on_in_pdp(String itemName) {
            BrowserUtils.waitForPageToLoad(10);
            for (int i = 0; i < 100; i++) {
                if (driver.findElements(By.xpath("//img[@alt='" + itemName + "']")).isEmpty()) {
                    BrowserUtils.clickWithJS(productListPage.nextPageResults);
                }
            }
            BrowserUtils.clickWithJS(driver.findElement(By.xpath("//img[@alt='" + itemName + "']")));
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

    @Then("User clears all from filters")
    public void user_clears_all_from_filters() {
        productListPage.clearAllFilters.click();
    }

    @Then("User checks for {string} button is present")
    public void user_checks_for_button_is_present(String Learn) {
        BrowserUtils.scrollToElement(productListPage.heartIcon);
        BrowserUtils.clickWithJS(productListPage.learnHowButton);
        BrowserUtils.sleep(2);
        String learnHow = productListPage.asLowAsLearnMore.getText();
        Assert.assertEquals(learnHow, Learn);
    }

    @Then("User asserts {string} in learn how popup with {string}")
    public void user_asserts_in_learn_how_popup_with(String button, String Asserted) {
        String textOnScreen = driver.findElement(By.xpath("//a[@class='as-low-as-"+button+"-now as-low-as-learn-more ss-synch-set']")).getText();
        Assert.assertTrue(textOnScreen.contains(Asserted));
        BrowserUtils.clickWithJS(productListPage.learnHowButtonClose);
    }

    @Then("User asserts next button to {string} is {string}")
    public void user_asserts_next_button_to_is(String pageDesired, String pageNumber) {
        driver.findElement(By.xpath("//a[@class='"+pageDesired+"']")).click();
        BrowserUtils.sleep(2);
        String currentPage = productListPage.currentPageListQty.getText();
        Assert.assertTrue(pageNumber.contains(currentPage));
    }

    @Then("User clicks second page of inventory and asserts that {string} is {string}")
    public void user_clicks_second_page_of_inventory_and_asserts_that_is(String pageDesired, String pageNumber) {
        driver.findElement(By.xpath("//a[@class='"+pageDesired+"']")).click();
        BrowserUtils.sleep(2);
        String currentPage = productListPage.currentPageListQty.getText();
        productListPage.currentPageListQty.getText();
        Assert.assertTrue(pageNumber.contains(currentPage));
    }

    @Then("User clicks next button icon and lands user on page {string}")
    public void user_clicks_next_button_icon_and_lands_user_on_page(String pageDesired) {
        productListPage.nextPageResults.click();
        BrowserUtils.sleep(2);
        String currentPage = productListPage.currentPageListQty.getText();
        Assert.assertTrue(pageDesired.contains(currentPage));
    }

    @Then("User clicks on last page of inventory and asserts page")
    public void user_clicks_on_last_page_of_inventory_and_asserts_page() {
        productListPage.lastPageResults.click();
        BrowserUtils.sleep(2);
        if (driver.findElements(By.xpath("//a[@class='page-switcher page-last']")).isEmpty()) {
            System.out.println("Not present");
        }
    }
    @Then("User clicks on quick view in PLP")
    public void user_clicks_on_quick_view_in_plp() {
        if (ConfigReader.getProperty("platform").equals("desktop")) {
            BrowserUtils.scrollToElement(productListPage.quickViewHover);
            BrowserUtils.hover(productListPage.quickViewHover);
            productListPage.quickViewButton.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        } else if (ConfigReader.getProperty("platform").equals("tablet")) {
            JavascriptExecutor Js1 = (JavascriptExecutor) driver;
            Js1.executeScript("window.scrollBy(0,800)");
            BrowserUtils.hover(productListPage.quickViewHover);
            productListPage.quickViewButton.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        }
    }
    @Then("User clicks on arrows switching between products in PLP")
    public void user_clicks_on_arrows_switching_between_products_in_plp() {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            BrowserUtils.waitForClickability(productListPage.quickViewItem,Duration.ofSeconds(5));
            String item1 = productListPage.quickViewItem.getText();
            BrowserUtils.clickWithJS(productListPage.quickViewNext);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
            String item2 = productListPage.quickViewItem.getText();
            Assert.assertNotSame(item1, item2);
        }
    }
    @Then("User clicks on learn more and closes")
    public void user_clicks_on_learn_more_and_closes() {
        if (ConfigReader.getProperty("platform").equals("desktop")) {
            productListPage.learnMoreOpen.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
            String LearnMorePopUp =  productListPage.learnMorePopUpDeskTop.getText();
            String PopUpVerify = "Available Delivery Options";
            Assert.assertEquals(LearnMorePopUp, PopUpVerify);
            productListPage.learnMoreClose.click();
        } else if (ConfigReader.getProperty("platform").equals("tablet")) {
            productListPage.learnMoreOpen.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
            String LearnMorePopUp = productListPage.learnMorePopUp.getText();
            String PopUpVerify = "No-Hassle Delivery + Assembly";
            Assert.assertEquals(LearnMorePopUp, PopUpVerify);
        }
    }
    @Then("User change qty from {int} to {int} in PLP quick view")
    public void user_change_qty_from_to_in_plp_quick_view(Integer int1, Integer int2) {
        if (ConfigReader.getProperty("platform").equals("desktop")) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
            productListPage.quickViewIncreaseQty.click();
        } else if (ConfigReader.getProperty("platform").equals("tablet")) {
            JavascriptExecutor Js1 = (JavascriptExecutor) driver;
            Js1.executeScript("window.scrollBy(0,400)");
            productListPage.quickViewIncreaseQty.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        }
    }
    @Then("User clicks x to exit quick view")
    public void user_clicks_x_to_exit_quick_view() {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            if (productListPage.quickViewClose.isDisplayed()); {
                productListPage.quickViewClose.click();
            }

        } else System.out.println("Not in display");
    }
}
