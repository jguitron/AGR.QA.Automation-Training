package com.browser_tests.crossbrowser_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements BrowserInstance{
    public WebDriver createInstance(){
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);

    }
}
