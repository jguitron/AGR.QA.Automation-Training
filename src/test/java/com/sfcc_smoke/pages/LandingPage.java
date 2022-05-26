package com.sfcc_smoke.pages;

import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;

public class LandingPage {
    public LandingPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    WebDriver driver = Driver.getDriver();

    @FindBy(xpath = "//iframe[contains(@id,'fcopt-offer')]")
    public WebElement iframe;
    @FindBy(css = "div[id='Close2-Item23']")
    public WebElement closeFrame;
    @FindBy(css = "button[class='offer-control close '] span")
    public WebElement closeFrameNew;
    @FindBy(css = "li[id='header-user-info']")
    public WebElement mainLoginLink;
    @FindBy(css = "a[class='redesign-button']")
    public WebElement mainLoginBtn;
    @FindBy(tagName = "header")
    public WebElement header;
    @FindBy(tagName = "footer")
    public WebElement footer;
    @FindBy(css = "span[class='hamburger-box']")
    public WebElement mobileMenu;
    @FindBy(xpath = "(//a[@class='user-account'])[2]")
    public WebElement mobileLoginBtn;
    public WebElement countryFlag;

    public void closeIframe() {
        String platform = ConfigReader.getProperty("platform");
        switch (platform) {
            case "desktop":
            case "tablet":
                driver.switchTo().frame(iframe);
                BrowserUtils.scrollToElement(closeFrame);
                closeFrame.click();
                driver.switchTo().defaultContent();
                BrowserUtils.waitForPageToLoad(1);
                break;
            case "mobile":
                BrowserUtils.sleep(5);
                try {
                    if (iframe.isDisplayed()) {
                        driver.navigate().refresh();
                    }
                } catch (Throwable exc) {
                    System.out.println("IFrame is not shown at headless mode!");
                }
                break;
        }
    }

//    public void closeIframenew() {
//        BrowserUtils.sleep(1);
//        driver.navigate().refresh();
//        driver.switchTo().frame(iframe);
//        BrowserUtils.scrollToElement(closeFrame);
//        closeFrame.click();
//        driver.switchTo().defaultContent();
//        BrowserUtils.waitForPageToLoad(1);
//    }

    public void verifyBrokenLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(2000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() > 400) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - Broken Link");
            } else {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            }
        } catch (Exception ex) {
        }
    }

    public void footerCategoryClick(String expectedCategory) {
        List<WebElement> categoryName = driver.findElements(By.xpath("//p[@class='flex-auto']"));
        for (WebElement each : categoryName) {
            if (each.getText().equalsIgnoreCase(expectedCategory)) {
                BrowserUtils.clickWithJS(each);
            }
        }
    }

    public void mobileMenuClick() {
        if (mobileMenu.isDisplayed()) {
            System.out.println("Mobile or Tablet view is open");
            try {
                mobileMenu.click();
            } catch (NoSuchElementException ex) {
                System.out.println("Mobile view is displayed, but couldn't click on Menu btn");
            }
        }
    }

}
