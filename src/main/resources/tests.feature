Feature: Tests
  As a user
  I want to test site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check register page
    Given user opens home page
    When user goes to registration page
    Then user checks <registrationPage> is open

    Examples:
      | registrationPage                                                 |
      | https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F |

  Scenario Outline: Check register fields
    Given user opens home page
    And user goes to registration page
    When User fills out the form:
      | Dik | Buster | busterdik6@gmail.com | fff |
    Then user gets <errorMessage1> about incorrect password

    Examples:
      | errorMessage1         |
      | at least 6 characters |

  Scenario: Check search result by keyword
    Given user opens home page
    When user input keyword sony xperia in search field
    Then user checks text of product is contains sony xperia

  Scenario: Check search result by empty string
    Given user opens home page
    When user enter              in search field
    Then user gets error message: The query must have at least a keyword


  Scenario: Check shipping to Ukraine
    Given user opens home page
    And user click on shipTo button
    And click on country list button
    And user choose Ukraine country
    Then user check that Ukraine flag is visibility


  Scenario Outline: Add product to card
    Given user opens home page
    And user chooses smartphone categories
    And user chooses apple from smart watches category
    When user adds <quantity> to cart the first position of watches
    Then user checks quantity item in cart is <quantity>

    Examples:
      | quantity |
      | 1        |
      | 2        |

  Scenario: Delete product from cart
    Given user opens home page
    And user adds product in cart
    When user goes to cart and removes item
    Then user checks message: You don't have any items in your cart

  Scenario Outline: Enter invalid value in product field
    Given user opens home page
    And user chooses some product on home page
    When user enter <quantity> item in field
    Then user gets message: Please enter quantity of 1 or more

    Examples:
      | quantity |
      | -1       |
      | 2+       |