@api
Feature: Kursy walut

  Scenario: Pobieranie i filtrowanie kursów walut
    Given pobieram kursy walut
    When wyświetlam kurs dla waluty o kodzie "USD"
    And wyświetlam kurs dla waluty o nazwie "dolar amerykański"
    And wyświetlam waluty o kursie powyżej 5
    And wyświetlam waluty o kursie poniżej 3
