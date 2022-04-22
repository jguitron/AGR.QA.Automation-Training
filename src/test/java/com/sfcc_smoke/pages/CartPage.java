package com.sfcc_smoke.pages;

import com.sfcc_smoke.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Webelement - Protection plan link 1 on Cart
    @FindBy(xpath = "//tr[@class='protection-plan'][1]")
    public WebElement pplink1;

    //Webelement - Protection plan link 2 on Cart
    @FindBy(xpath = "//tr[@class='protection-plan'][2]")
    public WebElement pplink2;

    //Webelement - Protection plan link 3 on Cart
    @FindBy(xpath = "//tr[@class='protection-plan'][3]")
    public WebElement pplink3;

    //Webelement - Protection plan link 4 on Cart
    @FindBy(xpath = "//tr[@class='protection-plan'][4]")
    public WebElement pplink4;

    //Webelement - ZipCode link on Cart
    @FindBy(className = "js-local-pricing-link")
    public WebElement cartzipcodelink;

    //Webelement - ZipCode popup on Cart
    @FindBy(xpath = "//div[@class='field-wrapper']/input[@class='input-text numbers-hypen-only postal required']")
    public WebElement popupzipcode;

    //Webelement - Protection plan checkbox
    @FindBy(xpath = "//input[@class='pp-checkbox']")
    public WebElement pp_checkbox;
    @FindBy(xpath = "//label[@class='add-pp']")
    public WebElement pp_checkbox_cont;

    //Webelement - Handy Item checkbox
   // @FindBy(xpath = "//input[@class='switch handySwitch']")
    @FindBy(xpath = "//label[@class='add-handySwitch']")
    public WebElement handy_checkbox;

    //Webelement - Protection plan unavailable message
    @FindBy(xpath = "//div[@class='fpp-off']")
    public WebElement nofpp;

    //Webelement - Protection plan available to select

    @FindBy(xpath = "(//div[@class='protection-plan-label'])[1]")
    public WebElement PPlabel1;
    @FindBy(xpath = "(//div[@class='protection-plan-label'])[2]")
    public WebElement PPlabel2;
    @FindBy(xpath = "(//div[@class='protection-plan-label'])[3]")
    public WebElement PPlabel3;
    @FindBy(xpath = "(//div[@class='protection-plan-label'])[4]")
    public WebElement PPlabel4;

    /*
    public WebElement PPlabelElem(){
        WebDriver driver = Driver.getDriver();
        WebElement PPlabel = null;
        for (int i = 1; i <= 4; i++) {
            PPlabel = driver.findElement(By.xpath("(//div[@class='protection-plan-label'])["+i+"]"));
            System.out.println(PPlabel.getText());
        }
        return PPlabel;
    } */

    //Webelement - Protection plan checkbox
    @FindBy(xpath = "(//input[@class='pp-checkbox'])[1]")
    public WebElement ppckbx1;
    @FindBy(xpath = "(//input[@class='pp-checkbox'])[2]")
    public WebElement ppckbx2;
    @FindBy(xpath = "(//input[@class='pp-checkbox'])[3]")
    public WebElement ppckbx3;
    @FindBy(xpath = "(//input[@class='pp-checkbox'])[4]")
    public WebElement ppckbx4;

    //Webelement - Secure checkout button
    @FindBy(xpath = "//button[@class='secure-checkout-btn']")
    public WebElement secureckoutbtn;


    //Webelement Remove Item
    @FindBy(xpath = "//a[@class='remove-cart-item']")
    public WebElement removeitem;

    @FindBy(xpath = "//div[@id='cart-remove-product']/fieldset/h2")
    public WebElement removeitempopup_msg;

    @FindBy(xpath = "//button[@class='remove']")
    public WebElement removeitem_YesBtn;

    @FindBy(css = "div[class='cart-product-option-mobile'] a[class='remove-cart-item']")
    public WebElement removeItem_BtnMobileTablet;

    //Order Summary table webelements
    @FindBy(xpath = "//table[@class='order-totals-table']/tbody/tr[@id='order-state-recycling-fee']/td")
    public WebElement recycleFee_cart;

    @FindBy(xpath = "//button[@class='save-item']")
    public WebElement saveItem;
}
