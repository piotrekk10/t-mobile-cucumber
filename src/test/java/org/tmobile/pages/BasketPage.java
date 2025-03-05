package org.tmobile.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class BasketPage {

  private SelenideElement basketHeader = $$("h1")
      .filterBy(Condition.text("Twój koszyk"))
      .first();
  private SelenideElement productPriceUpFront = $(
      "div[data-qa='BKT_TotalupFrontCurrCOde']");
  private SelenideElement monthlyPrice = $(
      "div[data-qa='BKT_TotalMonthlyCurrCOde']");


  public void basketPageIsVisible() {
    basketHeader.shouldBe(visible);
  }

  public void comparePriceUpFront(String price) {
    productPriceUpFront.shouldHave(text(price));
  }

  public void compareMonthlyPrice(String price) {
    if (price == null) {
      monthlyPrice.shouldHave(text("0 zł"));
    } else {
      monthlyPrice.shouldHave(text(price));
    }
  }
}
