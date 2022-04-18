package com.ashley_ui.pages;

import com.ashley_ui.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//button[@name='dwfrm_login_register'])[2]")
    public WebElement createAccount;

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_firstname']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_lastname']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_emailconfirm']")
    public WebElement confEmail;

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_phoneMobile']")
    public WebElement phone;

    @FindBy(css = "input[id='dwfrm_profile_customer_phoneHome']")
    public WebElement altPhone;

    @FindBy(xpath = "//input[@id='dwfrm_profile_login_password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='dwfrm_profile_login_passwordconfirm']")
    public WebElement confPassword;

    @FindBy(xpath = "//label[@id='dwfrm_profile_customer_ageconsent-label']")
    public WebElement verifyAge;

    @FindBy(css = "button[name='dwfrm_profile_confirm']")
    public WebElement submitForm;

    @FindBy(xpath = "//div[.='Hi, Kalla']")
    public WebElement userName;

    @FindBy(xpath = "//div[@class='start-shopping']")
    public WebElement startShop;




}
