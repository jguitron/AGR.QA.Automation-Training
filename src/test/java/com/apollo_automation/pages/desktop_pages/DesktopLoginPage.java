package com.apollo_automation.pages.desktop_pages;

import com.apollo_automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopLoginPage {

    public DesktopLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='dwfrm_login_username']")
    public WebElement email;

    @FindBy(id = "dwfrm_login_password")
    public WebElement password;

    @FindBy(name = "dwfrm_login_login")
    public WebElement loginBtn;


    public void login(){
        this.email.sendKeys();
        this.password.sendKeys();
        loginBtn.click();
    }

}
