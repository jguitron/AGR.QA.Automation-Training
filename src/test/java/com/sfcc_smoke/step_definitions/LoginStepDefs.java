package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.AccountPage;
import com.sfcc_smoke.pages.LandingPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginStepDefs {

    WebDriver driver = Driver.getDriver();
    AccountPage accountPage = new AccountPage();
    LandingPage landingPage = new LandingPage();

    @Given("User navigates to {string}")
    public void navigateToURL(String urlValue) {
        if (!urlValue.equals("url")){
            driver.get(urlValue);

        } else {
            String url = System.getProperty("url", ConfigReader.getProperty("url"));
            driver.get(url);
        }
        try {
            BrowserUtils.waitForVisibility(landingPage.iframe, Duration.ofSeconds(5));
            landingPage.closeIframe();
        }catch (Throwable error){
            error.printStackTrace();
            System.out.println("Iframe was not shown!");
        }
    }

    @And("User clicks on login link on different viewports")
    public void clickOnLogin() {
            driver.findElement(By.xpath("content-asset ca-online-only")).click();
        String platform = ConfigReader.getProperty("platform");
        if (platform.equals("desktop")) {
            BrowserUtils.waitForClickability(landingPage.mainLoginLink, Duration.ofSeconds(10));
            landingPage.mainLoginBtn.click();
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            landingPage.mobileMenu.click();
            landingPage.mobileLoginBtn.click();
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
    public void user_logs_in_with_and_mobile_skip(String username, String password) {
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
