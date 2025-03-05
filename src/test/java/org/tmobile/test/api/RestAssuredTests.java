package org.tmobile.test.api;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/org.tmobile.cucumber/api/", glue = {"org.tmobile.config.api",
    "org.tmobile.steps.api"})
public class RestAssuredTests {

}
