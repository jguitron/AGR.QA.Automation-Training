package com.sfcc_smoke.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BstackUtils {

    static WebDriver driver = Driver.getDriver();

    public static void bstackTestResults(String status, String reason) {
        final JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(String.format("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+ status + "\", \"reason\": \"" + reason + "\"}}"));
    }

    public static void initialLocationHandler() {
        try {
            driver.findElement(By.xpath("//input[@id='dwfrm_zipcodeentry_postal']")).sendKeys("33606"+ Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Initial Zip Code request was skipped!");
        }
    }
}
