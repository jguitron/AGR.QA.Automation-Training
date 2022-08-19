package com.sfcc_smoke.step_definitions.helpers;

import com.browserstack.local.Local;
import com.sfcc_smoke.utilities.BstackUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.HashMap;

public class Hooks {

    private static String browser = System.getProperty("browser") != null ? browser = System.getProperty("browser") : ConfigReader.getProperty("browser");
    private static final String BS_PASSWORD = ConfigReader.getProperty("BS_ACCESS_KEY");
    private static final Local LOCAL = new Local();
    private static final HashMap<String, String> BS_LOCAL_ARGS = new HashMap<>();

    @BeforeAll
    public static void setUpConnection() throws Exception {
        System.out.println("Before All Steps Running");
        BS_LOCAL_ARGS.put("key", BS_PASSWORD);
        if (browser.contains("bstack")) {
            LOCAL.start(BS_LOCAL_ARGS);
        }
    }

    @Before
    public void setUpBrowser() {
        String platform = System.getProperty("platform") != null ? platform = System.getProperty("platform") : ConfigReader.getProperty("platform");
        Dimension dimension;
        switch (platform) {
            case "desktop":
                Driver.getDriver().manage().window().maximize();
                System.out.println("============Desktop Test Started!=============");
                break;
            case "tablet":
                dimension = new Dimension(1020, 850);
                Driver.getDriver().manage().window().setSize(dimension);
                System.out.println("============Tablet Test Started!=============");
                break;
            case "mobile":
                dimension = new Dimension(516, 844);
                Driver.getDriver().manage().window().setSize(dimension);
                System.out.println("BrowserSize: " + Driver.getDriver().manage().window().getSize());
                System.out.println("============Mobile Test Started!=============");
                break;
            default:
                Driver.getDriver().manage().window().maximize();
        }
    }

    @After
    public void afterScenarioStep(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        if (scenario.isFailed() && browser.contains("bstack")) {
            BstackUtils.bstackTestResults("failed", String.format("%s failed.", scenario.getName()));
        }
        if (!scenario.isFailed() && browser.contains("bstack")) {
            BstackUtils.bstackTestResults("passed", String.format("%s passed.", scenario.getName()));
        }
        System.out.println("==============Test execution Finished!==============");
        Driver.closeDriver();
    }

    @AfterAll
    public static void tearDown() throws Exception{
        System.out.println("After All is running...");
        if (browser.contains("bstack")) {
            LOCAL.stop();
        }
    }
}