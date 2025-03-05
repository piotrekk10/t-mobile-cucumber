package org.tmobile.config.web;

import com.codeborne.selenide.logevents.SimpleReport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class SelenideHooks {

  private final SimpleReport report = new SimpleReport();

  @Before("@web")
  public void beforeTest() {
    report.start();

  }

  @After("@web")
  public void afterTest(Scenario scenario) {
    report.finish(scenario.getName());
  }
}

