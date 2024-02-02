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
    @Given("User goes to the {string} homepage.")
    public void userGoesToTheHomepage(String site) {
        Driver.getDriver().get(ConfigReader.getProperty(site));
    }

    @Then("User clicks on Sign In button and displays the Sign In page.")
    public void userClicksOnSignInButtonAndDisplaysTheSignInPage() {
        visitorHomePage.singInButton.click();

        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qa.easybusticket.com/login";
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'Sign In' page!");
    }
}
