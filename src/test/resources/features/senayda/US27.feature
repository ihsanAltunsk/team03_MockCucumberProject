Feature: US27 As an administrator, admin should be able to access and view the pages for automatic
  and manual payment channels through the Payment Channels menu. Admin should be able to search through
  the pages, add new payment channels, and delete any previously added ones.
  Additionally, the information displayed on the pages should be clear and accurate.

  Background: User accesses to the Admin Dashboard via Admin Login
    Given Admin goes to the -qa.easybusticket.com admin-
    Then  Admin clicks on -Username- box and enters a valid "senaydaAdminUsername".
    And   Admin clicks on -Password- box and enters a valid "senaydaAdminPassword".
    And   Admin clicks on the -Login- button.
    Then  Admin displays the -Admin Dashboard- page.
    And User verify the presence of the Payment Gateways menu and its sub-menus.

Scenario: TC01 Admin accesses to the automatic gateways via Payment Gateways menu.

  Given User verify the presence of the Payment Gateways menu and its sub-menus.
  Then User click on the link associated with Automatic Gateways under the Payment Gateways menu
  And User displays Automatic Gateways page

  Scenario: TC02 Admin accesses to the manuel gateways via Payment Gateways menu for editing.

   Given User click on the link associated with Manuel Gateways under the Payment Gateways menu
   And User displays Manuel Gateways page
   And  User click Add new button
   And User enters Gateway Name "senaydaGatewayName"
   And User enters "senaydaCurrency"
   And User enters Rate "senaydaRate"


