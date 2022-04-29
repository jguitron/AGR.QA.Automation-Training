package com.sfcc_smoke.pages;

import com.sfcc_smoke.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//tr[@class='protection-plan'][1]")
    public WebElement pplink1;

    @FindBy(xpath = "//tr[@class='protection-plan'][2]")
    public WebElement pplink2;

    @FindBy(xpath = "//tr[@class='protection-plan'][3]")
    public WebElement pplink3;

    @FindBy(xpath = "//tr[@class='protection-plan'][4]")
    public WebElement pplink4;

    @FindBy(className = "js-local-pricing-link")
    public WebElement cartzipcodelink;

    @FindBy(xpath = "//div[@class='field-wrapper']/input[@class='input-text numbers-hypen-only postal required']")
    public WebElement popupzipcode;

    @FindBy(xpath = "//input[@class='pp-checkbox']")
    public WebElement pp_checkbox;
    @FindBy(xpath = "//label[@class='add-pp']")
    public WebElement pp_checkbox_cont;

    @FindBy(xpath = "//label[@class='add-handySwitch']")
    public WebElement handy_checkbox;

    @FindBy(xpath = "//div[@class='fpp-off']")
    public WebElement nofpp;

    @FindBy(xpath = "(//div[@class='protection-plan-label'])[1]")
    public WebElement PPlabel1;
    @FindBy(xpath = "(//div[@class='protection-plan-label'])[2]")
    public WebElement PPlabel2;
    @FindBy(xpath = "(//div[@class='protection-plan-label'])[3]")
    public WebElement PPlabel3;
    @FindBy(xpath = "(//div[@class='protection-plan-label'])[4]")
    public WebElement PPlabel4;
    @FindBy(xpath = "(//input[@class='pp-checkbox'])[1]")
    public WebElement ppckbx1;
    @FindBy(xpath = "(//input[@class='pp-checkbox'])[2]")
    public WebElement ppckbx2;
    @FindBy(xpath = "(//input[@class='pp-checkbox'])[3]")
    public WebElement ppckbx3;
    @FindBy(xpath = "(//input[@class='pp-checkbox'])[4]")
    public WebElement ppckbx4;

    @FindBy(xpath = "//button[@class='secure-checkout-btn']")
    public WebElement secureckoutbtn;

    @FindBy(xpath = "//a[@class='remove-cart-item']")
    public WebElement removeitem;

    @FindBy(xpath = "//div[@id='cart-remove-product']/fieldset/h2")
    public WebElement removeitempopup_msg;

    @FindBy(xpath = "//button[@class='remove']")
    public WebElement removeitem_YesBtn;

    @FindBy(css = "div[class='cart-product-option-mobile'] a[class='remove-cart-item']")
    public WebElement removeItem_BtnMobileTablet;

    @FindBy(xpath = "//table[@class='order-totals-table']/tbody/tr[@id='order-state-recycling-fee']/td")
    public WebElement recycleFee_cart;

    @FindBy(xpath = "//button[@class='save-item']")
    public WebElement saveItem;

    @FindBy(xpath = "(//span[@class='ui-button-icon ui-icon ui-icon-closethick'])[2]")
    public WebElement mobAddedToCartPopUpCloseX;
    @FindBy(xpath = "(//a[@class='button continue-shopping'])[3]")
    public WebElement mobAddedToCartPopUpContShoppingBtn;
}
