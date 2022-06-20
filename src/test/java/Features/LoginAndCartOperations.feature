Feature: Use case - Register, login and perform cart operations.

  This feature tests the ability of the user to log into amazon then perform the following:
  Choose an Item
  Add to shopping basket
  Go to checkout
  Remove item
  Add another item

  Background:
    Given User is on the Homepage of Amazon.co.uk

  # TC-001: New user can complete the Create Account form in order to register.
  # TC-002: Registered user can log in with valid credentials.
  # TC-003: Signed In user can choose and add an item to the shopping basket and navigate to checkout.
  # TC-004: Signed In user can remove added item from shopping basket.
  # TC-005: Signed In user can add another item into shopping basket.

  Scenario: TC-001: New user can complete the Create Account form in order to register.
    When User completes the Create Account form
      | name           | email               | password1      | password2      |
      | Michael Jacobs | mikejacobs@mail.com | MyPassword@234 | MyPassword@234 |

    And Clicks the Verify Email button
    Then A system email is sent to user account

  Scenario: TC-002: Registered user can log in with valid credentials
    When Enters valid credentials to sign in
      | email               | password       |
      | victomo@hotmail.com | Sixdegrees@E14 |
    And Clicks the Sign In button
    Then User account page is successfully opened

  Scenario Outline: TC-003: Signed In user can choose and add an item to the shopping basket and navigate to checkout
    When User Logs in with valid credentials
      | email               | password       |
      | victomo@hotmail.com | Sixdegrees@E14 |
    And Selects an "<item>" to add to the shopping basket
    And Navigates to the checkout page
    Then Item is successfully added and displayed
    Examples:
      | item        |
      | garden pool |

  Scenario Outline: TC-004: Signed In user can remove added item from shopping basket
    When User Logs in with valid credentials
      | email               | password       |
      | victomo@hotmail.com | Sixdegrees@E14 |
    And Selects an "<item>" to add to the shopping basket
    And Navigates to the checkout page
    And Deletes added item
    Then Item is successfully removed from the shopping basket
    Examples:
      | item        |
      | garden pool |


  Scenario Outline: TC-005: Signed In user can add another item into shopping basket
    When User Logs in with valid credentials
      | email               | password       |
      | victomo@hotmail.com | Sixdegrees@E14 |
    And Selects an "<item>" to add to the shopping basket
    And Navigates to the checkout page
    And Deletes added item
    Then User can add "<another_item>" item to the shopping basket

    Examples:
      | item        | another_item |
      | garden pool | face cap     |






