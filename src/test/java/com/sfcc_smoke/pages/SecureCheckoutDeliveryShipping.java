package com.sfcc_smoke.pages;

import com.sfcc_smoke.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureCheckoutDeliveryShipping {
    public SecureCheckoutDeliveryShipping() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id='shipping']")
    public WebElement ContinueBilling;
    @FindBy(xpath = "//div[@class='font-bold']")
    public WebElement TaxLabelSecureCheckOutShipping;
    @FindBy(xpath = "//input[@name='warehouse-zip']")
    public WebElement zipcodevalue;
    @FindBy(xpath = "//tr[@class='order-sales-tax ']/td/div/div[2]")
    public WebElement zipSecureCheckoutShipping;
    @FindBy(xpath = "//td[@class='order-sales-tax-value']")
    public WebElement taxValueSecureCheckoutShipping;
}
