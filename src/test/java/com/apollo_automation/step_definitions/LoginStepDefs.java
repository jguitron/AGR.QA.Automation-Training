package com.apollo_automation.step_definitions;

import com.apollo_automation.pages.desktop_pages.LandingPageLG;
import com.apollo_automation.pages.desktop_pages.LoginPageLG;
import com.apollo_automation.pages.mobile_pages.LandingPageMed;
import com.apollo_automation.utilities.BrowserUtils;
import com.apollo_automation.utilities.ConfigReader;
import com.apollo_automation.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class LoginStepDefs {

    WebDriver driver = Driver.getDriver();
    LoginPageLG loginPageLG = new LoginPageLG();
    LandingPageLG landingPageLG = new LandingPageLG();
    LandingPageMed landingPageMed = new LandingPageMed();

    @Given("user navigates to {string}")
    public void navigateToURL(String url) {
        driver.get(ConfigReader.getProperty(url));
        BrowserUtils.waitForPageToLoad(5);
    }

    @And("user clicks on login link on platform")
    public void clickOnLogin() {
        String platform = ConfigReader.getProperty("platform");
        if (platform.equals("desktop")) {
            landingPageLG.mainLoginLink.click();
            landingPageLG.mainLoginBtn.click();
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            landingPageMed.mobileMenu.click();
            landingPageMed.mobileLoginBtn.click();
        } else {
            landingPageLG.mainLoginLink.click();
            landingPageLG.mainLoginBtn.click();
        }
    }

    @And("user enters username and password as below")
    public void userLogin(Map<String, String> loginInfo) {
        loginPageLG.email.sendKeys(loginInfo.get("username"));
        loginPageLG.password.sendKeys(loginInfo.get("password"));
        loginPageLG.loginBtn.click();
    }

    @Then("user should see user dashboard")
    public void verifyUserDashboard() {
        System.out.println("Current title: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("account"));
    }
}
