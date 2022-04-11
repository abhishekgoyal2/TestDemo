package com.bh.assign.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import net.serenitybdd.cucumber.CucumberWithSerenity;
//import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report.html","json:target/cucumber/Destination/cucumber.json"},
        monochrome = true
        ,dryRun=false,
        features = {"src/test/resources"},glue={"com.bh.assign.stepdef"}
)

public class RunnerTest extends AbstractTestNGCucumberTests {
}

