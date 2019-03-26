package com.evasoftwareautomation.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "junit:target/cucumber.xml"},
        features = "src/test/resources/com/evasoftwareautomation/features",
        glue = {"com.evasoftwareautomation.stepdefs", "com.evasoftwareautomation.world"},
        junit ={ "--step-notifications"},
        monochrome = true)
public class CucumberTest {
}