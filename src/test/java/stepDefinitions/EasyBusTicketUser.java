package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import pages.user.UserSignIn;
import pages.user.UserSignUp;
import pages.visitor.VisitorHomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class EasyBusTicketUser {
    VisitorHomePage visitorHomePage = new VisitorHomePage();
    UserSignIn userSignIn = new UserSignIn();
    UserSignUp userSignUp= new UserSignUp();
    SoftAssert softAssert = new SoftAssert();
    String actualUrl,expectedUrl;
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

        softAssert.assertAll();
    }

    @Then("User clicks on Sign up button")
    public void userClicksOnSignUpButton() {
        visitorHomePage.HeaderSignUp.click();
    }

    @Then("User displays  Sign up your account")
    public void userDisplaysSignUpYourAccount() {
        softAssert.assertTrue(userSignUp.labelSignUpYourAccount.isDisplayed(),"user did not display the text sign up your account");

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
        Select selectcountry=new Select(userSignUp.countryBox);
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
        String expectedAlert=alert;
        String actualAlert=userSignUp.alert.getText();
        softAssert.assertEquals(actualAlert,expectedAlert,"user can register3");
    }
}
