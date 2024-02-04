Feature: US26 As an administrator, I should be able to access pages under the booking history menu

  Background: User accesses to the Admin Dashboard via Admin Login
    Given Admin goes to the -qa.easybusticket.com admin-
    Then  Admin clicks on -Username- box and enters a valid "ihsanAdminUsername".
    And   Admin clicks on -Password- box and enters a valid "ihsanAdminPassword".
    And   Admin clicks on the -Login- button.
    Then  Admin displays the -Admin Dashboard- page.

      Scenario: TC01 Administrator accesses to -Pending Ticket- page via -Booking History- menu
        And  User clicks on -Booking History- menu button and clicks on -Pending Ticket- option.
        Then User displays -Pending Ticket- page.
        And  User closes the page.

      Scenario: TC02 Administrator accesses to -Booked Ticket- page via -Booking History- menu
        And  User clicks on -Booking History- menu button and clicks on -Booked Ticket- option.
        Then User displays -Booked Ticket- page.
        And  User closes the page.

      Scenario: TC03 Administrator accesses to -Rejected Ticket- page via -Booking History- menu
        And  User clicks on -Booking History- menu button and clicks on -Rejected Ticket- option.
        Then User displays -Rejected Ticket- page.
        And  User closes the page.

      Scenario: TC04 Administrator accesses to -All Ticket- page via -Booking History- menu
        And  User clicks on -Booking History- menu button and clicks on -All Ticket- option.
        Then User displays -All Ticket- page.
        And  User closes the page.