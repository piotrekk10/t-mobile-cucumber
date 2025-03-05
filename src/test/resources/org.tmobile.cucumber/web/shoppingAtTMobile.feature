@web
Feature: Zakupy na stronie T-Mobile

  Scenario: Dodanie produktu do koszyka i sprawdzenie ceny
    Given przeglądarka "firefox" jest otwarta
    When przechodzę na stronę główną T-Mobile
    Then widzę stronę główną

    When wybieram zakładkę "Urządzenia" z górnej belki
    Then widzę rozwijaną listę

    When w sekcji "Bez abonamentu" klikam "Smartfony"
    Then widzę listę smartfonów

    When klikam w pierwszy produkt z listy
    Then widzę stronę produktu

    When dodaję produkt do koszyka
    Then widzę stronę "Twój koszyk"
    And kwoty "Cena na start" oraz "Rata miesięczna" zgadzają się z poprzednią stroną

    When przechodzę na stronę główną T-Mobile
    Then widzę stronę główną
    And w prawym górnym rogu widzę ikonę koszyka z liczbą produktów