package com.ashley_ui.pages;

import com.ashley_ui.utilities.Driver;
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

    @FindBy(xpath = "//div[@id='eabee0e68c4046aed0e0f142b3']//div/div")
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
