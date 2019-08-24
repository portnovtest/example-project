package com.sample.tests.junit;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"./src/test/java/com/sample/tests/features"},
        glue = {"com/sample/tests/steps"},
        plugin = {
                "json:build/cucumber.json", "html:build/cucumber-html-report",
                "pretty:build/cucumber-pretty.txt",
                "usage:build/cucumber-usage.json",
                "junit:build/cucumber-junit-results.xml"
        }, tags = {}
)
public class SampleCucumberTest {
}
