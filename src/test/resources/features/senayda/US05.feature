Feature: US05  visitor should be able to access the page with information about
          the company and view information about the company.

  Scenario: TC01 User enters into about page

    Given Visitor goes to the easybusticket homepage.
    Then User identifies and locate the About link within the header section.
    And User clicks on the About link.
    But User waits for 1 seconds.
    And User verifies that the About page loads correctly without any errors or delays.
    But User waits for 1 seconds.
   Then User confirms that the displayed information matches the expected details on about page.
    Then  User closes the page.