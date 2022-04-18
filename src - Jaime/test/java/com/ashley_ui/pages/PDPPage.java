package com.ashley_ui.pages;

import com.ashley_ui.utilities.Driver;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PDPPage {
    public PDPPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath ="//button[@id='add-to-cart-sticky']")
    public WebElement AddToCart;

    @FindBy(css ="xpath//a[@class='mini-cart-link']")
    public WebElement Cart;

    @FindBy(css ="div[class='cart-product-option-mobile'] a[class='save-item']")
    public WebElement SaveItem;

    @FindBy(id = "dwfrm_login_username")
    public WebElement EmailAddressLogin;

    @FindBy(id = "dwfrm_login_password")
    public WebElement PassWordLogin;

    @FindBy(css = "div[id='ui-id-3'] a[title=' Continue Shopping']")
    public WebElement ContinueShopping;
}
