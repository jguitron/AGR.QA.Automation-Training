package com.ashley_ui.pages;

import com.ashley_ui.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyPage {

    public EtsyPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[data-id='search-query']")
    public WebElement search;

    @FindBy(css = "span[class='wt-icon wt-nudge-b-2 wt-nudge-r-1']")
    public WebElement clickSearch;

}
