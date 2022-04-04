package com.apollo_automation.step_definitions;

import com.apollo_automation.pages.desktop_pages.DesktopLandingPage;
import com.apollo_automation.pages.desktop_pages.DesktopLoginPage;
import com.apollo_automation.pages.mobile_pages.MobileLandingPage;
import com.apollo_automation.utilities.BrowserUtils;
import com.apollo_automation.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Map;

public class LoginStepDefs {

    WebDriver driver = Driver.getDriver();
    DesktopLoginPage desktopLoginPage = new DesktopLoginPage();
    DesktopLandingPage desktopLandingPage = new DesktopLandingPage();
    MobileLandingPage mobileLandingPage = new MobileLandingPage();

    @Given("user is on landing page")
    public void landingPage(String link) {
        driver.get(link);
        BrowserUtils.waitForVisibility(desktopLandingPage.iframe, Duration.ofSeconds(15));
        desktopLandingPage.closeIframe();
    }

    @And("user clicks on login link on {string} page")
    public void clickOnLogin(String value) {
        if(value.equals("desktop")){
            desktopLandingPage.mainLoginLink.click();
            desktopLandingPage.mainLoginBtn.click();
        } else if (value.equals("mobile")){
            mobileLandingPage.mobileMenuClick();
            mobileLandingPage.mobileLoginBtn.click();
        }
    }

    @And("user enters username and password as below")
    public void userLogin(Map<String, String> loginInfo) {
        BrowserUtils.scrollToElement(desktopLoginPage.email);
        desktopLoginPage.email.sendKeys(loginInfo.get("username"));
        desktopLoginPage.password.sendKeys(loginInfo.get("password"));
        desktopLoginPage.loginBtn.click();
    }

    @Then("user should see user dashboard")
    public void verifyUserDashboard() {
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("account") ||
                driver.getTitle().contains("My Account"));
    }

}
