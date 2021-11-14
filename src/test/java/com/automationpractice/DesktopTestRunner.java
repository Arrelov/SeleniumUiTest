package com.automationpractice;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/java/com/automationpractice/feature/desktop",
        glue = "com/automationpractice/steps/desktop",
        plugin = "pretty"
)

@RunWith(Cucumber.class)
public class DesktopTestRunner {
}
