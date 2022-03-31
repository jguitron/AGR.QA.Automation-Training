package com.apollo_project.desktop_ui.step_definitions;

import com.apollo_project.utilities.Driver;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @BeforeAll()
    public static void setupScenario(){
        Driver.getDriver().manage().window().maximize();
        System.out.println("=================Desktop TestScenario execution Started!=================");
    }

    @After()
    public static void tearDownScenario(Scenario scenario){
        if (scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        System.out.println("=================Desktop TestScenario execution Finished!=================");

    }

    @AfterAll()
    public static void tearDown(){
//        Driver.closeDriver();

    }

}