package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.CartPage;
import com.sfcc_smoke.pages.HomePage;
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

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePageStepDefs {

    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    CartPage cartPage = new CartPage();

    @When("User gets each available link from main page")
    public void getAllUrls() {
        List<String> totalLinks = new ArrayList<>();
        List<WebElement> linkElements = homePage.allLinks;
        for (WebElement eachLink : linkElements) {
            totalLinks.add(eachLink.getText());
        }
        System.out.println("Total links available on the page: " + totalLinks.size() + "!");
    }

    @When("User hovers over each contentType items")
    public void hoverOnEachContentType() {
        WebElement temp;
        int num = 3;
        while (num <= 15) {
            num++;
            temp = Driver.getDriver().findElement(By.xpath("(//li[@data-container-level])[" + num + "]"));
            BrowserUtils.waitForClickability(temp, Duration.ofSeconds(10));
            BrowserUtils.hover(temp);
            BrowserUtils.sleep(1);
        }
    }

    @When("User clicks on the {string} link")
    public void clickOnLink(String furniture) {
        homePage.furniture.click();
        homePage.furniture.getText();
        Assert.assertTrue(driver.getCurrentUrl().endsWith(furniture + "/"));
    }

    @Then("User clicks on cart")
    public void user_clicks_on_cart() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='mini-cart-link']")).click();
    }
    @Then("User clicks on cart icon")
    public void user_clicks_on_cart_icon() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='mini-cart-link mini-cart-empty']")).click();
        JavascriptExecutor Js1 = (JavascriptExecutor) driver;
        Js1.executeScript("window.scrollBy(0,650)");
    }

    @Then("User asserts in search bar for search suggestions returns top results for {string}")
    public void user_asserts_in_search_bar_for_search_suggestions_returns_top_results_for(String Item) {
        String searchResults = homePage.searchSugesstions.getText();
        Assert.assertTrue(searchResults.contains(Item));
    }
    @When("User clicks on {string} in account tab")
    public void user_clicks_on_in_account_tab(String tabbedPage) {
        if (ConfigReader.getProperty("platform").equals("desktop")) {
            homePage.userNameDisplayed.click();
            driver.findElement(By.xpath("//a[@href='https://www.ashleyfurniture.com/" + tabbedPage + "/']")).click();
            BrowserUtils.waitForPageToLoad(2);
        }
        else if (ConfigReader.getProperty("platform").equals("mobile") || ConfigReader.getProperty("platform").equals("tablet")) {
            homePage.hamburgerBox.click();
            homePage.accountTabMobileView.click();
            homePage.accountTabOpenMobileView.click();
            homePage.accountWishListMobile.click();

        }
    }
    @Then("User verifies that {string} in Wish List is clickable with url text {string}")
    public void user_verifies_that_in_wish_list_is_clickable_with_url_text(String itemName, String urlName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String wishListItem = driver.findElement(By.xpath("//div /h2 /*[contains(@href, '"+urlName+"')]")).getAttribute("href");
        driver.findElement(By.xpath("//img[@alt='" + itemName + "']")).click();
        String Url = driver.getCurrentUrl();
        Assert.assertTrue(Url.contains(wishListItem));
    }

    @Then("User verify view details button for {string} in Wish list")
    public void user_verify_view_details_button_for_in_wish_list(String itemSaved) {
        String wishListViewDetails = driver.findElement(By.xpath("// h2 /*[contains(@title, 'Darcy Sofa')]")).getAttribute("href");
        driver.findElement(By.xpath("//h2 /a[@title='"+itemSaved+"']")).click();
        String Url = driver.getCurrentUrl();
        Assert.assertTrue(Url.contains(wishListViewDetails));
    }

    @Then("User clicks on remove button in Wish List for {string}")
    public void user_clicks_on_remove_button_in_wish_list_for(String removedItem) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//button[@aria-label='Remove "+removedItem+"']")).click();
    }
    @Then("User Asserts {string} is not in wishlist")
    public void user_asserts_is_not_in_wishlist(String AssertItemRemoved) {
        List<WebElement> items = driver.findElements(By.xpath("//div /h2 /*[contains(@href, '"+AssertItemRemoved+"')]"));
        Assert.assertTrue(items.isEmpty());
    }
}
