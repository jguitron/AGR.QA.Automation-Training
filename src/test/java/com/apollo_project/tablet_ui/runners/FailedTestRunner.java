package com.apollo_project.tablet_ui.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "com/desktop_ui_tests/step_definitions"
)

public class FailedTestRunner {
}

