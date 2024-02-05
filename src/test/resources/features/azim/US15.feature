Feature: US015 Registered user creates a new ticket from the ticket support menu.

  Background User accesses to the  via Support Request menüsüne Login
    Given User goes to the easybusticket homepage.
    Then  User clicks on Sign In button and displays the Sign In page.
    And   User clicks on Username box and enters a valid "azimUsername".
    And   User clicks on Password box and enters a valid "azimPassword".
    And   User clicks the Login button.

  Scenario: TC01 Displays the request creation page from the Support Request menu.




  Scenario: TC02 On the new request creation page, you can fill out the form and create a request.
    Then In the drop-down list that opens, click on the Create New button.
    And  User clicks on the name box.Then User on the name box  enter a valid name
    Then User on the Email address box  enter a valid Email address
    Then User clicks on the Subject box
    Then User on the Subject box  enter a valid support
    Then User click on priority dropdown.
    Then User on priority dropdown and choose one
    Then User clicks on message button.
    Then Select File"selects a valid file from her/his folder according to allowed file extensions
    Then User clicks the "Submit" button.
    Then Verify that the new request form was successfully created.



  Scenario: TC03 Displays the request created and the registration information of the request.




  Scenario: TC04 Action butonu ile oluşturduğu talebin ayrıntılarına ulaşır.

