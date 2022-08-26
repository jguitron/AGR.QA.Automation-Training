package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.AccountPage;
import com.sfcc_smoke.pages.LandingPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.BstackUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginStepDefs {

    WebDriver driver = Driver.getDriver();
    AccountPage accountPage = new AccountPage();
    LandingPage landingPage = new LandingPage();

    @Given("User navigates to {string}")
    public void navigateToURL(String url) {
        if (!url.equals("url")) {
            driver.get(url);
        } else if (url.equals("url")) {
            if (ConfigReader.getProperty("url").contains("staging")) {
                driver.get("https://storefront:afweb2017@staging.ashleyfurniture.com/");
//                driver.findElement(By.xpath("//button[@id='details-button']")).click();
//                driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
            } else if (ConfigReader.getProperty("url").contains("development")) {
                driver.get("https://storefront:afweb2017@development.ashleyfurniture.com/");
            } else {
                String actualUrl = System.getProperty("url", ConfigReader.getProperty("url"));
                driver.get(actualUrl);
            }
        }
        BrowserUtils.waitForPageToLoad(5);
        if (ConfigReader.getProperty("browser").contains("bstack")) {
            BstackUtils.initialLocationHandler();
        }
        try {
            BrowserUtils.waitForVisibility(landingPage.iframe, Duration.ofSeconds(10));
            landingPage.closeIframe();
        } catch (Throwable error) {
            error.printStackTrace();
            System.out.println("Iframe was not shown!");
        }
    }

    @And("User clicks on login link on different viewports")
    public void clickOnLogin() {
        String platform = ConfigReader.getProperty("platform");
        if (platform.equals("desktop")) {
            BrowserUtils.waitForClickability(landingPage.mainLoginLink, Duration.ofSeconds(10));
            BrowserUtils.clickWithJS(landingPage.mainLoginLink);
            BrowserUtils.clickWithJS(landingPage.mainLoginBtn);
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            BrowserUtils.clickWithJS(landingPage.mobileMenu);
            BrowserUtils.clickWithJS(landingPage.mobileLoginBtn);
        } else {
            landingPage.mainLoginLink.click();
            landingPage.mainLoginBtn.click();
        }
    }

    @And("User logs in with {string} and {string}")
    public void userLogin(String username, String password) {
        accountPage.login(username, password);
    }

    @Then("User logs in with {string} and {string} mobile skip")
    public void userLogsInWithAndMobileSkip(String username, String password) {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            accountPage.login(username, password);
        }
    }

    @Then("User should see user dashboard")
    public void verifyUserDashboard() {
        System.out.println("Current title: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("account"));
    }
}
