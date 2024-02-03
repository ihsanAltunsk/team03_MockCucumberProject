Feature: US04 User goes  to the easybusticket homepage

  Scenario: I should be able to view the footer when I access the site
    Given User goes to the easybusticket homepage.
    Then  User clicks 'Allow Cookies' button in pop menu.
    And   User scrolls all the way down.
    And   User sees the footer menu.

    Scenario:   I should be able to view the footer  when I access the site, then navigate to 'FAQs' under 'Useful Links
      Given  User goes to the easybusticket homepage.
      Then   User clicks 'Allow Cookies' button in pop menu.
      And    User scrolls all the way down.
      And    User sees 'About Us' under the 'Useful Links' Menu.

      Scenario:  I should be able to view the footer  when I access the site, then navigate to 'FAQs' under 'Useful Links'. Then User naviagetes to 'FAQs' page
        Given  User goes to the easybusticket homepage.
        Then    User clicks 'Allow Cookies' button in pop menu.
        And     User scrolls all the way down.
        And    User clicks 'FAQs' on the footer menu

        Scenario:  I should be able to view the footer  when I access the site, then navigate to 'FAQs' under 'Useful Links'. Then User naviagetes to 'Blog' page
          Given   User goes to the easybusticket homepage.
          Then    User clicks 'Allow Cookies' button in pop menu.
          And    User scrolls all the way down.
          And    Blog on the footer menu click.

          Scenario: I should be able to view the footer  when I access the site, then navigate to 'FAQs' under 'Useful Links'. Then User naviagetes to 'Contact' page
            Given User goes to the easybusticket homepage.
            Then User clicks 'Allow Cookies' button in pop menu.
            And  User scrolls all the way down.
            And  click on the contact menu on the home page.

            Scenario:  When I accessed the site, I saw the useful links section in the footer section and the links under it.
            I must be able to verify that it is viewable and active. Then User navigates to 'Privacy Policy'.
           Given User goes to the easybusticket homepage.
            Then User clicks 'Allow Cookies' button in pop menu.
              And  User scrolls all the way down.
              And clicks on the privacy policy in the footer.















