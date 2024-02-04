package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import io.cucumber.java.en.But;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import pages.user.UserSignIn;
import pages.user.UserSignUp;
import pages.user.registeredUser.BuyTicket;
import pages.user.registeredUser.ChangePassword;
import pages.user.registeredUser.Profile;
import pages.user.registeredUser.UserDashboard;
import pages.visitor.VisitorAbout;
import pages.visitor.VisitorHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class EasyBusTicketUser {
    String actualUrl, expectedUrl;
    Actions actions = new Actions(Driver.getDriver());
    Profile profile = new Profile();
    ChangePassword changePassword = new ChangePassword();
    VisitorHomePage visitorHomePage = new VisitorHomePage();
    UserSignIn userSignIn = new UserSignIn();
    UserSignUp userSignUp = new UserSignUp();
    SoftAssert softAssert = new SoftAssert();
    UserDashboard userDashboard = new UserDashboard();
    BuyTicket buyTicket = new BuyTicket();
    @Given("User goes to the easybusticket homepage.")
    public void userGoesToTheHomepage() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }

    @Then("User clicks on Sign In button and displays the Sign In page.")
    public void userClicksOnSignInButtonAndDisplaysTheSignInPage() {
        visitorHomePage.singInButton.click();

        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/login";
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'Sign In' page!");
    }

    @Then("User clicks on Username box and enters a valid {string}.")
    public void user_clicks_on_username_box_and_enters_a_valid(String username) {
        userSignIn.usernameBox.click();
        userSignIn.usernameBox.sendKeys(ConfigReader.getProperty(username));
    }

    @Then("User clicks on Password box and enters a valid {string}.")
    public void user_clicks_on_password_box_and_enters_a_valid(String password) {
        userSignIn.passwordBox.click();
        userSignIn.passwordBox.sendKeys(ConfigReader.getProperty(password));
    }

    @Then("User clicks the Login button.")
    public void user_clicks_the_login_button() {
        userSignIn.loginButton.click();
    }

    @Then("User displays the Dashboard page.")
    public void user_displays_the_dashboard_page() {
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/user/dashboard";
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'Dashboard' page!");
    }

    @Then("User verifies that -These credentials do not match our records.- error text appeared.")
    public void userVerifiesThatTheseCredentialsDoNotMatchOurRecordsErrorTextAppeared() {
        String actualError = userSignIn.labelError.getText();
        String expectedError = "These credentials do not match our records.";
        softAssert.assertEquals(actualError, expectedError, "Error text DID NOT appear!");
    }

    @Then("User closes the page.")
    public void userClosesThePage() {
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @But("User waits for {int} seconds.")
    public void userWaitsForSeconds(int duration) {
        try {
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("User clicks the Profile button and clicks Change Password from the selection menu.")
    public void userClicksTheProfileButtonAndClicksChangePasswordFromTheSelectionMenu() {
        actions.moveToElement(profile.liProfile).perform();
        ReusableMethods.bekle(1);
        profile.ChangePassword.click();
    }

    @And("User displays the Change Password page.")
    public void userDisplaysTheChangePasswordPageAnd() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qa.easybusticket.com/user/change-password";
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'Change Password' page!");
    }

    @And("User clicks on Change Password button and verifies that Password changes succesfully text appeared.")
    public void userClicksOnChangePasswordButtonAndVerifiesThatPasswordChangesSuccesfullyTextAppeared() {
        changePassword.changePasswordButton.click();

        String actualText = changePassword.labelPasswordAlert.getText();
        String expectedText = "Password changes succesfully";
        softAssert.assertEquals(actualText, expectedText, "'Password changes succesfully' text DID NOT appear!");
    }

    @Then("User clicks Current Password box and enters {string} password.")
    public void userClicksCurrentPasswordBoxAndEntersPassword(String password) {
        changePassword.currentPasswordBox.sendKeys(ConfigReader.getProperty(password));
    }

    @And("User clicks Password box and enters {string} password.")
    public void userClicksPasswordBoxAndEntersPassword(String password) {
        changePassword.passwordBox.sendKeys(ConfigReader.getProperty(password));
    }

    @And("User clicks Confirm Password box and enters {string} password.")
    public void userClicksConfirmPasswordBoxAndEntersPassword(String password) {
        changePassword.confirmPasswordBox.sendKeys(ConfigReader.getProperty(password));
    }

    @And("User clicks on Change Password button and verifies that The password confirmation does not match appeared.")
    public void userClicksOnChangePasswordButtonAndVerifiesThatThePasswordConfirmationDoesNotMatchAppeared() {
        changePassword.changePasswordButton.click();
        ReusableMethods.bekle(1);
        String actualText = changePassword.labelPasswordAlert2.getText();
        String expectedText = "The password confirmation does not match.";
        softAssert.assertEquals(actualText, expectedText, "'The password confirmation does not match.' text DID NOT appear!");
    }

    @Given("Visitor goes to the easybusticket homepage.")
    public void visitor_goes_to_the_easybusticket_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }

    @Then("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/";
        softAssert.assertEquals(actualUrl, expectedUrl, "Visitor DID NOT display the 'Sign In' page!");
        softAssert.assertAll();
    }

    @Then("User clicks on Sign up button")
    public void userClicksOnSignUpButton() {
        visitorHomePage.HeaderSignUp.click();
    }

    @Then("User displays  Sign up your account")
    public void userDisplaysSignUpYourAccount() {
        softAssert.assertTrue(userSignUp.labelSignUpYourAccount.isDisplayed(), "user did not display the text sign up your account");

    }

    @Then("User clicks on firstname box and enters a valid {string}.")
    public void userClicksOnFirstnameBoxAndEntersAValid(String firstName) {
        userSignUp.firstNameBox.click();
        userSignUp.firstNameBox.sendKeys(ConfigReader.getProperty("humeyraSignUpFirstName"));
    }

    @Then("User clicks on Lastname box and enter a valid {string}")
    public void userClicksOnLastnameBoxAndEnterAValid(String lastName) {
        userSignUp.lastNameBox.click();
        userSignUp.lastNameBox.sendKeys(ConfigReader.getProperty("humeyraSignUpLastName"));
    }

    @Then("User clicks on country box and choose a country {string}")
    public void userClicksOnCountryBoxAndChooseACountry(String Country) {
        Select selectcountry = new Select(userSignUp.countryBox);
        selectcountry.selectByValue(ConfigReader.getProperty("humeyraSignUpCountry"));
    }

    @Then("User clicks on mobile box and enter a valid mobile number {string}")
    public void userClicksOnMobileBoxAndEnterAValidMobileNumber(String mobileNumber) {
        userSignUp.mobileBox.click();
        userSignUp.mobileBox.sendKeys(ConfigReader.getProperty("humeyraSignUpMobile"));
    }

    @Then("User clicks on user name box and enter a valid user name {string}")
    public void userClicksOnUserNameBoxAndEnterAValidUserName(String userName) {
        userSignUp.usernameBox.click();
        userSignUp.usernameBox.sendKeys(ConfigReader.getProperty("humeyraSignUpUserName"));
    }

    @Then("User clicks on e mail box and enter a valid email address {string}")
    public void userClicksOnEMailBoxAndEnterAValidEmailAddress(String emailAddress) {
        userSignUp.emailBox.click();
        userSignUp.emailBox.sendKeys(ConfigReader.getProperty("humeyraSignUpEmail"));
    }


    @Then("User clicks on password box and enter invalid password {string}")
    public void userClicksOnPasswordBoxAndEnterInvalidPassword(String invalidPassword) {
        userSignUp.passwordBox.click();
        userSignUp.passwordBox.sendKeys(ConfigReader.getProperty(invalidPassword));
    }

    @Then("User clicks on confirm password box and enter password {string}")
    public void userClicksOnConfirmPasswordBoxAndEnterPassword(String confirmPassword) {
        userSignUp.confirmPasswordBox.click();
        userSignUp.confirmPasswordBox.sendKeys(ConfigReader.getProperty(confirmPassword));
    }

    @Then("User clicks on Accepting all checkbox")
    public void userClicksOnAcceptingAllCheckbox() {
        userSignUp.acceptingAllCheckbox.click();
    }

    @Then("User clicks on sign Up button")
    public void userClicksOnsignUpButton() {
        userSignUp.signUpButton.click();
    }

    @Then("Verify that user can't register {string}")
    public void verifyThatUserCanTRegister(String alert) {
        String expectedAlert = alert;
        String actualAlert = userSignUp.alert.getText();
        softAssert.assertEquals(actualAlert, expectedAlert, "user can register3");
    }

    @Then("Verify that header is visible successfully")
    public void verify_that_header_is_visible_successfully() {
        softAssert.assertTrue(visitorHomePage.singInButton.isDisplayed(), "header isn't visible successfully");
        softAssert.assertAll();
    }

    @Then("User clicks {string} button in pop menu.")
    public void user_clicks_button_in_pop_menu(String string) {
        visitorHomePage.cookiesAllow.click();
    }

    @Then("User scrolls all the way down.")
    public void user_scrolls_all_the_way_down() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();

        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    @Then("User sees the footer menu.")
    public void user_sees_the_footer_menu() {
        Assert.assertTrue(visitorHomePage.Ticketpolicies.isDisplayed());
    }

    @Then("User sees {string} under the {string} Menu.")
    public void user_sees_under_the_menu(String string, String string2) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();


        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Assert.assertTrue(visitorHomePage.footerabout.isDisplayed());
    }

    @Then("User clicks {string} on the footer menu")
    public void user_clicks_on_the_footer_menu(String string) {
        visitorHomePage.footerFAQs.click();
    }

    @Then("Blog on the footer menu click.")
    public void blog_on_the_footer_menu_click() {
        visitorHomePage.footerblog.click();
    }

    @Then("click on the contact menu on the home page.")
    public void click_on_the_contact_menu_on_the_home_page() {
        visitorHomePage.footercontact.click();
    }


    @Then("clicks on the privacy policy in the footer.")
    public void clicks_on_the_privacy_policy_in_the_footer() {
        visitorHomePage.footerprivacypolicy.click();


    }

    @Then("Visitor homapage header displays web elements")
    public void visitorHomapageHeaderDisplaysWebElements() {
        SoftAssert softAssert = new SoftAssert();
        VisitorHomePage visitorHomePage = new VisitorHomePage();
        Driver.getDriver().get("https://qa.easybusticket.com");
        for (int i = 0; i < 20; i++) {
            softAssert.assertTrue(visitorHomePage.listr.get(i).isDisplayed());
        }
    }

    @Then("User identifies and locate the About link within the header section.")
    public void userIdentifiesAndLocateTheAboutLinkWithinTheHeaderSection() {
        VisitorHomePage visitorHomePage = new VisitorHomePage();
        Assert.assertTrue(visitorHomePage.HeaderAbout.isDisplayed());
    }

    @And("User clicks on the About link.")
    public void userClicksOnTheAboutLink() {
        visitorHomePage.HeaderAbout.click();
    }

    @And("User verifies that the About page loads correctly without any errors or delays.")
    public void userVerifiesThatTheAboutPageLoadsCorrectlyWithoutAnyErrorsOrDelays() {
        VisitorAbout visitorAbout = new VisitorAbout();
        Assert.assertTrue(visitorAbout.aboutTitle.isDisplayed());
    }

    @Then("User confirms that the displayed information matches the expected details on about page.")
    public void userConfirmsThatTheDisplayedInformationMatchesTheExpectedDetailsOnAboutPage() {
        VisitorAbout visitorAbout1 = new VisitorAbout();
        Assert.assertTrue(visitorAbout1.aboutPageTextInformation.isDisplayed());
    }

    @And("User confirms that the menu and its items are visible and accessible.")
    public void userConfirmsThatTheMenuAndItsItemsAreVisibleAndAccessible() {
        Assert.assertTrue(userDashboard.dashboardButton.isDisplayed());
        Assert.assertTrue(userDashboard.bookingButton.isDisplayed());
        Assert.assertTrue(userDashboard.supportRequestButton.isDisplayed());
        Assert.assertTrue(userDashboard.linkProfile.isDisplayed());
    }

    @And("In the booking menu, locate and click on the Buy Ticket link")
    public void inTheBookingMenuLocateAndClickOnTheBuyTicketLink() {
        userDashboard.bookingButton.click();
        userDashboard.buyTicketButton.click();
    }

    @And("User ensures the ticket purchase screen loads correctly")
    public void userEnsuresTheTicketPurchaseScreenLoadsCorrectly() {
        Assert.assertTrue(buyTicket.ticketPurchaseScreen.isDisplayed());
    }

    @And("User enters the required ticket information \\(destination, date).")
    public void userEntersTheRequiredTicketInformationDestinationDate() {
        Select pickUpPoint = new Select(visitorHomePage.dropDownPickupPoint);
        pickUpPoint.selectByVisibleText("Dallas");
        Select dropDownPoint = new Select(visitorHomePage.dropDownDroppingPoint);
        dropDownPoint.selectByVisibleText("Austin");
        visitorHomePage.dropDownDepartureDate.sendKeys(ConfigReader.getProperty("senaydaDepartureDate"));
    }

    @And("User clicks on the Find Ticket button.")
    public void userClicksOnTheFindTicketButton() {
        visitorHomePage.findTicketsButton.click();
    }

    @And("User verifies that available ticket options are displayed")
    public void userVerifiesThatAvailableTicketOptionsAreDisplayed() {
        Assert.assertTrue(buyTicket.ticketOptions.isDisplayed());
        buyTicket.selectSeatButton.sendKeys(Keys.DOWN);
        buyTicket.selectSeatButton.sendKeys(Keys.DOWN);
        buyTicket.selectSeatButton.sendKeys(Keys.DOWN);
        buyTicket.selectSeatButton.sendKeys(Keys.DOWN);
    }

    @And("User clicks on the Select Seat button for a chosen ticket option.")
    public void userClicksOnTheSelectSeatButtonForAChosenTicketOption() {
        buyTicket.selectSeatButton.click();
    }

    @And("User selects a gender and chooses a seat on the seat selection screen.")
    public void userSelectsAGenderAndChoosesASeatOnTheSeatSelectionScreen() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",
                buyTicket.checkBoxFemale);
        buyTicket.checkBoxFemale.click();
        buyTicket.selectSeatNumberButton.click();
    }

    @And("User selects one of the available seats")
    public void userSelectsOneOfTheAvailableSeats() {

    }

    @And("User confirms the ticket price is displayed.")
    public void userConfirmsTheTicketPriceIsDisplayed() {
    }

    @And("User clicks on the Continue button to proceed.")
    public void userClicksOnTheContinueButtonToProceed() {
    }

    @And("User clicks on Confirm button")
    public void userClicksOnConfirmButton() {
    }

    @And("User verifies the displayed payment text on the subsequent page.")
    public void userVerifiesTheDisplayedPaymentTextOnTheSubsequentPage() {
    }

    @And("User ensures the Pay Now button is present and functional.")
    public void userEnsuresThePayNowButtonIsPresentAndFunctional() {
    }

    @And("User clicks on the Pay Now button.")
    public void userClicksOnThePayNowButton() {
    }

    @And("User click on Confirm button to payment")
    public void userClickOnConfirmButtonToPayment() {
    }

    @And("User confirms redirect to the payment screen.")
    public void userConfirmsRedirectToThePaymentScreen() {
    }

    @And("User clicks again Pay now button to continue")
    public void userClicksAgainPayNowButtonToContinue() {
    }

    @And("User enters valid credit card information.")
    public void userEntersValidCreditCardInformation() {
    }

    @And("User submits the payment.")
    public void userSubmitsThePayment() {
    }

    @And("User ensures the payment confirmation or success message is displayed.")
    public void userEnsuresThePaymentConfirmationOrSuccessMessageIsDisplayed() {
    }

    @And("After successful payment, User verifies that ticket details are displayed.")
    public void afterSuccessfulPaymentUserVerifiesThatTicketDetailsAreDisplayed() {
    }

    @And("User confirms the accuracy of the ticket information.")
    public void userConfirmsTheAccuracyOfTheTicketInformation() {
    }

    @And("User ensures the purchased ticket is listed.")
    public void userEnsuresThePurchasedTicketIsListed() {
    }

    @And("User clicks on the Print Ticket button next to the purchased ticket.")
    public void userClicksOnThePrintTicketButtonNextToThePurchasedTicket() {
    }

    @Then("User verifies redirection to the ticket printing page and ensure the ticket details are correct.")
    public void userVerifiesRedirectionToTheTicketPrintingPageAndEnsureTheTicketDetailsAreCorrect() {
    }
}
