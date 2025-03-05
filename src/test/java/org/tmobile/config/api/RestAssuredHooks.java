package org.tmobile.config.api;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.parsing.Parser;


public class RestAssuredHooks {

  @Before("@api")
  public void beforeTest() {
    RestAssured.baseURI = "http://api.nbp.pl";
    RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    RestAssured.defaultParser = Parser.XML;
  }
}