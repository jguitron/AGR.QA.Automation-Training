package com.sfcc_smoke.pages.mobile_pages;

import com.sfcc_smoke.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class LandingPageMed {

    WebDriver driver = Driver.getDriver();

    public LandingPageMed() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[class='hamburger-box']")
    public WebElement mobileMenu;
    @FindBy(xpath = "(//a[@class='user-account'])[2]")
    public WebElement mobileLoginBtn;
    @FindBy(xpath = "(//p[@class='flex-auto'])[1]")
    public WebElement getToKnowUs;
    @FindBy(xpath = "(//p[@class='flex-auto'])[2]")
    public WebElement customerCare;
    @FindBy(xpath = "(//p[@class='flex-auto'])[3]")
    public WebElement getInspired;
    @FindBy(xpath = "(//p[@class='flex-auto'])[4]")
    public WebElement termsAndPolicy;
    @FindBy(xpath = "(//span[@class='font-bold underline'])[4]")
    public WebElement countryFlag;


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
