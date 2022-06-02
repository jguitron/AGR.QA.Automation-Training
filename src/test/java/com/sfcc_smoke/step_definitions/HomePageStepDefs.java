package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.HomePage;
import com.sfcc_smoke.pages.SearchPage;
import com.sfcc_smoke.utilities.BrowserUtils;
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
    SearchPage searchPage = new SearchPage();

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
      String searchResults = driver.findElement(By.xpath("//li[@class='unbxd-as-header unbxd-as-popular-product-header'] /strong")).getText();
      Assert.assertTrue(searchResults.contains(Item));
    }
}
