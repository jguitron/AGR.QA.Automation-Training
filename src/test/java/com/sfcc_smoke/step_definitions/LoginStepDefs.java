package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.LandingPageLG;
import com.sfcc_smoke.pages.AccountPage;
import com.sfcc_smoke.pages.LandingPageMed;
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
    LandingPageLG landingPageLG = new LandingPageLG();
    LandingPageMed landingPageMed = new LandingPageMed();

    @Given("User navigates to {string}")
    public void navigateToURL(String urlValue) {
        if (!urlValue.equals("url")){
            driver.get(urlValue);

        } else {
            String url = System.getProperty("url", ConfigReader.getProperty("url"));
            driver.get(url);
        }
        try {
            BrowserUtils.waitForVisibility(landingPageLG.iframe, Duration.ofSeconds(5));
            landingPageLG.closeIframenew();
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
            BrowserUtils.waitForClickability(landingPageLG.mainLoginLink, Duration.ofSeconds(10));
            landingPageLG.mainLoginBtn.click();
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            landingPageMed.mobileMenu.click();
            landingPageMed.mobileLoginBtn.click();
        } else {
            landingPageLG.mainLoginLink.click();
            landingPageLG.mainLoginBtn.click();
        }
    }

    @And("User logs in with {string} and {string}")
    public void userLogin(String username, String password) {
        accountPage.login(username, password);
    }

    @Then("User should see user dashboard")
    public void verifyUserDashboard() {
        System.out.println("Current title: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("account"));
    }
}
