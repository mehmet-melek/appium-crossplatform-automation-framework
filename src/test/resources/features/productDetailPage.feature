Feature: Product Detail Page Tests

  Background:   Login successfully with valid user and valid password
    Given User is at the login page
    When User enters username as "standard_user" and password as "secret_sauce"
    And User clicks on login button
    Then User is able to successfully login to application.