package com.sfcc_smoke.step_definitions.helpers;

import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

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
                dimension = new Dimension(1023, 850);
                Driver.getDriver().manage().window().setSize(dimension);
                System.out.println("============Tablet Test Started!=============");
                break;
            case "mobile":
                dimension = new Dimension(765, 750);
                Driver.getDriver().manage().window().setSize(dimension);
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
        System.out.println("==============Test execution Finished!==============");
        Driver.closeDriver();
    }

}