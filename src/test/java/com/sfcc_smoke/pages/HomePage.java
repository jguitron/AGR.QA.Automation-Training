package com.sfcc_smoke.pages;

import com.sfcc_smoke.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[*='Log In']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[.='Log in or Create an Account']")
    public WebElement loginLink;

    @FindBy(xpath = "//div[@class='fcopt-offers']//iframe")
    public WebElement frameOne;

    @FindBy(xpath = "//button[@title='Close Dialog']")
    public WebElement closeFrame;

    @FindBy(xpath ="(//a[@data-cgid='furniture'])[1]")
    public WebElement furniture;

    @FindBy(tagName = "a")
    public List<WebElement> allLinks;

    @FindBy(xpath = "//div[@class='closeBtn']")
    public WebElement closeOffer;

    @FindBy(xpath = "//li[@class='unbxd-as-header unbxd-as-popular-product-header'] /strong")
    public WebElement searchSugesstions;


    @FindBy(css = "div[class='account-text-container'] div")
    public WebElement userNameDisplayed;

    @FindBy(xpath = "//span[@class='hamburger-box']")
    public WebElement hamburgerBox;

    @FindBy(xpath = "//a[@class='user-account user-account-registered']")
    public WebElement accountTabMobileView;

    @FindBy(xpath = "//a[@class='user-account-show']")
    public WebElement accountTabOpenMobileView;

    @FindBy(xpath = "//a[@href='/wishlist/']")
    public WebElement accountWishListMobile;

    @FindBy(xpath = "//div[@id='mini-cart'] /div /a")
    public WebElement cartIconDeskTopNew;

    @FindBy(xpath = "//a[@class='mini-cart-link']")
    public WebElement cartIconItemAdded;

    @FindBy(xpath = "//a[@class='mini-cart-link mini-cart-empty']")
    public WebElement cartIconZeroItems;

    @FindBy(xpath = "//span[@class='minicart-quantity']")
    public WebElement miniCartQty;

    @FindBy(xpath = "//a[@class='section-header-note address-create']")
    public WebElement createAddressButton;





}
