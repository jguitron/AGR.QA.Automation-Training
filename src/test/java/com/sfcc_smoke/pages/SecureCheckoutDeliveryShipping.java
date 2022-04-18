package com.sfcc_smoke.pages;

import com.sfcc_smoke.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureCheckoutDeliveryShipping {

    public SecureCheckoutDeliveryShipping(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //TODO Webelement - Continue to Billing and Payment
    @FindBy(xpath = "//button[@id='shipping']")
    public WebElement ContinueBilling;

}
