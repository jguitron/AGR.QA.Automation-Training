package com.sfcc_smoke.pages;

import com.sfcc_smoke.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@data-cgid='furniture'])[1]")
    public WebElement furniture;

    @FindBy(xpath = "//li[*='TV Stands']")
    public WebElement tvStand;

    @FindBy(css = "a[class='page-switcher page-last']")
    public WebElement lastPageBtn;

    @FindBy(xpath = "(//div[@class='alt-img-cont'])[16]")
    public WebElement lastTvStand;

    @FindBy(xpath = "(//input[@name='plus'])[2]")
    public WebElement qty;

    @FindBy(css = "button[id='add-to-cart']")
    public WebElement addToCart;

    @FindBy(css = "div[id='mini-cart']")
    public WebElement cart;

    @FindBy(css = "td[class='order-value']")
    public WebElement totalPrice;

    @FindBy(id = "q")
    public WebElement searchBar;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement searchIcon;

    @FindBy(xpath = "(//tr[@class='order-subtotal']/td)[1]")
    public WebElement totalCount;

    @FindBy(css = "div[id='product-results']")
    public WebElement productCount;
}
