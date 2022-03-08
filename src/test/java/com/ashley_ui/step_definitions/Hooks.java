package com.ashley_ui.step_definitions;

import com.ashley_ui.utilities.ConfigurationReader;
import com.ashley_ui.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before()
    public static void setupScenario(){
        System.out.println("=================TestScenario execution Started!=================");

    }

    @After()
    public static void tearDownScenario(Scenario scenario){
        if (scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        System.out.println("=================TestScenario execution Finished!=================");
        Driver.closeDriver();
    }

}