package com.bh.assign.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report.html","json:target/cucumber/Destination/cucumber.json"},
        monochrome = true
        ,
//        tags="@BillingDemo",
        features = {"src/test/resources"},glue={"com.bh.assign.stepdef"}
)

public class RunnerTest extends AbstractTestNGCucumberTests {
}

