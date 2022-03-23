package com.browser_tests.crossbrowser_test;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {
    private static WebDriver driver;
    public static WebDriver getBrowser(String browser) throws BrowserException{
        browser = browser.trim();
            if ("chrome".equals(browser)){
                driver = new Chrome().createInstance();
            } else if ("safari".equals(browser)){
                driver = new Safari().createInstance();
            } else if ("firefox".equals(browser)){
                driver = new Firefox().createInstance();
            } else {
                throw new BrowserException(browser + " is not supported");
            }
            return driver;
    }

}
