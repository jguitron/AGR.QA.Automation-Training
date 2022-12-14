package com.sfcc_smoke.pages;

import com.sfcc_smoke.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureCheckoutDeliveryCustInfo {
    public SecureCheckoutDeliveryCustInfo() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_firstName']")
    public WebElement fname;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_lastName']")
    public WebElement lname;
    @FindBy(xpath = "//input[@class='input-text address-valid po-box-invalid  required']")
    public WebElement addresstextbox;
    @FindBy(xpath = "//a[@class='address-option ']")
    public WebElement addressOptions;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_address1']")
    public WebElement address1;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_address2']")
    public WebElement address2;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_city']")
    public WebElement city;
    @FindBy(xpath = "//select[@id='dwfrm_singleshipping_shippingAddress_addressFields_states_state']")
    public WebElement state;
    @FindBy(xpath = "//div[@class='label-sales-tax']/input[@name='warehouse-zip']")
    public WebElement zip;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_phone']")
    public WebElement customerphone;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_email_emailAddress']")
    public WebElement customeremail;
    @FindBy(xpath = "//button[@class='continue']")
    public WebElement contAsGuest;
    @FindBy(xpath = "//div[@class='oldAddress']/form/button[@class='submit-button']")
    public WebElement useoriginal;
    @FindBy(xpath = "//div[@class='font-bold']")
    public WebElement taxLableSecureChkoutCustInfo;
    @FindBy(xpath = "//td[@class='order-sales-tax-value']")
    public WebElement taxValueSecureChkoutCustInfo;
}
