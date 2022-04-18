package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.desktop_pages.LandingPageLG;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrokenLinksStepDefs {
    LandingPageLG landingPageLG = new LandingPageLG();

    @Then("user clicks on each link on page to verify")
    public void user_clicks_on_each_link_on_page() {
        List<WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));
        System.out.println("Number of links: " + allLinks.size());
        for (WebElement temp : allLinks) {
            String validUrl = temp.getAttribute("href");
            landingPageLG.verifyBrokenLinks(validUrl);
        }
    }
}
