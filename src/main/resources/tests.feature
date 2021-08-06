Feature: Tests
  As a user
  I want to test site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check register fields
    Given user opens '<homePage>' page
    And user click on register button
    And user checks registration page is open
    When  user input firstname '<keyword>'field
    And user input lastname '<lastName>'field
    And user input email '<email>' in email field
    And user click on show password checkbox
    And user input password '<password>' in password field
    Then user get error message about incorrect password

    Examples:
      | homePage              | keyword | lastName | email                | password |
      | https://www.ebay.com/ | Dik     | Buster   | busterdik6@gmail.com | fff      |

  Scenario Outline: Some product add to cart
    Given user opens '<homePage>' page
    And user click on button homeAndGarden category
    And choose furniture category
    And user click on sofas and armchairs button
    And user click on sofas gray color category
    And click on chosen product button
    And user click on add to cart button
    And user check that cart contains one product
    And user click remove button of product from cart
    Then user check message about empty cart

    Examples:
      | homePage              |
      | https://www.ebay.com/ |

  Scenario Outline: Check search result
    Given user opens '<homePage>' page
    And user input search '<searchKeyword>' keyword
    And user check contains text '<searchKeyword>' of product
    When user enter max length keyword in search field
    And user get error message about incorrect search keyword
    And user enter incorrect search keyword
    Then user get message that no exact matches found

    Examples:
      | homePage              | searchKeyword |
      | https://www.ebay.com/ | sony xperia   |

  Scenario Outline: Check product page
    Given user opens '<homePage>' page
    And user click shop by category
    And user click on Cell phones & accessories from drop list
    And click on smart watches category
    And user choose smart watch product on this page
    And user enter in quantity field '<amountOfProduct>'
    And user get message about need to quantity of one or more
    When user save this seller
    And user get opening the registration window with create an account message
    And user click on logo button
    And user come back on product page
    And click on add to Watchlist button
    Then And user get opening the registration window with create an account message

    Examples:
      | homePage              | amountOfProduct |
      | https://www.ebay.com/ | -1              |

  Scenario Outline: Check shipping to Ukraine
    Given user opens '<homePage>' page
    And user click on shipTo button
    And click on country list button
    And user choose Ukraine country
    Then user check that Ukraine flag is visibility


    Examples:
      | homePage              |
      | https://www.ebay.com/ |