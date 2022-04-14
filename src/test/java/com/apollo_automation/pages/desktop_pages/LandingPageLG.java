package com.apollo_automation.pages.desktop_pages;

import com.apollo_automation.utilities.BrowserUtils;
import com.apollo_automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class LandingPageLG {
    public LandingPageLG() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    WebDriver driver = Driver.getDriver();

    @FindBy(xpath = "//iframe[contains(@id,'fcopt-offer')]")
    public WebElement iframe;

    @FindBy(css = "div[id='Close2-Item23']")
    public WebElement closeFrame;

    @FindBy(css = "li[id='header-user-info']")
    public WebElement mainLoginLink;

    @FindBy(css = "a[class='redesign-button']")
    public WebElement mainLoginBtn;

    @FindBy(css = "div[class='flex md:flex']")
    public WebElement topAshleyBtn;

    @FindBy(css = "footer[class^='flex flex-col justify-center']")
    public WebElement footer;


    public void closeIframe() {
        try {
            driver.switchTo().frame(iframe);
            closeFrame.click();
            driver.switchTo().defaultContent();
        } catch (NoSuchElementException ex) {
            System.out.println("Iframe is not displayed");
        }
    }

    public void clickOnFooterCategoryLink(String categoryLink) {
        List<WebElement> footerCategoryLinks = driver.findElements(By.xpath("//p[@class='flex-auto']"));
        for (WebElement singleCategory : footerCategoryLinks) {
            String actualCategory = singleCategory.getText();
            if (actualCategory.equals(categoryLink)) {
                BrowserUtils.waitForClickability(singleCategory, Duration.ofSeconds(5)).click();
                break;
            } else {
                System.out.println("Actual footer Category Name is not equal to expected!");
            }
        }
    }

    public void verifyBrokenLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() > 400) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - Broken Link");
            } else {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            }
        } catch (Exception ex) {
        }
    }
}
