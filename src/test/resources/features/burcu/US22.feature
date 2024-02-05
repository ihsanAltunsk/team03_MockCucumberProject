Feature: US22 User goes  to the easybusticket homepage.

  Scenario: As admin, I should be able to view items and functions active on the dashboard page.

   Given Admin goes to the -qa.easybusticket.com admin-
   Then Admin clicks on -Username- box and enters a valid "burcuAdminUsername".
   And Admin clicks on -Password- box and enters a valid "burcuAdminPassword".
   And Admin clicks on the -Login- button.
   And  Admin displays the -Admin Dashboard- page.
   And User clicks on View All button for Total Users.
   And User displays Manage Users page.
   And User clicks on View All button for TotalEmailUnverifiedUsers.
   And User displays Manage Users page.
   Then User clicks on View All button for TotalSMSUnverifiedUsers.
   And User displays "Manage Users" page.
