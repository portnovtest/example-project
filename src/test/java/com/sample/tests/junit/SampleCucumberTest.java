package com.sample.tests.junit;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ExtendedParallelScenarioCucumber;;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(ExtendedParallelScenarioCucumber.class)
@ExtendedCucumberOptions(
        threadsCount = 3,
        outputFolder = "build/",
        detailedReport = true,
        detailedAggregatedReport = true,
        jsonReport = "build/cucumber.json"
)
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
