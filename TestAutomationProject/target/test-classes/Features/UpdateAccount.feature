Feature: To Edit the Personal Information in My Account

  Scenario: Validate the Account update
    Given The Sign In to the Webpage
    When I Edit the FirstName of MyAccount
    Then The Account should be updated successfully

