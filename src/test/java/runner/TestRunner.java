package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features"}, glue = {"stepDefinitions"}
        , monochrome = true, plugin = {}, publish = true, tags = "t")
public class TestRunner extends AbstractTestNGCucumberTests
{}
