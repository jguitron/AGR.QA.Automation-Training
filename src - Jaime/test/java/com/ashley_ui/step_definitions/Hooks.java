package com.ashley_ui.step_definitions;

import com.ashley_ui.utilities.Driver;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(value = "@wip", order = 1)
    public void setupScenario(){
        System.out.println("=================TestScenario execution Started!=================");
//        Driver.closeDriver();
    }


    @After()
    public void tearDownScenario(Scenario scenario){
        if (scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        System.out.println("=================TestScenario execution Finished!=================");
    }

}