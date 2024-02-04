Feature: US10 User logs in to the homepage

    Scenario : TC01 Registered User accesses to the dashboard
      Given User goes to the easybusticket homepage.
      Then  User clicks on Sign In button and displays the Sign In page.
      And   User clicks on Username box and enters a valid "ihsanUsername".
      And   User clicks on Password box and enters a valid "ihsanPassword".
      And   User clicks the Login button.
      Then  User displays the Dashboard page.
      Then  User closes the page.

    Scenario Outline: TC02 Registered user cannot access to the dashboard with wrong credentials.
      Given User goes to the easybusticket homepage.
      Then  User clicks on Sign In button and displays the Sign In page.
      And   User clicks on Username box and enters a valid "<givenEmail>".
      And   User clicks on Password box and enters a valid "<givenPassword>".
      And   User clicks the Login button.
      But   User waits for 1 seconds.
      Then  User verifies that -These credentials do not match our records.- error text appeared.
      Then  User closes the page.

      Examples:
      | givenEmail           | givenPassword        |
      | ihsanUsername        | ihsanInvalidPassword |
      | ihsanInvalidUsername | ihsanPassword        |
      | ihsanInvalidUsername | ihsanInvalidPassword |