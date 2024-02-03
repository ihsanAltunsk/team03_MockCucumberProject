Feature: US10 User logs in to the homepage
@ihsan
    Scenario: TC01 Registered User accesses to the dashboard
      Given User goes to the easybusticket homepage.
      Then  User clicks on Sign In button and displays the Sign In page.
      And   User clicks on Username box and enters a valid "ihsanUsername".
      And   User clicks on Password box and enters a valid "ihsanPassword".
      And   User clicks the Login button.
      Then  User displays the Dashboard page.