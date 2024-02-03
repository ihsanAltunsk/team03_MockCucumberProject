package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import pages.user.UserSignIn;
import pages.visitor.VisitorHomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class EasyBusTicketUser {
    VisitorHomePage visitorHomePage = new VisitorHomePage();
    UserSignIn userSignIn = new UserSignIn();
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
}
