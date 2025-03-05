package org.tmobile.steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.tmobile.pages.BasketPage;
import org.tmobile.pages.MainPage;
import org.tmobile.pages.ProductPage;
import org.tmobile.pages.SmartphonesNoSubPage;

public class AddProductToCartStepsDefinitions {

  private final MainPage mainPage = new MainPage();
  private final SmartphonesNoSubPage smartphonesNoSubPage = new SmartphonesNoSubPage();
  private final ProductPage productPage = new ProductPage();
  private final BasketPage basketPage = new BasketPage();
  private String priceUpFront;
  private String monthlyPayments;

  @Given("przeglądarka {string} jest otwarta")
  public void openBrowser(String browserName) {
    mainPage.openBrowser(browserName);
  }

  @When("przechodzę na stronę główną T-Mobile")
  public void openTMobileMainPage() {
    mainPage.openTMobileMainPage();
  }

  @Then("widzę stronę główną")
  public void tMobileMainPageIsVisible() {
    mainPage.tMobileMainPageIsVisible();
  }

  @When("wybieram zakładkę \"Urządzenia\" z górnej belki")
  public void moveCursosToDeviceTab() {
    mainPage.moveCursorToDeviceTab();
  }

  @Then("widzę rozwijaną listę")
  public void expandedDevicesTabIsVisible() {
    mainPage.expandedDevicesTabIsVisible();
  }

  @When("w sekcji \"Bez abonamentu\" klikam \"Smartfony\"")
  public void clickSmartphonesWithoutSubscription() {
    mainPage.clickSmartphonesWithoutSubscription();
  }

  @Then("widzę listę smartfonów")
  public void smartphonesWithoutSubscriptionPageIsVisible() {
    smartphonesNoSubPage.smartphonesWithoutSubscriptionPageIsVisible();
  }

  @When("klikam w pierwszy produkt z listy")
  public void clickOnFirstListItem() {
    smartphonesNoSubPage.clickOnFirstListItem();
  }

  @Then("widzę stronę produktu")
  public void productPageIsVisible() {
    productPage.productPageIsVisible();
    priceUpFront = productPage.getProductPricesUpFront();
    monthlyPayments = productPage.getProductMonthlyPrice();
  }

  @When("dodaję produkt do koszyka")
  public void addProductToCart() {
    productPage.addProductToCart();
  }

  @Then("widzę stronę \"Twój koszyk\"")
  public void basketPageIsVisible() {
    basketPage.basketPageIsVisible();

  }

  @And("kwoty \"Cena na start\" oraz \"Rata miesięczna\" zgadzają się z poprzednią stroną")
  public void comparePrices() {
    basketPage.comparePriceUpFront(priceUpFront);
    basketPage.compareMonthlyPrice(monthlyPayments);
  }

  @And("w prawym górnym rogu widzę ikonę koszyka z liczbą produktów")
  public void basketItemsQuantityIsVisible() {
    mainPage.basketItemsQuantityIsVisible();
  }
}