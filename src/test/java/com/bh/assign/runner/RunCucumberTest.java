package com.bh.assign.runner;
import com.bh.assign.helper.ParentRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report.html","json:target/cucumber/Destination/cucumber.json"},
        monochrome = true
        ,dryRun=false,
        tags="@Get_Access_token_Post",
        features = {"src/test/resources"},glue={"com.bh.assign.stepdef"}
)

public class RunCucumberTest extends ParentRunner {
}

