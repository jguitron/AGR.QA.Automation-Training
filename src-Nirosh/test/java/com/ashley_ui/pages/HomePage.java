package com.ashley_ui.pages;

import com.ashley_ui.utilities.Driver;
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

}
