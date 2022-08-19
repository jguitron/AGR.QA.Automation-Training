package com.sfcc_smoke.utilities;

import org.openqa.selenium.JavascriptExecutor;

public class BstackUtils {

    public static void bstackTestResults(String status, String reason) {
        final JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(String.format("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+ status + "\", \"reason\": \"" + reason + "\"}}"));
    }
}
