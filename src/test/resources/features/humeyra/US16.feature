Feature: US16 User accesses  ticket history from the Ticket menu

  Scenario: TC01 User accesses the support history page through the requests link for displaying.
    Given User goes to the easybusticket homepage.
    Then User clicks on Sign In button and displays the Sign In page.
    And  User clicks on Username box and enters a valid "humeyraSignInUsername".
    And  User clicks on Password box and enters a valid "humeyraSignInPassword".
    And  User clicks the Login button.
    Then User displays the Dashboard page.
    Then User click on Support Request link and chooses Requests link
    Then User clicks on Action button
    Then Verify that the details of each past request are visible
    Then User closes the page.
@
    Scenario: TC02 User creates a new support request by clicking on the "New Ticket" button on the support history page
      Given User goes to the easybusticket homepage.
      Then User clicks on Sign In button and displays the Sign In page.
      And  User clicks on Username box and enters a valid "humeyraSignInUsername".
      And  User clicks on Password box and enters a valid "humeyraSignInPassword".
      And  User clicks the Login button.
      Then User displays the Dashboard page.
      Then User click on Support Request link and chooses Requests link
      Then User click on New Ticket button
      Then User clicks on Subject box and enter his-her message "humeyraSubjectMessage"
      Then User click on priority dropdown and choose one
      Then User clicks on message button and enter her-his message "humeyraMessage"
      Then User clicks on Dosya Sec button and selects a valid file from her-his folder according to allowed file extensions
      Then User clicks on Submit button
      Then Verify that Support ticket is created successfully is displayed


