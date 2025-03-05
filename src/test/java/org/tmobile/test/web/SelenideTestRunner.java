package org.tmobile.test.web;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/", glue = "org.tmobile.steps")
public class SelenideTestRunner {

}
