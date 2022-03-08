package com.ashley_ui.pages;

import com.ashley_ui.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    public AmazonPage(){
    PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBar;

    @FindBy(css = "input[id='nav-search-submit-button']")
    public WebElement searchButton;

}
