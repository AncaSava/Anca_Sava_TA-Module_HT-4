package org.example;

//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org/example/stepdefinitions"},
        tags = "@SmokeTest",
        plugin = {"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
