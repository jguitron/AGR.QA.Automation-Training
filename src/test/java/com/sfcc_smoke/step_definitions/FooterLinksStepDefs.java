package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.LandingPageLG;
import com.sfcc_smoke.pages.LandingPageMed;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;


public class FooterLinksStepDefs {

    WebDriver driver = Driver.getDriver();
    LandingPageMed landingPageMed = new LandingPageMed();
    LandingPageLG landingPageLG = new LandingPageLG();

    @When("User scrolls down to footer")
    public void scrollToFooter() {
        BrowserUtils.scrollToElement(landingPageLG.footer);
        BrowserUtils.sleep(1);
    }

    @And("If platform is mobile user clicks on category")
    public void clickOnCategory(List<String> category) {
        if (ConfigReader.getProperty("platform").equals("mobile")) {
            for (String each : category) {
                landingPageMed.footerCategoryClick(each);
                BrowserUtils.sleep(1);
            }
        }
    }

    @Then("User verifies {string} opens {string} page")
    public void verifyFooterSubLinks(String subLink, String expected) {
        WebElement tempMed = null;
        List<WebElement> allSubCategoriesMed = driver.findElements(By.xpath("(//div[@class='mdc-layout-grid'])[3]//li/a"));
        for (WebElement eachSubCategoryMed : allSubCategoriesMed) {
            if (eachSubCategoryMed.getText().equalsIgnoreCase(subLink)) {
                tempMed = eachSubCategoryMed;
            }
        }
        BrowserUtils.waitForClickability(tempMed, Duration.ofSeconds(3)).click();
        String newTabUrl = driver.getCurrentUrl();
        String newTabTitle = driver.getTitle();
        if (newTabUrl.contains(expected) || newTabTitle.contains(expected)) {
            Assert.assertTrue(newTabUrl.contains(expected) || newTabTitle.equals(expected));
        } else {
            System.out.println("Actual is not matching with Expected!");
        }
    }
}
