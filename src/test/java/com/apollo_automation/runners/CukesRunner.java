package com.apollo_automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        plugin = {"html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "junit:target/junit-report.xml",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/apollo_automation/step_definitions",
        dryRun = false,
        tags = "@regression"
)

public class CukesRunner {
}

