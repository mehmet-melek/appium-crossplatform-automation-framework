Feature: Product Page Tests

  Background:   Login successfully with valid user and valid password
    Given User is at the login page
    When User enters username as "standard_user" and password as "secret_sauce"
    And User clicks on login button
    Then User is able to successfully login to application.

  @IOS @ANDROID
  Scenario: Open product page over product image
    Given User is at the product page
    When User click to product image
    Then User should see the product detail page open

  @IOS @ANDROID
  Scenario: Open product page over product title
    Given User is at the product page
    When User click to product title
    Then User should see the product detail page open

  @IOS @ANDROID
  Scenario: Button Add To Cart turns into button Remove
    Given User is at the product page
    When User clicks on Add To Cart button
    Then User should see Remove button instead of Add To Cart button

  @ANDROID
  Scenario: Add To Cart button is pressed once
    Given User is at the product page
    When User clicks on Add To Cart button
    Then the number on cart icon should be 1

  @ANDROID
  Scenario: Add To Cart button is pressed twice
    Given User is at the product page
    When User clicks on Add To Cart button
    And User clicks on Add To Cart button
    Then the number on cart icon should be 2

  @ANDROID
  Scenario: Add To Cart button is pressed twice then Remove button is pressed once
    Given User is at the product page
    When User clicks on Add To Cart button
    And User clicks on Add To Cart button
    And User clicks on Remove button
    Then the number on cart icon should be 2



