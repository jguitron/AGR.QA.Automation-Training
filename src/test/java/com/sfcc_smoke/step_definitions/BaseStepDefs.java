package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.BasePage;
import com.sfcc_smoke.pages.LandingPage;
import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.pages.SearchPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import com.sun.java.swing.plaf.windows.resources.windows;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import javax.sound.midi.Soundbank;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BaseStepDefs {

    WebDriver driver = Driver.getDriver();
    BasePage basePage = new BasePage();
    SearchPage searchPage = new SearchPage();
    LandingPage landingPage = new LandingPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();

    @When("User finds closest store by {string}")
    public void user_set_the_closet_store_by(String zipcode) {
        String platform = ConfigReader.getProperty("platform");
        BrowserUtils.waitForPageToLoad(10);
        if (platform.equals("desktop")) {
            BrowserUtils.waitForVisibility(basePage.chooseLocalStore, Duration.ofSeconds(5));
            BrowserUtils.clickWithJS(basePage.chooseLocalStore);
            BrowserUtils.waitForVisibility(basePage.zipCodeBox, Duration.ofSeconds(5));
            basePage.zipCodeBox.sendKeys(zipcode + Keys.ENTER);
            BrowserUtils.sleep(2);
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            BrowserUtils.waitForVisibility(landingPage.mobileMenu, Duration.ofSeconds(5));
            BrowserUtils.clickWithJS(landingPage.mobileMenu);
            BrowserUtils.waitForVisibility(basePage.mobStoreLink, Duration.ofSeconds(5));
            BrowserUtils.clickWithJS(basePage.mobStoreLink);
            BrowserUtils.waitForVisibility(basePage.zipCodeBox, Duration.ofSeconds(5));
            basePage.zipCodeBox.sendKeys(zipcode + Keys.ENTER);
            BrowserUtils.sleep(2);
        }
    }

    @When("User searches for SKU {string} and clicks on it")
    public void serachitem(String Item) {
        BrowserUtils.sleep(3);
        basePage.searchBar.sendKeys(Item + Keys.ENTER);
    }

    @When("User search for a SKU {string} and clicks on item 1 in result set")
    public void serachitem_result1(String Item) {
        BrowserUtils.waitForVisibility(basePage.searchBar, Duration.ofSeconds(5));
        basePage.searchBar.sendKeys(Item);
        basePage.searchBarResultOne.click();
    }

    @When("User navigate to cart page")
    public void clickonminicart() {
        BrowserUtils.waitForVisibility(basePage.miniCartIcon, Duration.ofSeconds(5));
        basePage.miniCartIcon.click();
    }

    @When("User navigate back to cart page")
    public void clickonbacktocart() {
        BrowserUtils.waitForVisibility(basePage.backToCartIcon, Duration.ofSeconds(5));
        basePage.backToCartIcon.click();
    }

    @When("User verifies that Paypal login page is launched")
    public void getpagetitle() {
        Assert.assertEquals("Log in to your PayPal account", driver.getTitle());

    }

    @When("User verifies that Caddipay page is launched")
    public void getpagetitle_caddipay() {
        BrowserUtils.waitForPageToLoad(5);
        Set<String> windows = driver.getWindowHandles();
        System.out.println("All windows: " +windows);
        BrowserUtils.sleep(3);
        String currentwindow = driver.getWindowHandle();
        System.out.println("current window is: "+currentwindow);
        System.out.println("current window title is: "+driver.getTitle());
        System.out.println("------------------Test1-----------------");
        BrowserUtils.sleep(3);


        for(String each : windows){
            driver.switchTo().window(each);
        }

        System.out.println("current window after switching: "+driver.getWindowHandle());
        Assert.assertEquals("Caddipay", driver.getTitle());
    }

    @When("User closes Caddipay window by clicking on X")
    public void close_caddipay() {

        BrowserUtils.sleep(2);
        System.out.println("Current active window: " +driver.getTitle());
        basePage.caddipayPhonenbr.sendKeys("6123513393");
        BrowserUtils.sleep(2);
        System.out.println("Phone number entered!");
        System.out.println(basePage.closeCaddipayX.isDisplayed());
        basePage.closeCaddipayX.click();
        BrowserUtils.sleep(2);



        System.out.println(driver.getTitle());
        System.out.println("Test3");
    }

    @Then("User clicks search icon")
    public void user_clicks_search_icon() {
        searchPage.searchIcon.click();
    }


    @Then("User clicks on Heart Icon in plp")
    public void user_clicks_on_heart_icon_in_plp() {
        BrowserUtils.hover(productDetailPage.addToWishList);
        productDetailPage.addToWishList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
}
