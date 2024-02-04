Feature: US012 The registered user accesses the user dashboard page and performs their operations.

  Scenario: TC01 User access to site logo and homepage Dashboard link images.
    Given User goes to the easybusticket homepage.
    Then  User clicks on Sign In button and displays the Sign In page.
    And   User clicks on Username box and enters a valid "azimUsername".
    And   User clicks on Password box and enters a valid "azimPassword".
    And   User clicks the Login button.
    And   Click on the "Easybusticket Logo ikon "on the header.
    And   Click on the "Dashboard " button  on the header.
    Then  User displays the Dashboard page.
    Then  User closes the page.

  Scenario: TC02 Verifies that the Dashboard on the User Dashboard page is available in the menu.
    Given User goes to the easybusticket homepage.
    Then  User clicks on Sign In button and displays the Sign In page.
    And   User clicks on Username box and enters a valid "azimUsername".
    And   User clicks on Password box and enters a valid "azimPassword".
    And   User clicks the Login button.
    And   Click on the "Dashboard " button  on the header.
    And  Verify that menu dasbord button is visible successfully
    Then  User displays the Dashboard page.
    Then  User closes the page.

  Scenario: TC03 The user sees the dashboard page refresh in the menu on the Dashboard page.
    Given User goes to the easybusticket homepage.
    Then  User clicks on Sign In button and displays the Sign In page.
    And   User clicks on Username box and enters a valid "azimUsername".
    And   User clicks on Password box and enters a valid "azimPassword".
    And   User clicks the Login button.
    Then  User displays the Dashboard page.
    Then  User closes the page.