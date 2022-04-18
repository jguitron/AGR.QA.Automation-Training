package com.apollo_automation.pages;

import com.ashley_ui.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {

    public CommonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Webelement - Search bar on all pages
    @FindBy(xpath = "(//input[@id='q'])[1]")
    public WebElement searchbar;

    @FindBy(xpath = "//div[@class='unbxd-as-popular-product-image-container']")
    public WebElement searchbar_result1;

    //WebElement - Mini cart Icon on Header.
    @FindBy(xpath = "//a[@class='mini-cart-link']")
    public WebElement minicarticon;

    //WebElement - find closest home store down arrow
    @FindBy(xpath = "//a[@id='js-local-pricing-link']")
    public WebElement Storedownarrow;

    //WebElement - Homestore zip code box
    @FindBy(xpath = "//input[@class='input-text numbers-hypen-only postal required']")
    public WebElement HomeStoreZipcodeBox;

    //External webpage element
    @FindBy(xpath = "//h1[@id='headerText']")
    public WebElement paypalheader;

    //Back to cart icon from Delivery, billing, shipping pages
    @FindBy(xpath = "//a[@class='back-to-cart']")
    public WebElement bacttoCartIcon;
}
