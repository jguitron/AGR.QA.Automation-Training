package com.ashley_ui.pages;

import com.ashley_ui.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureCheckoutDeliveryShipping {

    public SecureCheckoutDeliveryShipping(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Webelement - Continue to Billing and Payment
    @FindBy(xpath = "//button[@id='shipping']")
    public WebElement ContinueBilling;

}
