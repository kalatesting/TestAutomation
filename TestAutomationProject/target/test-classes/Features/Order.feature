Feature: Login to the WebSite

  @Test
  Scenario: Validate the Tshirt Order
    Given I Login to the Website
    When I order the TShirt
    Then I check the order history

