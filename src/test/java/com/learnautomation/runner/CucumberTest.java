package com.learnautomation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.learnautomation.steps", "com.learnautomation.hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-report.html",
        "json:target/cucumber-report.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    monochrome = true
)
public class CucumberTest {
}


