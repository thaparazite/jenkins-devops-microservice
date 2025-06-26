package com.in28minutes.microservices.currencyexchangeservice.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = "src/test/resources", plugin = { "pretty" })
public class RunCucumberIntegrationTestCase {
}