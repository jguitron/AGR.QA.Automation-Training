package com.sfcc_smoke.pages;

import com.sfcc_smoke.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureCheckoutBilling {

    public SecureCheckoutBilling() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='checkout-menu-title'])[2]")
    public WebElement BP_subtitle;
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
    @FindBy(xpath = "(//img[@alt='Ashley Advantage'])[1]")
    public WebElement aalogoimg;
    @FindBy(xpath = "(//h1[@class='payment-method-title'])[2]")
    public WebElement aatitle;
    @FindBy(xpath = "//div[@class='cc-logos synchrony-logo']")
    public WebElement synchronylogo;
    @FindBy(xpath = "//div[@class='cc-logos genesis-logo']")
    public WebElement genesislogo;
    @FindBy(xpath = "//div[@class='cc-logos gafco-logo']")
    public WebElement gafcologo;
    @FindBy(xpath = "//label[@id='dwfrm_financeterms_cardnumber-label']")
    public WebElement label_aaNumber;
    @FindBy(xpath = "//div[@class='caddi-pay-logo-wrapper']/img")
    public WebElement caddipayLogo;
    @FindBy(xpath = "//div[@class='ashley-finance-logo-wrapper']/img")
    public WebElement acimaLogo;
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
    @FindBy(xpath = "(//iframe[@class='zoid-component-frame zoid-visible'])[1]")
    public WebElement pplogoimg;
    @FindBy(xpath = "(//div[@class='progressive-modal-box'])[2]/div[@class='content-asset ca-online-only']")
    public WebElement PrgsvPopupMsg;
    @FindBy(xpath = "(//div[@class='progressive-handy-box'])[2]/div[1]")
    public WebElement PrgsvPopupMsg_handy;
    @FindBy(xpath = "(//div[@class='progressive-handy-FPP-box'])[2]/div[1]")
    public WebElement PrgsvPopupMsg_FppHandy;
    @FindBy(xpath = "(//button[@class='primary-alt progressive-acceptance'])[2]")
    public WebElement PrgsvPopupContinueBtn;
    @FindBy(xpath = "(//button[@class='primary-alt progressive-FPP-handy-acceptance'])[2]")
    public WebElement PrgsvPopupContinueBtnFPPHandy;
    @FindBy(xpath = "(//button[@class='primary-alt progressive-handy-acceptance'])[2]")
    public WebElement PrgsvPopupContinueBtnHandy;
    @FindBy(xpath = "//div[@class='font-bold']")
    public WebElement TaxLabelSecureCheckOutBilling;
    @FindBy(xpath = "//td[@class='order-sales-tax-value']")
    public WebElement taxValueSecureCheckoutBilling;
    @FindBy(xpath = "//input[@name='warehouse-zip']")
    public WebElement zipcodevalueBilling;
    @FindBy(xpath = "//tr[@id='order-state-recycling-fee']/td[@class='font-bold']")
    public WebElement recycleFeeLabelBilling;
    @FindBy(xpath = "//tr[@id='order-state-recycling-fee']/td[2]")
    public WebElement recycleFeeValueBilling;
    @FindBy(xpath = "((//div[@class='button-wrap-modal'])[3]/button/div)[2]")
    public WebElement PrgsvPopupDiffPayMethodBtn;
    @FindBy(xpath = "//span[@class='ui-button-icon ui-icon ui-icon-closethick']")
    public WebElement PrgsvPopupCloseX;
}
