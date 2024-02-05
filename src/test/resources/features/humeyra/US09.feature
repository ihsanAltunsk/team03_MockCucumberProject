Feature: US09 User can not register invalid information

  Scenario Outline: : TC01 User cannot register invalid password
     Given  User goes to the easybusticket homepage.
    Then User clicks on Sign up button
    Then User displays  Sign up your account
    Then User clicks on firstname box and enters a valid "humeyraSignUpFirstName".
    Then User clicks on Lastname box and enter a valid "humeyraSignUpLastName"
    Then User clicks on country box and choose a country "humeyraSignUpCountry"
    Then User clicks on mobile box and enter a valid mobile number "humeyraSignUpMobile"
    Then User clicks on user name box and enter a valid user name "humeyraSignUpUserName"
    Then User clicks on e mail box and enter a valid email address "humeyraSignUpEmail"
    Then User clicks on password box and enter invalid password "<givenInvalidPasswords>"
    Then User clicks on confirm password box and enter password "<givenConfirmPasswords>"
    Then User clicks on Accepting all checkbox
    Then User clicks on sign Up button
    Then Verify that user can't register "<givenAlert>"

    Examples:
    |givenInvalidPasswords        |givenConfirmPasswords                |givenAlert   |
    |humeyraSignUpInvalidPassword1|humeyraSignUpConfirmInvalidPassword1 |humeyraAlert1|
    |humeyraSignUpInvalidPassword2|humeyraSignUpConfirmInvalidPassword2 |humeyraAlert2|
    |humeyraSignUpInvalidPassword3|humeyraSignUpConfirmInvalidPassword3 |humeyraAlert3|
    |humeyraSignUpInvalidPassword4|humeyraSignUpConfirmInvalidPassword4 |humeyraAlert4|

