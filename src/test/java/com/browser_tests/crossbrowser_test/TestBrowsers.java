package com.browser_tests.crossbrowser_test;

import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBrowsers {

    WebDriver driver;

    @Test
    public void chrome() throws Exception {
        driver = BrowserFactory.getBrowser("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Current url is: " + driver.getCurrentUrl());
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        System.out.println("Browser name: " + cap.getBrowserName().toLowerCase());
        System.out.println("Platform name: " + cap.getPlatformName().toString());
        System.out.println("Browser version: " + cap.getBrowserVersion());
        driver.close();
    }

    @Test
    public void firefox() throws Exception {
        driver = BrowserFactory.getBrowser("firefox");
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Current url is: " + driver.getCurrentUrl());
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        System.out.println("Browser name: " + cap.getBrowserName().toLowerCase());
        System.out.println("Platform name: " + cap.getPlatformName().toString());
        System.out.println("Browser version: " + cap.getBrowserVersion());
        driver.quit();
    }

//    @Test
//    public void safari() throws Exception {
//        driver = BrowserFactory.getBrowser("safari");
//        driver.manage().window().maximize();
//        driver.get("https://www.ashleyfurniture.com/");
//        System.out.println("Page title is: " + driver.getTitle());
//        System.out.println("Current url is: " + driver.getCurrentUrl());
//        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
//        System.out.println("Browser name: " + cap.getBrowserName().toLowerCase());
//        System.out.println("Platform name: " + cap.getPlatformName().toString());
//        System.out.println("Browser version: " + cap.getBrowserVersion());
//        driver.close();
//
//    }
}
