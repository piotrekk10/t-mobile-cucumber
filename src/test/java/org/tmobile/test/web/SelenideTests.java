package org.tmobile.test.web;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
    "json:target/cucumber-reports/CucumberWeb.json"}, features = "src/test/resources/org.tmobile.cucumber/web/", glue = {
    "org.tmobile.config.web",
    "org.tmobile.steps.web"})
public class SelenideTests {

}
