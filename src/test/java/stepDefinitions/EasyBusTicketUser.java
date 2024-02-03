package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import pages.user.UserSignIn;
import pages.user.UserSignUp;
import pages.user.registeredUser.ChangePassword;
import pages.user.registeredUser.Profile;
import pages.visitor.VisitorHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class EasyBusTicketUser {
    Actions actions = new Actions(Driver.getDriver());
    Profile profile = new Profile();
    ChangePassword changePassword = new ChangePassword();
    VisitorHomePage visitorHomePage = new VisitorHomePage();
    UserSignIn userSignIn = new UserSignIn();
    SoftAssert softAssert = new SoftAssert();
    String actualUrl,expectedUrl;
    UserSignUp userSignUp = new UserSignUp();
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
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'Change Password' page!");    }

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
}
