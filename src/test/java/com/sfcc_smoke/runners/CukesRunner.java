package com.sfcc_smoke.runners;

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
        glue = "com/sfcc_smoke/step_definitions",
        dryRun = false,
        tags = "@wip9"
)

public class CukesRunner {
}

