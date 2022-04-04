package com.apollo_automation.step_definitions;

import com.apollo_automation.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(value="@desktop")
    public static void setupScenarioDesktop(){
        Driver.getDriver().manage().window().maximize();
        System.out.println("=================Desktop TestScenario execution Started!=================");
    }

    @Before(value="@mobile")
    public static void setupScenarioMobile(){
        Dimension dimension = new Dimension(766,650);
        Driver.getDriver().manage().window().setSize(dimension);
        System.out.println("=================Tablet TestScenario execution Started!=================");
    }

    @Before(value="@tablet")
    public static void setupScenarioTablet(){
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
        System.out.println("=================Desktop TestScenario execution Finished!=================");

    }

    @AfterAll()
    public static void tearDown(){
        Driver.closeDriver();

    }
}