package com.ashley_ui.pages;

import com.ashley_ui.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureCheckoutBilling {

    public SecureCheckoutBilling(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Webelement Billint and payment subtitle
    @FindBy(xpath = "(//div[@class='checkout-menu-title'])[2]")
    public WebElement BP_subtitle;

    //Webelements - Credit card
    @FindBy(xpath = "//div[@class='creditcard-logo-container']")
    public WebElement cclogocontainer;
    @FindBy(xpath = "//div[@class='creditcard-logos']/img[1]")
    public WebElement cclogoimg1;
    @FindBy(xpath = "//div[@class='creditcard-logos']/img[2]")
    public WebElement cclogoimg2;
    @FindBy(xpath = "//label[@id='dwfrm_billing_paymentMethods_creditCard_owner-label']")
    public WebElement label_NameOnCard;
    @FindBy(xpath = "//label[@id='dwfrm_billing_paymentMethods_creditCard_number-label']")
    public WebElement label_CC_number;
    @FindBy(xpath = "//div[@class='expdatemonthfield']/label")
    public WebElement label_expdate;
    @FindBy(xpath = "//div[@class='form-row cvn required']/label")
    public WebElement label_cvv;


    //Webelements - Ashley Advantage
    @FindBy(xpath = "//img[@alt='Ashley Advantage']")
    public WebElement aalogoimg;
    @FindBy(xpath = "(//h1[@class='payment-method-title'])[2]")
    public  WebElement aatitle;
    //Webelements - AA logos
    @FindBy(xpath = "//div[@class='cc-logos synchrony-logo']")
    public WebElement synchronylogo;
    @FindBy(xpath = "//div[@class='cc-logos genesis-logo']")
    public WebElement genesislogo;
    @FindBy(xpath = "//div[@class='cc-logos gafco-logo']")
    public WebElement gafcologo;
    //Webelement lable AA Number
    @FindBy(xpath = "//label[@id='dwfrm_financeterms_cardnumber-label']")
    public WebElement label_aaNumber;


    //Webelement - Progressive Leasing
    @FindBy(xpath = "//img[@alt='Progressive Leasing']")
    public WebElement pllogoimg;

    @FindBy(xpath = "//div[@class='progressive-title-container']/h1")
    public WebElement pltitle;
    @FindBy(xpath = "//label[@id='dwfrm_financeterms_progressiveaccountnumber-label']")
    public WebElement lable_pl_ID;
    @FindBy(xpath = "//label[@id='dwfrm_financeterms_progressivelastfourdigitsofssn-label']")
    public WebElement lable_pl_SSN4;
    @FindBy(xpath = "//button[@id='view-progressive-offers']/span")
    public WebElement btn_pl_view_dtls;


    //Webelement - PayPal
    @FindBy(xpath = "//div[@class='payment-method-options paypal']/div/img")
    public WebElement pplogoimg;

    //WebElement Progressive pop up box
    @FindBy(xpath = "(//div[@class='progressive-modal-box'])[2]/div[@class='content-asset ca-online-only']")
    public WebElement PrgsvPopupMsg;
    @FindBy(xpath = "(//div[@class='progressive-handy-box'])[2]/div[1]")
    public WebElement PrgsvPopupMsg_handy;
    @FindBy(xpath = "((//div[@class='button-wrap-modal'])[3]/button/div)[1]")
    public WebElement PrgsvPopupContinueBtn;
    @FindBy(xpath = "((//div[@class='button-wrap-modal'])[3]/button/div)[2]")
    public WebElement PrgsvPopupDiffPayMethodBtn;
    @FindBy(xpath = "//span[@class='ui-button-icon ui-icon ui-icon-closethick']")
    public WebElement PrgsvPopupCloseX;

}
