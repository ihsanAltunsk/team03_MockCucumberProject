package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.user.UserSignIn;
import pages.visitor.VisitorHomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class EasyBusTicketUser {
    VisitorHomePage visitorHomePage = new VisitorHomePage();
    UserSignIn userSignIn = new UserSignIn();
    SoftAssert softAssert = new SoftAssert();
    String actualUrl, expectedUrl;

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


}
