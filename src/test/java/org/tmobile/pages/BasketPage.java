package org.tmobile.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.util.Objects;

public class BasketPage {

  private final SelenideElement basketHeader = $$("h1")
      .filterBy(Condition.text("Twój koszyk"))
      .first();
  private final SelenideElement productPriceUpFront = $(
      "div[data-qa='BKT_TotalupFrontCurrCOde']");
  private final SelenideElement monthlyPrice = $(
      "div[data-qa='BKT_TotalMonthlyCurrCOde']");


  public void basketPageIsVisible() {
    basketHeader.shouldBe(visible);
  }

  public void comparePriceUpFront(String price) {
    productPriceUpFront.shouldHave(text(price));
  }

  public void compareMonthlyPrice(String price) {
    monthlyPrice.shouldHave(text(Objects.requireNonNullElse(price, "0 zł")));
  }
}
