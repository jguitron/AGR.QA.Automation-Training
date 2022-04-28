package com.sfcc_smoke.pages;

import com.sfcc_smoke.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//input[@id='q'])[1]")
    public WebElement searchBar;

    @FindBy(xpath = "//div[@class='unbxd-as-popular-product-image-container']")
    public WebElement searchBarResultOne;

    @FindBy(xpath = "//a[@class='mini-cart-link']")
    public WebElement miniCartIcon;

    @FindBy(xpath = "(//div[@id='header-closest-store'])[1]")
    public WebElement chooseLocalStore;

    @FindBy(xpath = "(//div[@class='local-pricing-zip-code'])[2]")
    public WebElement mobStoreLink;

    @FindBy(xpath = "//input[@id='dwfrm_zipcodeentry_postal']")
    public WebElement zipCodeBox;

    @FindBy(xpath = "//h1[@id='headerText']")
    public WebElement paypalHeader;

    @FindBy(xpath = "//a[@class='back-to-cart']")
    public WebElement backToCartIcon;
}
