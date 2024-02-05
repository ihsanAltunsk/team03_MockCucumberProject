Feature: US13 As a registered user I should be able to access the ticket purchase page from
  the reservation menu on the user dashboard page and purchase tickets.

  Scenario: TC01 Registered User verifies the capability to access and purchase tickets from
  the ticket purchase page via the reservation menu on the user dashboard.

    Given User goes to the easybusticket homepage.
    Then User clicks on Sign In button and displays the Sign In page.
    And User clicks on Username box and enters a valid "senaydaUsername".
    And User clicks on Password box and enters a valid "senaydaPassword".
    And User clicks the Login button.
    And User displays the Dashboard page.
    Then User confirms that the menu and its items are visible and accessible.
    But User waits for 1 seconds.
    And In the booking menu, locate and click on the Buy Ticket link
    And User ensures the ticket purchase screen loads correctly
    And User enters the required ticket information (destination, date).
    But User waits for 1 seconds.
    And User clicks on the Find Ticket button.
    And User verifies that available ticket options are displayed
    And User clicks on the Select Seat button for a chosen ticket option.
    Then User selects a gender and chooses a seat on the seat selection screen.
    And User selects one of the available seats
    And User confirms the ticket price is displayed.
    And User clicks on the Continue button to proceed.
    Then User clicks on Confirm button
    And User verifies the displayed payment text on the subsequent page.
    And User ensures the Pay Now button is present and functional.
    And User clicks on the Pay Now button.
    Then User click on Confirm button to payment
    And User confirms redirect to the payment screen.
    And User clicks again Pay now button to continue
    And User enters valid credit card information.
    Then User submits the payment.
    And User ensures the payment confirmation or success message is displayed.
    And After successful payment, User verifies that ticket details are displayed.
    Then User confirms the accuracy of the ticket information.
    And User ensures the purchased ticket is listed.
    And User clicks on the Print Ticket button next to the purchased ticket.
    And User verifies redirection to the ticket printing page and ensure the ticket details are correct.
    Then User Download and verify the ticket.