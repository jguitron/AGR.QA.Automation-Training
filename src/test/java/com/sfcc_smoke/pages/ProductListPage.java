package com.sfcc_smoke.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListPage {

    @FindBy(xpath = "//a[@aria-label='Add to Wishlist']")
    public WebElement heartIcon;
}
