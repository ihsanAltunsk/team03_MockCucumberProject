Feature: US18 Registered User changes his/her password.

      Scenario: TC01 Registered User changes his/her password via password change page
        Given User goes to the easybusticket homepage.
        Then  User clicks on Sign In button and displays the Sign In page.
        And   User clicks on Username box and enters a valid "ihsanUsername".
        And   User clicks on Password box and enters a valid "ihsanPassword".
        And   User clicks the Login button.
        Then  User displays the Dashboard page.
        Then  User clicks the -Profile- button and clicks -Change Password- from the selection menu.
        And   User displays the -Change Password- page.
        Then  User clicks -Current Password- box and enters "ihsanPassword" password.
        And   User clicks -Password- box and enters "ihsanNewPassword" password.
        And   User clicks -Confirm Password- box and enters "ihsanNewPassword" password.
        But   User waits for 1 seconds.
        And   User clicks on -Change Password- button and verifies that -Password changes succesfully- text appeared.
        Then  User closes the page.

      Scenario Outline: TC02 Registered User can not change his/her old password via password change page with wrong credentals.
        Given User goes to the easybusticket homepage.
        Then  User clicks on Sign In button and displays the Sign In page.
        And   User clicks on Username box and enters a valid "ihsanUsername".
        And   User clicks on Password box and enters a valid "ihsanPassword".
        And   User clicks the Login button.
        Then  User displays the Dashboard page.
        Then  User clicks the -Profile- button and clicks -Change Password- from the selection menu.
        And   User displays the -Change Password- page.
        Then  User clicks -Current Password- box and enters "<givenCPassword>" password.
        And   User clicks -Password- box and enters "<givenNPassword>" password.
        And   User clicks -Confirm Password- box and enters "<givenN2Password>" password.
        And   User clicks on Change Password button and verifies that "<error text>" appeared.
        Then  User closes the page.

        Examples:
        | givenCPassword     | givenNPassword     | givenN2Password    | error text                |
        | ihsanPassword      | ihsanNewPassword   | ihsanWrongPassword | ihsanPasswordChangeError  |
        | ihsanPassword      | ihsanWrongPassword | ihsanNewPassword   | ihsanPasswordChangeError  |
        | ihsanWrongPassword | ihsanNewPassword   | ihsanNewPassword   | ihsanPasswordChangeError2 |
        | ihsanPassword      | ihsanPassword      | ihsanPassword      | ihsanPasswordChangeError  |