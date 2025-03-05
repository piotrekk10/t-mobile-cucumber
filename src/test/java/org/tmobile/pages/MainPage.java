package org.tmobile.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Cookie;

public class MainPage {

  private final SelenideElement mainContent = $("div.container>div.large-slider");
  private final SelenideElement devicesTab = $$("li.menu-dropdown")
      .filterBy(text("Urządzenia"))
      .first()
      .$("button.menu-dropdown-item");
  private final SelenideElement expandedDevicesTab = $$("li.menu-dropdown")
      .filterBy(text("Urządzenia"))
      .first()
      .$("div.menu-dropdown-submenu");
  private final SelenideElement smartphonesWithoutSubscription =
      $$("li")
          .filterBy(Condition.text("Bez abonamentu"))
          .last()
          .$$("ul li span")
          .filterBy(Condition.text("Smartfony"))
          .last();
  private final SelenideElement basket = $("a[title='Koszyk']>div");

  public void openBrowser(String browserName) {
    Configuration.browser = browserName;
    Configuration.browserSize = "1920x1080";
    open("https://t-mobile.pl");
    Cookie cookie = new Cookie.Builder("didomi_token",
        "eyJ1c2VyX2lkIjoiMTk1NjFlOWYtMzZkNy02Y2E3LTk5MGItMTEwZWNmYmI0OGRlIiwiY3JlYXRlZCI6IjIwMjUtMDMtMDRUMTY6MDc6NTcuMDM3WiIsInVwZGF0ZWQiOiIyMDI1LTAzLTA0VDE2OjA4OjA2Ljg0NFoiLCJ2ZW5kb3JzIjp7ImRpc2FibGVkIjpbImM6dG1vYmlsZS1wcm9kIl19LCJwdXJwb3NlcyI6eyJkaXNhYmxlZCI6WyJhbmFsaXR5Y3puZS10bW9iaWxlLXByb2QiLCJwZXJzb25hbGl6YWN5am5lLXRtb2JpbGUtcHJvZCIsInJla2xhbW93ZS10bW9iaWxlLXByb2QiXX0sInZlcnNpb24iOjJ9")
        .domain("t-mobile.pl")
        .path("/")
        .expiresOn(new java.util.Date(1772726886000L))
        .isHttpOnly(false)
        .isSecure(false)
        .sameSite("Lax")
        .build();
    Selenide
        .webdriver()
        .driver()
        .getWebDriver()
        .manage()
        .addCookie(cookie);
  }

  public void openTMobileMainPage() {
    open("https://t-mobile.pl");
  }

  public void tMobileMainPageIsVisible() {
    mainContent.shouldBe(visible);
  }

  public void moveCursorToDeviceTab() {
    devicesTab.hover();
  }

  public void expandedDevicesTabIsVisible() {
    expandedDevicesTab.shouldBe(visible);
  }

  public void clickSmartphonesWithoutSubscription() {
    smartphonesWithoutSubscription.click();
  }

  public void basketItemsQuantityIsVisible() {
    basket.shouldHave(text("1"));
  }
}
