package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginHeartIconStepDefs {
    WebDriver driver = Driver.getDriver();

    @Then("Assert user is logged in via name displays in header")
    public void assert_user_is_logged_in_via_name_displays_in_header() {
        if (ConfigReader.getProperty("platform").equals("desktop")) {
            BrowserUtils.sleep(3);
            String account = driver.findElement(By.cssSelector("div[class='account-text-container'] div")).getText();
            System.out.println(account);
            String expectedName = "Hi, Jaime";
            Assert.assertEquals(expectedName, account);
        } if ((ConfigReader.getProperty("platform").equals("mobile")) || (ConfigReader.getProperty("platform").equals("tablet"))) {
            System.out.println("Does not apply to tablet and desktop");

        }

    }
}
