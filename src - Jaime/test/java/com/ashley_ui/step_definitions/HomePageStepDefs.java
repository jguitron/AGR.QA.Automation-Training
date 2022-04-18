package com.ashley_ui.step_definitions;

import com.ashley_ui.pages.HomePage;
import com.ashley_ui.utilities.BrowserUtils;
import com.ashley_ui.utilities.ConfigurationReader;
import com.ashley_ui.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePageStepDefs {

    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();

    @Given("User is on AshleyFurniture's main home page")
    public void goToLandingPage() {
        String url = ConfigurationReader.getProperty("mainUrl");
        driver.get((url));
        BrowserUtils.waitForPageToLoad(2);
        String expectedTitle = "Ashley HomeStore | Home Furniture & Decor";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @When("User clicks on X-close button to close iframe popup")
    public void closeiFrame() {
        try {
            BrowserUtils.waitForVisibility(homePage.frameOne, Duration.ofSeconds(4));
            driver.switchTo().frame(homePage.frameOne);
            homePage.closeFrame.click();
            driver.switchTo().defaultContent();
        }
        catch (Throwable t){
            t.printStackTrace();
        }
    }

    @When("User gets each available link from main page")
    public void getAllUrls() {
        List<String> totalLinks = new ArrayList<>();
        List<WebElement> linkElements = homePage.allLinks;
        for (WebElement eachLink : linkElements) {
            totalLinks.add(eachLink.getText());
        }
            System.out.println("Total links available on the page: " + totalLinks.size() + "!");

    }

    @When("User hovers over each contentType items")
    public void hoverOnEachContentType() {
        WebElement temp;
        int num = 3;
        while (num <= 15){
            num++;
            temp = Driver.getDriver().findElement(By.xpath("(//li[@data-container-level])["+num+"]"));
            BrowserUtils.waitForClickability(temp, Duration.ofSeconds(10));
            BrowserUtils.hover(temp);
            BrowserUtils.sleep(1);
      }
    }

    @When("User clicks on the {string} link")
    public void clickOnLink(String furniture) {
        homePage.furniture.click();
        homePage.furniture.getText();
        Assert.assertTrue(driver.getCurrentUrl().endsWith(furniture+"/"));

    }
}
