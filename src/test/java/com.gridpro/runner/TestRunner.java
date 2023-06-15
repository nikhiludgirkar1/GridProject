package com.gridpro.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/feature/FirstTest.feature"}, glue = {"com.gridpro.definitions"},
        plugin = {})

public class TestRunner extends AbstractTestNGCucumberTests {

}