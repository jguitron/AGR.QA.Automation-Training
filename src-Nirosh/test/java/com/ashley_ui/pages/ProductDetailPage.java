package com.ashley_ui.pages;

import com.ashley_ui.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

    public ProductDetailPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Webelement - Add to Cart button
    @FindBy(xpath = "//button[@id='add-to-cart']")
    public WebElement addtocart;

    //Webelement - '+' Qty sign
    @FindBy(xpath = "//div[@id='sticky-pdp-addtocart']/div/div/div/label[@class='plus']/input[@value='+']")
    public WebElement plusqty;

    //Webelement - '-' Qty sign
    @FindBy(xpath = "//div[@id='sticky-pdp-addtocart']/div/div/div/label[@class='minus']/input[@value='-']")
    public WebElement minusqty;

    @FindBy(xpath = "(//a[@class='swatchanchor king'])[1]")
    public WebElement iconkingsize;

    //PDP 4 protection plan elements
    @FindBy(xpath = "//label[@for='pp-FURNPRO']")
    public WebElement pdp_FURNPRO;
    @FindBy(xpath = "//label[@for='pp-OUTDRF']")
    public  WebElement pdp_OUTDRF;
    @FindBy(xpath = "//label[@for='pp-ADJPRO']")
    public  WebElement pp_ADJPRO;
    @FindBy(xpath = "//label[@for='pp-KADJPRO']")
    public  WebElement pdp_KADJPRO;

}
