package com.apollo_project.tablet_ui.step_definitions;

import com.apollo_project.utilities.Driver;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @BeforeAll()
    public static void setupScenario(){
        Dimension dimension = new Dimension(1023,700);
        Driver.getDriver().manage().window().setSize(dimension);
        System.out.println("=================Tablet TestScenario execution Started!=================");
    }

    @After()
    public static void tearDownScenario(Scenario scenario){
        if (scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        System.out.println("=================Tablet TestScenario execution Finished!=================");

    }

    @AfterAll()
    public static void tearDown(){
//        Driver.closeDriver();
    }

}