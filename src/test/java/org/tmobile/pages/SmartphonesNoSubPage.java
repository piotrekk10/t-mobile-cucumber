package org.tmobile.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class SmartphonesNoSubPage {

  private final SelenideElement devicesHeader = $$("h1")
      .filterBy(Condition.text("Urządzenia bez abonamentu"))
      .first();
  private final SelenideElement firstItem = $("div[data-qa*='LST_ProductCard0']");

  public void smartphonesWithoutSubscriptionPageIsVisible() {
    devicesHeader.shouldBe(visible);
  }

  public void clickOnFirstListItem() {
    firstItem.click();
  }
}
