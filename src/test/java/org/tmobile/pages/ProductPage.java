package org.tmobile.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class ProductPage {

  private SelenideElement productName = $("h1[data-qa='PRD_ProductName']");
  private SelenideElement productPriceUpFront = $(
      "div[class*='vertical_view'] div[data-qa='PRD_TotalUpfront']");
  private SelenideElement monthlyPrice = $(
      "div[class*='vertical_view'] div[class*='priceRightSection'] div[class*='dt_price_change']");
  private SelenideElement addToBasket = $(
      "div[class*='vertical_view'] button[data-qa='PRD_AddToBasket']");
  private SelenideElement buyAsGuest = $("button[data-qa='Presale_NewUserCta']");
  private SelenideElement newNumberRadioButton = $$("label[class*='radioType_primary']")
      .filterBy(Condition.text("Kupuję nowy numer"))
      .first();
  private SelenideElement nextButton = $$("button")
      .filterBy(Condition.text("Dalej"))
      .first();

  public void productPageIsVisible() {
    productName.shouldBe(visible);
  }

  public void addProductToCart() {
    addToBasket.click();
    if (buyAsGuest.exists()) {
      buyAsGuest.click();
      newNumberRadioButton.click();
      nextButton.click();
    }
  }

  public String getProductPricesUpFront() {
    return productPriceUpFront.getText();
  }

  public String getProductMonthlyPrice() {
    if (monthlyPrice.exists()) {
      return monthlyPrice.getText();
    }
    return null;
  }
}
