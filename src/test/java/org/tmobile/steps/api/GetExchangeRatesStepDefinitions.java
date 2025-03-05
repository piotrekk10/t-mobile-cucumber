package org.tmobile.steps.api;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import java.util.stream.Collectors;
import org.tmobile.model.ExchangeRatesResponse;
import org.tmobile.model.Rate;

public class GetExchangeRatesStepDefinitions {

  ExchangeRatesResponse exchangeRatesResponse;

  @Given("pobieram kursy walut")
  public void getExchangeRates() {

    exchangeRatesResponse = RestAssured
        .given()
        .header("Accept", "application/xml")
        .when()
        .get("/api/exchangerates/tables/a")
        .then()
        .log()
        .status()
        .statusCode(200)
        .extract()
        .response()
        .as(ExchangeRatesResponse.class);

  }

  @When("wyświetlam kurs dla waluty o kodzie {string}")
  public void printCurrencyByCode(String currency) {
    System.out.println("Kurs dla waluty o kodzie " + currency + ": " + exchangeRatesResponse
        .getExchangeRatesTable()
        .getRates()
        .stream()
        .filter(o -> o
            .getCode()
            .equals(currency))
        .findFirst()
        .orElseThrow()
        .getMid());
  }

  @When("wyświetlam kurs dla waluty o nazwie {string}")
  public void printCurrencyByName(String currencyName) {
    System.out.println("Kurs dla waluty o nazwie " + currencyName + ": " + exchangeRatesResponse
        .getExchangeRatesTable()
        .getRates()
        .stream()
        .filter(o -> o
            .getCurrency()
            .equals(currencyName))
        .findFirst()
        .orElseThrow()
        .getMid());
  }

  @When("wyświetlam waluty o kursie powyżej {int}")
  public void printCurrenciesHigherThan(int currencyValue) {
    System.out.println("Waluty o kursie powyżej " + currencyValue + ": " + exchangeRatesResponse
        .getExchangeRatesTable()
        .getRates()
        .stream()
        .filter(o -> o.getMid() > currencyValue)
        .map(Rate::getCurrency)
        .collect(Collectors.joining(", ")));
  }

  @When("wyświetlam waluty o kursie poniżej {double}")
  public void printCurrenciesLowerThan(double currencyValue) {
    System.out.println("Waluty o kursie poniżej " + currencyValue + ": " + exchangeRatesResponse
        .getExchangeRatesTable()
        .getRates()
        .stream()
        .filter(o -> o.getMid() < currencyValue)
        .map(Rate::getCurrency)
        .collect(Collectors.joining(", ")));
  }
}
