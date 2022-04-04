package com.apollo_automation.pages.mobile_pages;

import com.apollo_automation.pages.desktop_pages.DesktopLoginPage;
import com.apollo_automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class MobileLandingPage {

    public MobileLandingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    DesktopLoginPage desktopLoginPage = new DesktopLoginPage();

    @FindBy(css = "span[class='hamburger-box']")
    public WebElement mobileMenu;
    @FindBy(xpath = "(//a[@class='user-account'])[2]")
    public WebElement mobileLoginBtn;


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
