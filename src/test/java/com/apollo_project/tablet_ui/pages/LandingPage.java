package com.apollo_project.tablet_ui.pages;


import com.apollo_project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public LandingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement footer;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement header;


}
