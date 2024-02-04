Feature: US02 Visitor logs in to the main page


  Scenario: TC01 Visitor logs in to the main page
    Given Visitor goes to the easybusticket homepage.
    Then Verify that home page is visible successfully
    And Verify that header is visible successfully
    Then  User closes the page.

  Scenario: TC02 Visitor logs in to the main page
    Given Visitor goes to the easybusticket homepage.
    Then  Visitor homapage header displays web elements
    Then  User closes the page.

  Scenario: TC03 Visitor logs in to the main page
    Given Visitor goes to the easybusticket homepage.
    Then Verify that home page is visible successfully
    And  Click on the "+1 (603) 624-1800" button on the header.
    And  Click on the "info@easybusticket.com" button on the header.
    And  Click on the Twitter icon button on the header.
    Then Verify that you are navigated to twitter page.
    But  Navigate to back.
    And  Click on the Facebook icon button on the header.
    Then Verify that you are navigated to facebook page.
    But  Navigate to back.
    Then Click on the YouTube icon button on the header.
    Then Verify that you are navigated to youtube page.
    But  Navigate to back.
    And  Click on the Instagram icon button on the header.
    Then Verify that you are navigated to instagram page.
    Then  User closes the page.

  Scenario: TC04 Visitor logs in to the main page
    Given Visitor goes to the easybusticket homepage.
    Then  Click on the Sign In button on the header.
    And   Verify that you are navigated to the Sign In page.
    But   Navigate to back.
    And   Click on the Sign Up button on the header.
    Then  Verify that you are navigated to the Sign Up page.
    Then  User closes the page.

  Scenario: TC05 Visitor logs in to the main page
    Given Visitor goes to the easybusticket homepage.
    Then  Click on the Easybusticket ikon  on the header.
    Then  Verify that the page refreshes when the Easybusticket Logo ikon is clicked
    Then  Click on the About button on the header.
    Then  Verify that you are navigated to the About page.
    But   Navigate to back.
    Then  Click on the FAQs button on the header.
    Then  Verify that you are navigated to the FAQs page.
    But   Navigate to back.
    Then  Click on the Blog button on the header.
    Then  Verify that you are navigated to the Blog page.
    But   Navigate to back.
    Then  Click on the Contact button on the header.
    Then  Verify that you are navigated to the Contact page.
    But   Navigate to back.
    Then  Click on the BUY TICKETS button on the header.
    Then  Verify that you are navigated to the Tickets page.
    Then  User closes the page.











