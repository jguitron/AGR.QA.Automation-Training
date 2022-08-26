package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.BasePage;
import com.sfcc_smoke.pages.LandingPage;
import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.pages.SearchPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class BaseStepDefs {

    static WebDriver driver = Driver.getDriver();
    BasePage basePage = new BasePage();
    SearchPage searchPage = new SearchPage();
    LandingPage landingPage = new LandingPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    String mainWindowHandle;

    @When("User finds closest store by {string}")
    public void findClosestStore(String zipcode) {
        String platform = ConfigReader.getProperty("platform");
        BrowserUtils.waitForPageToLoad(5);
        if (platform.equals("desktop")) {
            BrowserUtils.waitForVisibility(basePage.chooseLocalStore, Duration.ofSeconds(5)).click();
            basePage.zipCodeBox.sendKeys(zipcode + Keys.ENTER);
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            BrowserUtils.waitForVisibility(landingPage.mobileMenu, Duration.ofSeconds(5)).click();
            BrowserUtils.waitForVisibility(basePage.mobStoreLink, Duration.ofSeconds(5)).click();
            BrowserUtils.waitForVisibility(basePage.zipCodeBox, Duration.ofSeconds(5));
            basePage.zipCodeBox.sendKeys(zipcode + Keys.ENTER);
        }
    }

    @When("User searches for SKU {string}")
    public void searchAnItem(String item) {
        BrowserUtils.sleep(1);
        basePage.searchBar.sendKeys(item + Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains(item));
    }

    @When("User search for a SKU {string} and clicks on item 1 in result set")
    public void SearchItemResult1(String Item) {
        BrowserUtils.waitForVisibility(basePage.searchBar, Duration.ofSeconds(5));
        basePage.searchBar.sendKeys(Item);
        basePage.searchBarResultOne.click();
    }

    @When("User navigates to cart page")
    public void clickOnMiniCart() {
        BrowserUtils.waitForVisibility(basePage.miniCartIcon, Duration.ofSeconds(5)).click();
    }

    @When("User navigate back to cart page")
    public void clickOnBackToCart() {
        BrowserUtils.waitForVisibility(basePage.backToCartIcon, Duration.ofSeconds(5));
        basePage.backToCartIcon.click();
    }

    @When("User verifies that Caddipay page is launched then close the window")
    public void verifyCaddipayWindow() {
        BrowserUtils.sleep(3);
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> iterator = allWindows.iterator();

        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                Assert.assertEquals("Caddipay", driver.getTitle());
            }
        }
        basePage.closeCaddipayX.click();
        BrowserUtils.sleep(1);
        driver.switchTo().window(mainWindowHandle);
    }

    @When("User closes Caddipay window by clicking on X")
    public void closeCaddipayWindow() {
        basePage.closeCaddipayX.click();
        BrowserUtils.sleep(2);
        System.out.println(mainWindowHandle);
    }

    @Then("User clicks search icon")
    public void clickOnSearchIcon() {
        searchPage.searchIcon.click();
    }


    @Then("User clicks on Heart Icon in plp")
    public void clickOnHeartIconInPLP() {
        BrowserUtils.hover(productDetailPage.addToWishList);
        productDetailPage.addToWishList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void CartPageSize(int expectedNum) {
        int actualCartQty = Integer.parseInt(basePage.miniCartValue.getText());
        Assert.assertEquals(expectedNum, actualCartQty);
    }
}