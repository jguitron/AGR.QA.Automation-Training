package com.sfcc_smoke.pages;

import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
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
    public WebElement countryFlag;

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

