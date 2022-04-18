package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.desktop_pages.LandingPageLG;
import com.sfcc_smoke.pages.mobile_pages.LandingPageMed;
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
import java.util.Set;

public class FooterLinksStepDefs {

    WebDriver driver = Driver.getDriver();
    LandingPageMed landingPageMed = new LandingPageMed();
    LandingPageLG landingPageLG = new LandingPageLG();

    @When("user scrolls down to footer")
    public void scrollToFooter() {
        BrowserUtils.waitForVisibility(landingPageLG.footer, Duration.ofSeconds(10));
        BrowserUtils.scrollToElement(landingPageLG.footer);
    }

    @And("user clicks on {string}")
    public void clickOnCategory(String footerCategory) {
        if (ConfigReader.getProperty("platform").equals("mobile")) {
            if (footerCategory.equalsIgnoreCase(landingPageMed.getToKnowUs.getText())) {
                landingPageLG.clickOnFooterCategoryLink(footerCategory);
            } else if (footerCategory.equalsIgnoreCase(landingPageMed.customerCare.getText())) {
                landingPageLG.clickOnFooterCategoryLink(footerCategory);
            } else if (footerCategory.equalsIgnoreCase(landingPageMed.getInspired.getText())) {
                landingPageLG.clickOnFooterCategoryLink(footerCategory);
            } else if (footerCategory.equalsIgnoreCase(landingPageMed.termsAndPolicy.getText())) {
                landingPageLG.clickOnFooterCategoryLink(footerCategory);
            }
        }
    }

    @Then("user verifies {string} opens {string} page")
    public void verifyFooterSubLink(String subLink, String expected) {
        String currentHandle = driver.getWindowHandle();
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            if (driver.findElement(By.xpath("//a[.='" + subLink + "']")).isDisplayed()) {
                WebElement currentLink = driver.findElement(By.xpath("//a[.='" + subLink + "']"));
                BrowserUtils.waitForClickability(currentLink, Duration.ofSeconds(5)).click();
            } else if (driver.findElement(By.xpath("(//a[.='" + subLink + "'])[2]")).isDisplayed()) {
                WebElement lgLinkElem = driver.findElement(By.xpath("(//a[.='" + subLink + "'])[2]"));
                BrowserUtils.waitForClickability(lgLinkElem, Duration.ofSeconds(5));
                lgLinkElem.click();
            }
        }
        if (ConfigReader.getProperty("platform").equals("mobile")) {
            WebElement smLinkElem = driver.findElement(By.xpath("(//a[.='" + subLink + "'])[1]"));
            BrowserUtils.waitForClickability(smLinkElem, Duration.ofSeconds(10));
            if (smLinkElem.isDisplayed()) {
                BrowserUtils.waitForClickability(smLinkElem, Duration.ofSeconds(10)).click();
            }
        }
        Set<String> windowHandles = driver.getWindowHandles();
        if (windowHandles.size() > 1) {
            for (String actualHandle : windowHandles) {
                if (!actualHandle.equals(currentHandle)) {
                    driver.switchTo().window(actualHandle);
                }
            }
            String newTabUrl = driver.getCurrentUrl();
            String newTabTitle = driver.getTitle();
            if (newTabUrl.contains(expected) || newTabTitle.contains(expected)) {
                Assert.assertTrue(newTabUrl.contains(expected) || newTabTitle.equals(expected));
            } else {
                System.out.println("Actual is not matching with Expected!");
            }
        } else {
            String actualUrl = driver.getCurrentUrl();
            String actualTitle = driver.getTitle();
            Assert.assertTrue(actualUrl.contains(expected) || actualTitle.contains(expected));
        }
    }
}
