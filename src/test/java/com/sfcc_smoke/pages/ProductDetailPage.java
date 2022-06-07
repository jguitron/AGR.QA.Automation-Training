package com.sfcc_smoke.pages;

import com.sfcc_smoke.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

    public ProductDetailPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@id='add-to-cart']")
    public WebElement addtocart;

    @FindBy(xpath ="//button[@id='add-to-cart-sticky']")
    public WebElement AddToCart_mob;

    @FindBy(xpath = "(//a[@class='button continue-shopping'])[3]")
    public WebElement contShoppingBtnAddItmPopUp;

    @FindBy(css ="div[class='cart-product-option-mobile'] a[class='save-item']")
    public WebElement SaveItemMobile;

    @FindBy(css ="div[class='cart-product-option-mobile'] a[class='save-item']")
    public WebElement SaveItem;

    @FindBy(id = "dwfrm_login_username")
    public WebElement EmailAddressLogin;

    @FindBy(id = "dwfrm_login_password")
    public WebElement PassWordLogin;

    @FindBy(css = "div[id='ui-id-3'] a[title=' Continue Shopping']")
    public WebElement continueShopping;

    @FindBy(xpath = "//div[@id='sticky-pdp-addtocart']/div/div/div/label[@class='plus']/input[@value='+']")
    public WebElement plusqty;

    @FindBy(xpath = "//div[@id='sticky-pdp-addtocart']/div/div/div/label[@class='minus']/input[@value='-']")
    public WebElement minusqty;

    @FindBy(xpath = "(//a[@class='swatchanchor king'])[1]")
    public WebElement iconkingsize;


    @FindBy(xpath = "//label[@for='pp-FURNPRO']")
    public WebElement pdp_FURNPRO;
    @FindBy(xpath = "//label[@for='pp-OUTDRF']")
    public  WebElement pdp_OUTDRF;
    @FindBy(xpath = "//label[@for='pp-ADJPRO']")
    public  WebElement pp_ADJPRO;
    @FindBy(xpath = "//div[@class='protection-plan-input-wrapper']/div/label")
    public  WebElement pp_KADJPRO;
    @FindBy(xpath = "//div[@class='protection-plan-input-wrapper']")
    public WebElement ppLableContainer;
}
