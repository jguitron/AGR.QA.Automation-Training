package com.browser_tests.crossbrowser_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Safari implements BrowserInstance{
    public WebDriver createInstance(){
        WebDriver driver = WebDriverManager.safaridriver().browserInDocker().create();
        return driver;
    }
}
