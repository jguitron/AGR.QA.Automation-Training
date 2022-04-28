package com.sfcc_smoke.pages;

import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.net.HttpURLConnection;
import java.net.URL;

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

    @FindBy(tagName = "header")
    public WebElement header;

    @FindBy(tagName = "footer")
    public WebElement footer;


    public void closeIframe() {
        driver.switchTo().frame(iframe);
        BrowserUtils.clickWithJS(closeFrame);
        driver.switchTo().defaultContent();

    }

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
}
