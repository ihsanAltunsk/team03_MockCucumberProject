Feature: US08 User goes  to the easybusticket homepage.

  Scenario: When I access the site, I should be able to view the contact page when I click on the Contact link in the header section.
    Given User goes to the easybusticket homepage.
    Then User clicks 'Allow Cookies' button in pop menu.
    And User clicks 'Contact' button on Header menu.
    And Click on contact from the footer menu.



    Scenario: When I access the page, I should be able to view address, phone, e-mail information and I should be able to verify that phone and mail items are active.
      Given User goes to the easybusticket homepage.

      And User should be landed on 'Contact' page.
      And User should be able to see address, phone, e-meail infos.
      And User clicks phone number.
      And User displays phone alert.

      Scenario: When I access the page, I should be able to view address, phone, e-mail information and I should be able to verify that phone and mail items are active.
        Given User goes to the easybusticket homepage.

        And User should be landed on 'Contact' page.
        And User should be able to see address, phone, e-meail infos.
        And User clicks e-mail string.
        And User displays e-mail alert.

        Scenario: I should be able to view the contact form when I access the page and I need to be able to verify that I can send messages.
          Given User goes to the easybusticket homepage.
          Then User should be landed on 'Contact' page.
          And User fill Name, Email, Subject, Your Message boxes.
          And User clicks 'Send Message' Button.

          Scenario: I need to be able to see the map showing the location of the company when I enter the page.
            Given User goes to the easybusticket homepage.
            Then User should be landed on 'Contact' page.
