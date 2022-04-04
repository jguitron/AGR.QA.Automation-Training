package com.apollo_automation.pages.desktop_pages;

import com.apollo_automation.utilities.BrowserUtils;
import com.apollo_automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.NoSuchElementException;

public class DesktopLandingPage {

    public DesktopLandingPage(){
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


    public void closeIframe() {
        BrowserUtils.waitForPageToLoad(3);
        if (iframe.isDisplayed()) {
            driver.switchTo().frame(iframe);
            try {
                closeFrame.click();
                driver.switchTo().defaultContent();
            } catch (NoSuchElementException ex) {
                System.out.println("iframe is displayed, but couldn't click on X to close");
            }
        }
    }

}
