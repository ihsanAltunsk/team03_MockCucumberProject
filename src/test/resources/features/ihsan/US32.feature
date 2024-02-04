Feature: US32 As an administrator, I should have the ability to view and manage options under the Manage Trips menu.

  Background: User accesses to the Admin Dashboard via Admin Login
    Given Admin goes to the -qa.easybusticket.com admin-
    Then  Admin clicks on -Username- box and enters a valid "ihsanAdminUsername".
    And   Admin clicks on -Password- box and enters a valid "ihsanAdminPassword".
    And   Admin clicks on the -Login- button.
    Then  Admin displays the -Admin Dashboard- page.

      Scenario: TC01 Administrator accesses to route page via manage trips menu for editing
        And  User clicks on -Manage Trips- menu button and clicks on -Route- option.
        Then User displays -Route- page.
        And  User clicks -Add New- button.
        Then User displays -Create Route- page.
        And  User clicks on -Name box- and enters a valid "ihsanRouteName".
        And  User clicks on -Start From- menu and selects an option.
        But  User waits for 1 seconds.
        And  User clicks on -End To- menu and selects an option.
        And  User clicks on -Time- box and enters a valid "ihsanRouteTime".
        And  User clicks on -Distance- box and enters a valid "ihsanRouteDistance".
        Then User clicks on -Save- button.
        And  User verifies that -Route save successfully- text appeared.
        And  User clicks on -Go Back- button.
        Then User displays -Route- page.
        And  User verifies that new route is added.
        Then User closes the page.

      Scenario: TC02 Administrator accesses to schedule page via manage trips menu for editing
        And  User clicks on -Manage Trips- menu button and clicks on -Schedule- option.
        Then User displays -Schedule- page.
        And  User clicks Schedule-Add New- button.
        Then User displays -Add Schedule- page.
        And  User clicks on -Start From- box and enters a valid "ihsanScheduleStartFrom".
        And  User clicks on -End At- box and enters a valid "ihsanScheduleEndAt".
        Then User clicks on Schedule -Save- button.
        But  User waits for 1 seconds.
        And  User verifies that -Schedule save successfully- text appeared.
        And  User verifies that the schedule is added.
        Then User closes the page.

      Scenario: TC03 Administrator accesses to ticket price page via manage trips menu for editing
        And  User clicks on -Manage Trips- menu button and clicks on -Ticket Price- option.
        Then User displays -Ticket Price- page.
        And  User clicks Ticket Price -Add New- button.
        Then User displays -Add Ticket Price- page.
        And  User clicks on -Fleet Type- menu and selects an option.
        And  User clicks on -Route- menu and selects an option.
        And  User clicks on -Price For Source To Destination- box and enters a valid "ihsanTicketPrice".
        And  User clicks on newly opened price box and enters a valid "ihsanTicketPrice2".
        Then User clicks on Ticket Price -Save- button.
        And  User verifies that -Ticket price added successfully- text appeared.
        And  User clicks on Ticket Price -Go Back- button.
        Then User displays -Ticket Price- page.
        And  User verifies that new ticket price is added.
        Then User closes the page.

      Scenario: TC04 Administrator accesses to trip page via manage trips menu for editing
        And  User clicks on -Manage Trips- menu button and clicks on -Trip- option.
        Then User displays -Trip- page.
        And  User clicks Trip-Add New- button.
        But  User waits for 1 seconds.
        Then User displays -Add Trip- page.
        And  User clicks on Trip-Fleet Type- menu and selects an option.
        And  User clicks on Trip-Route- menu and selects an option.
        And  User clicks on -Schedule- menu and selects an option.
        And  User clicks on Trip-Start From- menu and selects an option.
        And  User clicks on Trip-End To- menu and selects an option.
        And  User clicks on -Day Off- menu and selects an option.
        Then User clicks on Trip-Save- button.
        But  User waits for 1 seconds.
        And  User verifies that -Trip save successfully- text appeared.
        And  User verifies that new trip is added.
        Then User closes the page.

      Scenario: TC05 Administrator accesses to assigned vehicle page via manage trips menu for editing
        And  User clicks on -Manage Trips- menu button and clicks on -Assigned Vehicle- option.
        Then User displays -Assigned Vehicle- page.
        And  User clicks Assigned Vehicle-Add New- button.
        But  User waits for 1 seconds.
        Then User displays -Assign Vehicle- page.
        And  User clicks on -Trip- menu and selects an option.
        And  User clicks on -Vehicle- menu and selects an option.
        Then User clicks on Assigned Vehicle-Save- button.
        But  User waits for 1 seconds.
        And  User verifies that -Vehicle assigned successfully- text appeared.
        And  User verifies that new vehicle is added.
        Then User closes the page.

      Scenario: TC06 Administrator accesses to route page via manage trips menu for editing
        And  User clicks on -Manage Trips- menu button and clicks on -Route- option.
        Then User displays -Route- page.
        And  User clicks on -Disable Route- button for the added route.
        Then User clicks on -Disable- option.
        And  User verifies that the route is disabled.
        Then User clicks on -Update Route- button for the added route.
        And  User displays -Update Route- page.
        And  User clicks on -Name- box and enters a valid updated "ihsanRouteNameUpdated".
        Then User clicks on -Save Changes- button.
        But  User waits for 1 seconds.
        And  User verifies that -Route update successfully- text appeared.
        And  User clicks on Route-Go Back- button.
        Then User displays -Route- page.
        And  User verifies that the route is updated.
        Then User closes the page.

      Scenario: TC07 Administrator accesses to schedule page via manage trips menu for editing
        And  User clicks on -Manage Trips- menu button and clicks on -Schedule- option.
        Then User displays -Schedule- page.
        And  User clicks on -Disable Schedule- button for the added Schedule.
        Then User clicks on schedule-Disable- option.
        And  User verifies that the Schedule is disabled.
        Then User clicks on -Update Schedule- button for the added Schedule.
        And  User displays -Update Schedule- page.
        And  User clicks on -Start From- box and enters a valid updated "ihsanScheduleStartFromUpdated".
        Then User clicks on -Update- button.
        And  User closes the page.

      Scenario: TC08 Administrator accesses to ticket price page via manage trips menu for editing
        And  User clicks on -Manage Trips- menu button and clicks on -Ticket Price- option.
        Then User displays -Ticket Price- page.
        And  User clicks on -Delete- button for the added ticket price.
        Then User confirms by clicking -Delete- button.
        But  User waits for 1 seconds.
        And  User verifies that -Price Deleted Successfully- text appeared.
        And  User verifies -Ticket Price- has been deleted.
        Then User clicks on -Edit- button for the added ticket price.
        And  User displays -Update Ticket Price- page.
        And  User clicks on price box and enters a valid "ihsanUpdatedTicketPrice".
        Then User clicks on ticket price-Update- button.
        But  User waits for 1 seconds.
        And  User verifies that -Price Updated Successfully- text appeared.
        Then User clicks on Ticket Price -Go Back- button.
        And  User displays -Ticket Price- page.
        And  User verifies that the ticket price is updated.
        Then User closes the page.

      Scenario: TC09 Administrator accesses to trip page via manage trips menu for editing
        And  User clicks on -Manage Trips- menu button and clicks on -Trip- option.
        Then User displays -Trip- page.
        And  User clicks on -Disable- button for the added trip.
        And  User clicks on Trip-Disable- option.
        But  User waits for 1 seconds.
        Then User verifies that -Trip disabled successfully- text appeared.
        And  User verifies that the -Trip- is disabled.
        And  User clicks on -Edit- button for the added trip.
        But  User waits for 1 seconds.
        Then User displays -Update Trip- page.
        And  User clicks on -Title- box and enters an "ihsanUpdatedTripTitle".
        Then User clicks on Trip-Update- button.
        And  User clicks on close button.
        Then User verifies that the trip is updated.
        And  User closes the page.

      Scenario: TC10 Administrator accesses to assigned vehicle page via manage trips menu for editing
        And  User clicks on -Manage Trips- menu button and clicks on -Assigned Vehicle- option.
        Then User displays -Assigned Vehicle- page.
        And  User clicks on -Edit- button for the added vehicle.
        But  User waits for 1 seconds.
        Then User displays -Update Assigned Vehicle- page.
        And  User clicks on -Trip- menu and selects an updated option.
        And  User clicks on -Vehicle- menu and selects an updated option.
        Then User clicks on Assigned Vehicle-Update- button.
        But  User waits for 1 seconds.
        And  User verifies that -Assigned vehicle update successfully.- text appeared.
        And  User verifies that the vehicle is updated.
        Then User closes the page.