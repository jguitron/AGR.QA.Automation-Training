package com.apollo_automation.pages;

import com.ashley_ui.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureCheckoutDeliveryCustInfo {
    public SecureCheckoutDeliveryCustInfo(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Webelements - Customer info fields
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_firstName']")
    public WebElement fname;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_lastName']")
    public WebElement lname;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_address1']")
    public WebElement address1;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_address2']")
    public WebElement address2;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_city']")
    public WebElement city;
    @FindBy(xpath = "//select[@id='dwfrm_singleshipping_shippingAddress_addressFields_states_state']")
    public WebElement state;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_postal']")
    public WebElement zip;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_phone']")
    public WebElement customerphone;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_email_emailAddress']")
    public WebElement customeremail;

    //Webelement Continue as Guest button
    @FindBy(xpath = "//button[@class='continue']")
    public WebElement contAsGuest;

    //Webelement : Popup | Use Original button
    @FindBy(xpath = "//div[@class='oldAddress']/form/button[@class='submit-button']")
    public  WebElement useoriginal;
}
