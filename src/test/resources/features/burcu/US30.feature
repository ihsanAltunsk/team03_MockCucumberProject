Feature:  US30 User goes  to the easybusticket homepage.

  Scenario:

    Given Admin goes to the -qa.easybusticket.com admin-
    Then  Admin clicks on -Username- box and enters a valid "burcuAdminUsername".
    And   Admin clicks on -Password- box and enters a valid "burcuAdminPassword".
    And   Admin clicks on the -Login- button.
    Then  Admin displays the -Admin Dashboard- page.
    And Admin should be able to see the counter link in the trasport manager menu in the left menu on the dashboard page.
    And Admin clicks on add new button
    And Add counter  username is added
    And The city name is added to the counter
    And The counter should be added to the location.
    And A phone number must be added to the meter
    And Admin clicks on  counter.
    And Admin  verfies that new added counter is visible.

