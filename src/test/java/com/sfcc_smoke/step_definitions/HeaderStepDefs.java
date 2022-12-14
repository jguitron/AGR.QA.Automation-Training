package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.HomePage;
import com.sfcc_smoke.pages.LandingPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HeaderStepDefs {

    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    LandingPage landingPage = new LandingPage();
    BaseStepDefs baseStepDefs = new BaseStepDefs();

    @Then("Assert user is logged in via name displays in header")
    public void assertUserIsLoggedInViaNameDisplaysInHeader() {
        if (ConfigReader.getProperty("platform").equals("desktop")) {
            BrowserUtils.sleep(3);
            String account = homePage.userNameDisplayed.getText();
            System.out.println(account);
            String expectedName = "Hi, Jaime";
            Assert.assertEquals(expectedName, account);
        } else {
            System.out.println("Does not apply to tablet and Mobile");
        }
    }

    @Then("User Hovers over header and clicks on {string} category")
    public void userHoversOverHeaderAndClicksOnCategory(String Category) {
        if (ConfigReader.getProperty("platform").equals("desktop")) {
            BrowserUtils.hover(driver.findElement(By.xpath("//a[@data-cgid='furniture']")));
            driver.findElement(By.xpath("//li[@class='key-accessible'] /a")).click();
        } else if (ConfigReader.getProperty("platform").equals("tablet") || ConfigReader.getProperty("platform").equals("mobile")) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
            if (landingPage.iframe.isDisplayed()) {
                landingPage.closeIframe();
            } else {
                BrowserUtils.clickWithJS(driver.findElement(By.xpath("//li /ul /li /*[contains(@href, '" + Category + "')]")));
            }
        }
    }

    @Then("Assert total number of items in mini cart is {int}")
    public void assertTotalNumberOfItemsInMiniCartIs(int expectedCartQty) {
        baseStepDefs.CartPageSize(expectedCartQty);
    }
}
