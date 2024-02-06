package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashboard;
import pages.admin.AdminSignIn;
import pages.admin.counter.Counter;
import pages.admin.manageTrips.*;
import pages.admin.paymentGateways.AutomaticGateways;
import pages.admin.paymentGateways.ManuelGateways;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class EasyBusTicketAdmin {
    String actualUrl, expectedUrl, actualPage, expectedPage,
            actualText, expectedText, expectedAddition, actualAddition,
            fleetTypeText, startFromText, endToText, tripText, routeName,
            expectedUpdate, actualUpdate;
    SoftAssert softAssert = new SoftAssert();
    AdminDashboard adminDashboard = new AdminDashboard();
    AdminSignIn adminSignIn = new AdminSignIn();
    Route route = new Route();
    Schedule schedule = new Schedule();
    TicketPrice ticketPrice = new TicketPrice();
    Trip trip = new Trip();
    AssignedVehicle assignedVehicle = new AssignedVehicle();
    AutomaticGateways automaticGateways = new AutomaticGateways();
    ManuelGateways manuelGateways = new ManuelGateways();
    Counter counter=new Counter();
    @Given("Admin goes to the -qa.easybusticket.com admin-")
    public void adminGoesToTheQaEasybusticketComAdmin() {
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
    }

    @Then("Admin clicks on -Username- box and enters a valid {string}.")
    public void adminClicksOnUsernameBoxAndEntersAValid(String username) {
        adminSignIn.usernameBox.click();
        adminSignIn.usernameBox.sendKeys(ConfigReader.getProperty(username));
    }

    @And("Admin clicks on -Password- box and enters a valid {string}.")
    public void adminClicksOnPasswordBoxAndEntersAValid(String password) {
        adminSignIn.passwordBox.click();
        adminSignIn.passwordBox.sendKeys(ConfigReader.getProperty(password));
    }

    @And("Admin clicks on the -Login- button.")
    public void adminClicksOnTheLoginButton() {
        adminSignIn.loginButton.click();
    }

    @Then("Admin displays the -Admin Dashboard- page.")
    public void adminDisplaysTheAdminDashboardPage() {
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/admin/dashboard";
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'Admin Dashboard' page!");
    }

    @And("User clicks on -Booking History- menu button and clicks on -Pending Ticket- option.")
    public void userClicksOnBookingHistoryMenuButtonAndClicksOnPendingTicketOption() {
        adminDashboard.bookingHistoryButton.click();
        adminDashboard.pendingTicketButton.click();
    }

    @Then("User displays -Pending Ticket- page.")
    public void userDisplaysPendingTicketPage() {
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/admin/ticket/pending";
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'Pending Ticket' page!");
    }

    @And("User clicks on -Booking History- menu button and clicks on -Booked Ticket- option.")
    public void userClicksOnBookingHistoryMenuButtonAndClicksOnBookedTicketOption() {
        adminDashboard.bookingHistoryButton.click();
        adminDashboard.bookedTicketButton.click();
    }

    @Then("User displays -Booked Ticket- page.")
    public void userDisplaysBookedTicketPage() {
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/admin/ticket/booked";
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'Booked Ticket' page!");
    }

    @And("User clicks on -Booking History- menu button and clicks on -Rejected Ticket- option.")
    public void userClicksOnBookingHistoryMenuButtonAndClicksOnRejectedTicketOption() {
        adminDashboard.bookingHistoryButton.click();
        adminDashboard.rejectedTicketButton.click();
    }

    @Then("User displays -Rejected Ticket- page.")
    public void userDisplaysRejectedTicketPage() {
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/admin/ticket/rejected";
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'Rejected Ticket' page!");
    }

    @And("User clicks on -Booking History- menu button and clicks on -All Ticket- option.")
    public void userClicksOnBookingHistoryMenuButtonAndClicksOnAllTicketOption() {
        adminDashboard.bookingHistoryButton.click();
        adminDashboard.allTicketButton.click();
    }

    @Then("User displays -All Ticket- page.")
    public void userDisplaysAllTicketPage() {
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/admin/ticket/list";
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'All Ticket' page!");
    }

    @And("User clicks on -Manage Trips- menu button and clicks on -Route- option.")
    public void userClicksOnManageTripsMenuButtonAndClicksOnRouteOption() {
        adminDashboard.manageTripsButton.click();
        adminDashboard.routeButton.click();
    }

    @Then("User displays -Route- page.")
    public void userDisplaysRoutePage() {
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/admin/manage/route";
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'Route' page!");
    }

    @And("User clicks -Add New- button.")
    public void userClicksAddNewButton() {
        route.addNewButton.click();
    }

    @Then("User displays -Create Route- page.")
    public void userDisplaysCreateRoutePage() {
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/admin/manage/route/create";
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'Create Route' page!");
    }

    @And("User clicks on -Name box- and enters a valid {string}.")
    public void userClicksOnNameBoxAndEntersAValid(String routeName) {
        route.nameBox.sendKeys(ConfigReader.getProperty(routeName));
    }

    @And("User clicks on -Start From- menu and selects an option.")
    public void userClicksOnStartFromMenuAndSelectsAnOption() {
        Select selectStartFrom = new Select(route.dropDownStartFrom);
        selectStartFrom.selectByValue("1");
    }

    @And("User clicks on -End To- menu and selects an option.")
    public void userClicksOnEndToMenuAndSelectsAnOption() {
        Select selectEndTo = new Select(route.dropDownEndTo);
        selectEndTo.selectByValue("2");
    }

    @And("User clicks on -Time- box and enters a valid {string}.")
    public void userClicksOnTimeBoxAndEntersAValid(String routeTime) {
        route.timeBox.click();
        route.timeBox.sendKeys(ConfigReader.getProperty(routeTime));
    }

    @And("User clicks on -Distance- box and enters a valid {string}.")
    public void userClicksOnDistanceBoxAndEntersAValid(String routeDistance) {
        route.distanceBox.click();
        route.distanceBox.sendKeys(ConfigReader.getProperty(routeDistance));
    }

    @Then("User clicks on -Save- button.")
    public void userClicksOnSaveButton() {
        route.saveButton.click();
    }

    @And("User verifies that -Route save successfully- text appeared.")
    public void userVerifiesThatRouteSaveSuccessfullyTextAppeared() {
        actualText = route.labelSave.getText();
        expectedText = "Route save successfully";
        softAssert.assertEquals(actualText, expectedText, "'Route save successfully' DID NOT appear!");
    }

    @And("User clicks on -Go Back- button.")
    public void userClicksOnGoBackButton() {
        route.goBackButton.click();
    }

    @And("User verifies that new route is added.")
    public void userVerifiesThatNewRouteIsAdded() {
        actualAddition = route.newRouteElement.getText();
        expectedAddition = ConfigReader.getProperty("ihsanRouteName");
        softAssert.assertEquals(actualAddition, expectedAddition, "New 'Route' DID NOT add!");
    }

    @And("User clicks on -Manage Trips- menu button and clicks on -Schedule- option.")
    public void userClicksOnManageTripsMenuButtonAndClicksOnScheduleOption() {
        adminDashboard.manageTripsButton.click();
        adminDashboard.scheduleButton.click();
    }

    @Then("User displays -Schedule- page.")
    public void userDisplaysSchedulePage() {
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/admin/manage/schedule";
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'Schedule' page!");
    }

    @And("User clicks Schedule-Add New- button.")
    public void userClicksScheduleAddNewButton() {
        schedule.addNewButton.click();
    }

    @Then("User displays -Add Schedule- page.")
    public void userDisplaysAddSchedulePage() {
        actualPage = schedule.labelAddSchedule.getText();
        expectedPage = "Add Schedule";
        softAssert.assertEquals(actualPage, expectedPage, "User DID NOT display the 'Add Schedule' page!");
    }

    @And("User clicks on -Start From- box and enters a valid {string}.")
    public void userClicksOnStartFromBoxAndEntersAValid(String startTime) {
        schedule.startFromBox.sendKeys(ConfigReader.getProperty(startTime));
    }

    @And("User clicks on -End At- box and enters a valid {string}.")
    public void userClicksOnEndAtBoxAndEntersAValid(String endTime) {
        schedule.endAtBox.sendKeys(ConfigReader.getProperty(endTime));
    }

    @Then("User clicks on Schedule -Save- button.")
    public void userClicksOnScheduleSaveButton() {
        schedule.saveButton.click();
    }

    @And("User verifies that -Schedule save successfully- text appeared.")
    public void userVerifiesThatScheduleSaveSuccessfullyTextAppeared() {
        actualText = schedule.labelSave.getText();
        expectedText = "Schedule save successfully";
        softAssert.assertEquals(actualText, expectedText, "'Schedule save successfully' DID NOT appear!");
    }

    @And("User verifies that the schedule is added.")
    public void userVerifiesThatTheScheduleIsAdded() {
        actualAddition = schedule.newScheduleElement.getText();
        expectedAddition = ConfigReader.getProperty("ihsanScheduleStartFrom");
        softAssert.assertEquals(actualAddition, expectedAddition, "New 'Schedule' DID NOT add!");
    }

    @And("User clicks on -Manage Trips- menu button and clicks on -Ticket Price- option.")
    public void userClicksOnManageTripsMenuButtonAndClicksOnTicketPriceOption() {
        adminDashboard.manageTripsButton.click();
        adminDashboard.ticketPriceButton.click();
    }

    @Then("User displays -Ticket Price- page.")
    public void userDisplaysTicketPricePage() {
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/admin/manage/ticket-price";
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'Ticket Price' page!");
    }

    @And("User clicks Ticket Price -Add New- button.")
    public void userClicksTicketPriceAddNewButton() {
        ticketPrice.addNewButton.click();
    }

    @Then("User displays -Add Ticket Price- page.")
    public void userDisplaysAddTicketPricePage() {
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/admin/manage/ticket-price/create";
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'Add Ticket Price' page!");
    }

    @And("User clicks on -Fleet Type- menu and selects an option.")
    public void userClicksOnFleetTypeMenuAndSelectsAnOption() {
        Select selectFleetType = new Select(ticketPrice.dropDownFleetType);
        selectFleetType.selectByValue("1");
    }

    @And("User clicks on -Route- menu and selects an option.")
    public void userClicksOnRouteMenuAndSelectsAnOption() {
        Select selectRoute = new Select(ticketPrice.dropDownRoute);
        selectRoute.selectByValue("41");
    }

    @And("User clicks on -Price For Source To Destination- box and enters a valid {string}.")
    public void userClicksOnPriceForSourceToDestinationBoxAndEntersAValid(String price) {
        ticketPrice.priceBox.click();
        ticketPrice.priceBox.sendKeys(ConfigReader.getProperty(price));
    }

    @And("User clicks on newly opened price box and enters a valid {string}.")
    public void userClicksOnNewlyOpenedPriceBoxAndEntersAValid(String price2) {
        ticketPrice.priceBox2.click();
        ticketPrice.priceBox2.sendKeys(ConfigReader.getProperty(price2));
    }

    @Then("User clicks on Ticket Price -Save- button.")
    public void userClicksOnTicketPriceSaveButton() {
        ticketPrice.saveButton.click();
    }

    @And("User verifies that -Ticket price added successfully- text appeared.")
    public void userVerifiesThatTicketPriceAddedSuccessfullyTextAppeared() {
        actualText = ticketPrice.labelSave.getText();
        expectedText = "Ticket price added successfully";
        softAssert.assertEquals(actualText, expectedText, "'Ticket price added successfully' DID NOT appear!");
    }

    @And("User clicks on Ticket Price -Go Back- button.")
    public void userClicksOnTicketPriceGoBackButton() {
        ticketPrice.goBackButton.click();
    }

    @And("User verifies that new ticket price is added.")
    public void userVerifiesThatNewTicketPriceIsAdded() {
        actualAddition = ticketPrice.newTicketPriceElement.getText();
        expectedAddition = ConfigReader.getProperty("ihsanTicketPrice");
        softAssert.assertEquals(actualAddition, expectedAddition, "New 'Ticket Price' DID NOT add!");
    }

    @And("User clicks on -Manage Trips- menu button and clicks on -Trip- option.")
    public void userClicksOnManageTripsMenuButtonAndClicksOnTripOption() {
        adminDashboard.manageTripsButton.click();
        adminDashboard.tripButton.click();
    }

    @Then("User displays -Trip- page.")
    public void userDisplaysTripPage() {
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/admin/manage/trip";
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'Trip' page!");
    }

    @And("User clicks Trip-Add New- button.")
    public void userClicksTripAddNewButton() {
        trip.addNewButton.click();
    }

    @Then("User displays -Add Trip- page.")
    public void userDisplaysAddTripPage() {
        actualPage = trip.labelAddTrip.getText();
        expectedPage = "Add Trip";
        softAssert.assertEquals(actualPage, expectedPage, "User DID NOT display the 'Add Trip' page!");
    }

    @And("User clicks on Trip-Fleet Type- menu and selects an option.")
    public void userClicksOnTripFleetTypeMenuAndSelectsAnOption() {
        Select selectFleetType = new Select(trip.dropDownFleetType);
        ReusableMethods.bekle(1);
        selectFleetType.selectByValue("1");
        fleetTypeText = trip.labelFleetType.getText();
    }

    @And("User clicks on Trip-Route- menu and selects an option.")
    public void userClicksOnTripRouteMenuAndSelectsAnOption() {
        Select selectRoute = new Select(trip.dropDownRoute);
        selectRoute.selectByValue("42");
    }

    @And("User clicks on -Schedule- menu and selects an option.")
    public void userClicksOnScheduleMenuAndSelectsAnOption() {
        Select selectSchedule = new Select(trip.dropDownSchedule);
        selectSchedule.selectByValue("1");
    }

    @And("User clicks on Trip-Start From- menu and selects an option.")
    public void userClicksOnTripStartFromMenuAndSelectsAnOption() {
        Select selectStartFrom = new Select(trip.dropDownStartFrom);
        selectStartFrom.selectByValue("1");
        startFromText = trip.labelStartFrom.getText();
    }

    @And("User clicks on Trip-End To- menu and selects an option.")
    public void userClicksOnTripEndToMenuAndSelectsAnOption() {
        Select selectEndTo = new Select(trip.dropDownEndTo);
        selectEndTo.selectByValue("2");
        endToText = trip.labelEndTo.getText();
    }

    @And("User clicks on -Day Off- menu and selects an option.")
    public void userClicksOnDayOffMenuAndSelectsAnOption() {
        Select selectDayOff = new Select(trip.dropDownDayOff);
        selectDayOff.selectByValue("1");
    }

    @Then("User clicks on Trip-Save- button.")
    public void userClicksOnTripSaveButton() {
        trip.saveButton.click();
    }

    @And("User verifies that -Trip save successfully- text appeared.")
    public void userVerifiesThatTripSaveSuccessfullyTextAppeared() {
        actualText = trip.labelSave.getText();
        expectedText = "Trip save successfully";
        softAssert.assertEquals(actualText, expectedText, "'Trip save successfully' DID NOT appear!");
    }

    @And("User verifies that new trip is added.")
    public void userVerifiesThatNewTripIsAdded() {
        actualAddition = trip.newTripElement.getText();
        expectedAddition = fleetTypeText + " - " + startFromText + " - " + endToText;
        softAssert.assertEquals(actualAddition, expectedAddition, "New 'Trip' DID NOT add!");
    }

    @And("User clicks on -Manage Trips- menu button and clicks on -Assigned Vehicle- option.")
    public void userClicksOnManageTripsMenuButtonAndClicksOnAssignedVehicleOption() {
        adminDashboard.manageTripsButton.click();
        adminDashboard.assignedVehicleButton.click();
    }

    @Then("User displays -Assigned Vehicle- page.")
    public void userDisplaysAssignedVehiclePage() {
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/admin/manage/assigned-vehicle";
        softAssert.assertEquals(actualUrl, expectedUrl, "User DID NOT display the 'Assigned Vehicle' page!");
    }

    @And("User clicks Assigned Vehicle-Add New- button.")
    public void userClicksAssignedVehicleAddNewButton() {
        assignedVehicle.addNewButton.click();
    }

    @Then("User displays -Assign Vehicle- page.")
    public void userDisplaysAssignVehiclePage() {
        actualPage = assignedVehicle.labelAssignVehicle.getText();
        expectedPage = "Assign Vehicle";
        softAssert.assertEquals(actualPage, expectedPage, "User DID NOT display the 'Assign Vehicle' page!");
    }

    @And("User clicks on -Trip- menu and selects an option.")
    public void userClicksOnTripMenuAndSelectsAnOption() {
        Select selectTrip = new Select(assignedVehicle.dropDownTrip);
        selectTrip.selectByValue("95");
        tripText = assignedVehicle.labelTrip.getText();
    }

    @And("User clicks on -Vehicle- menu and selects an option.")
    public void userClicksOnVehicleMenuAndSelectsAnOption() {
        Select selectVehicle = new Select(assignedVehicle.dropDownVehicle);
        selectVehicle.selectByValue("7");
    }

    @Then("User clicks on Assigned Vehicle-Save- button.")
    public void userClicksOnAssignedVehicleSaveButton() {
        assignedVehicle.saveButton.click();
    }

    @And("User verifies that -Vehicle assigned successfully- text appeared.")
    public void userVerifiesThatVehicleAssignedSuccessfullyTextAppeared() {
        actualText = assignedVehicle.labelSave.getText();
        expectedText = "Vehicle assigned successfully.";
        softAssert.assertEquals(actualText, expectedText, "'Vehicle assigned successfully' DID NOT appear!");
    }

    @And("User verifies that new vehicle is added.")
    public void userVerifiesThatNewVehicleIsAdded() {
        actualAddition = assignedVehicle.newTripElement.getText();
        if (actualAddition.equals(tripText)) {
            System.out.println("New Vehicle added!");
        } else {
            softAssert.assertEquals(actualAddition, tripText, "New 'Vehicle' DID NOT add!");
        }
    }

    @And("User clicks on -Disable Route- button for the added route.")
    public void userClicksOnDisableRouteButtonForTheAddedRoute() {
        routeName = route.newRouteElement.getText();
        route.disableButton.click();
    }

    @Then("User clicks on -Disable- option.")
    public void userClicksOnDisableOption() {
        route.disableActiveButton.click();
    }

    @And("User verifies that the route is disabled.")
    public void userVerifiesThatTheRouteIsDisabled() {
        actualText = route.labelStatus.getText();
        expectedText = "Disabled";
        softAssert.assertEquals(actualText, expectedText, "'Route' IS NOT disabled.");
    }

    @Then("User clicks on -Update Route- button for the added route.")
    public void userClicksOnUpdateRouteButtonForTheAddedRoute() {
        route.editButton.click();
    }

    @And("User displays -Update Route- page.")
    public void userDisplaysUpdateRoutePage() {
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/admin/manage/route/edit";
        softAssert.assertTrue(actualUrl.contains(expectedUrl), "User DID NOT display the 'Update Route' page!");
    }

    @And("User clicks on -Name- box and enters a valid updated {string}.")
    public void userClicksOnNameBoxAndEntersAValidUpdated(String routeName) {
        route.nameBox.sendKeys(ConfigReader.getProperty(routeName));
    }

    @Then("User clicks on -Save Changes- button.")
    public void userClicksOnSaveChangesButton() {
        route.saveChangesButton.click();
    }

    @And("User verifies that -Route update successfully- text appeared.")
    public void userVerifiesThatRouteUpdateSuccessfullyTextAppeared() {
        actualText = route.labelUpdate.getText();
        expectedText = "Route update successfully";
        softAssert.assertEquals(actualText, expectedText, "'Route update successfully' DID NOT appear!");
    }

    @And("User clicks on Route-Go Back- button.")
    public void userClicksOnRouteGoBackButton() {
        route.goBackButton.click();
    }

    @And("User verifies that the route is updated.")
    public void userVerifiesThatTheRouteIsUpdated() {
        actualUpdate = route.newRouteElement.getText();
        expectedUpdate = routeName + ConfigReader.getProperty("ihsanRouteNameUpdated");
        softAssert.assertEquals(actualUpdate, expectedUpdate, "'Route' IS NOT updated!");
    }

    @And("User clicks on -Disable Schedule- button for the added Schedule.")
    public void userClicksOnDisableScheduleButtonForTheAddedSchedule() {
        schedule.disableButton.click();
    }

    @Then("User clicks on schedule-Disable- option.")
    public void userClicksOnScheduleDisableOption() {
        schedule.disableActiveButton.click();

    }

    @And("User verifies that the Schedule is disabled.")
    public void userVerifiesThatTheScheduleIsDisabled() {
        actualText = schedule.labelStatus.getText();
        expectedText = "Disabled";
        softAssert.assertEquals(actualText, expectedText, "'Schedule' IS NOT disabled.");
    }

    @Then("User clicks on -Update Schedule- button for the added Schedule.")
    public void userClicksOnUpdateScheduleButtonForTheAddedSchedule() {
        schedule.editButton.click();
    }

    @And("User displays -Update Schedule- page.")
    public void userDisplaysUpdateSchedulePage() {
        actualPage = schedule.labelUpdatePage.getText();
        expectedPage = "Update Schedule";
        softAssert.assertEquals(actualPage, expectedPage, "User DID NOT display the 'Update Schedule' page!");
    }

    @And("User clicks on -Start From- box and enters a valid updated {string}.")
    public void userClicksOnStartFromBoxAndEntersAValidUpdated(String startTime) {
        schedule.startFromBox.clear();
        ReusableMethods.bekle(1);
        schedule.startFromBox.sendKeys(ConfigReader.getProperty(startTime));
    }

    @Then("User clicks on -Update- button.")
    public void userClicksOnUpdateButton() {
        schedule.updateButton.click();
    }

    @And("User clicks on -Delete- button for the added ticket price.")
    public void userClicksOnDeleteButtonForTheAddedTicketPrice() {
        routeName = ticketPrice.routeName.getText();
        ticketPrice.deleteButton.click();
    }

    @Then("User confirms by clicking -Delete- button.")
    public void userConfirmsByClickingDeleteButton() {
        ticketPrice.deleteConfirmButton.click();
    }

    @And("User verifies that -Price Deleted Successfully- text appeared.")
    public void userVerifiesThatPriceDeletedSuccessfullyTextAppeared() {
        actualText = ticketPrice.labelDelete.getText();
        expectedText = "Price Deleted Successfully";
        softAssert.assertEquals(actualText, expectedText, "'Price Deleted Successfully' DID NOT appear!");
    }

    @And("User verifies -Ticket Price- has been deleted.")
    public void userVerifiesTicketPriceHasBeenDeleted() {
        softAssert.assertFalse(routeName.equals(ticketPrice.routeName.getText()), "'Ticket Price' IS NOT deleted.");
    }

    @Then("User clicks on -Edit- button for the added ticket price.")
    public void userClicksOnEditButtonForTheAddedTicketPrice() {
        ticketPrice.editButton.click();
    }

    @And("User displays -Update Ticket Price- page.")
    public void userDisplaysUpdateTicketPricePage() {
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = "https://qa.easybusticket.com/admin/manage/ticket-price/edit";
        softAssert.assertTrue(actualUrl.contains(expectedUrl), "User DID NOT display the 'Update Ticket Price' page!");
    }

    @And("User clicks on price box and enters a valid {string}.")
    public void userClicksOnPriceBoxAndEntersAValid(String updatedTicketPrice) {
        ticketPrice.updateBox.click();
        ticketPrice.updateBox.clear();
        ticketPrice.updateBox.sendKeys(ConfigReader.getProperty(updatedTicketPrice));
    }

    @Then("User clicks on ticket price-Update- button.")
    public void userClicksOnTicketPriceUpdateButton() {
        ticketPrice.updateButton.click();
    }

    @And("User verifies that -Price Updated Successfully- text appeared.")
    public void userVerifiesThatPriceUpdatedSuccessfullyTextAppeared() {
        actualText = ticketPrice.labelUpdate.getText();
        expectedText = "Price Updated Successfully";
        softAssert.assertEquals(actualText, expectedText, "'Price Updated Successfully' DID NOT appear!");
    }

    @And("User verifies that the ticket price is updated.")
    public void userVerifiesThatTheTicketPriceIsUpdated() {
        actualUpdate = ticketPrice.newTicketPriceElement.getText();
        expectedUpdate = ConfigReader.getProperty("ihsanUpdatedTicketPrice") + ".00 USD";
        softAssert.assertEquals(actualUpdate, expectedUpdate, "'Ticket Price' IS NOT updated!");
    }

    @And("User clicks on -Disable- button for the added trip.")
    public void userClicksOnDisableButtonForTheAddedTrip() {
        trip.disableButton.click();
    }

    @And("User clicks on Trip-Disable- option.")
    public void userClicksOnTripDisableOption() {
        trip.disableConfirmButton.click();
    }

    @Then("User verifies that -Trip disabled successfully- text appeared.")
    public void userVerifiesThatTripDisabledSuccessfullyTextAppeared() {
        actualText = trip.labelDisable.getText();
        expectedText = "Trip disabled successfully";
        softAssert.assertEquals(actualText, expectedText, "'Trip disabled successfully' DID NOT appear!");
    }

    @And("User verifies that the -Trip- is disabled.")
    public void userVerifiesThatTheTripIsDisabled() {
        actualText = trip.labelDisabled.getText();
        expectedText = "Disabled";
        softAssert.assertEquals(actualText, expectedText, "'Trip' IS NOT disabled.");
    }

    @And("User clicks on -Edit- button for the added trip.")
    public void userClicksOnEditButtonForTheAddedTrip() {
        trip.editButton.click();
    }

    @Then("User displays -Update Trip- page.")
    public void userDisplaysUpdateTripPage() {
        actualPage = trip.labelUpdateTrip.getText();
        expectedPage = "Update Trip";
        softAssert.assertEquals(actualPage, expectedPage, "User DID NOT display the 'Update Trip' page!");
    }

    @And("User clicks on -Title- box and enters an {string}.")
    public void userClicksOnTitleBoxAndEntersAn(String tripTitle) {
        trip.titleBox.click();
        trip.titleBox.clear();
        trip.titleBox.sendKeys(ConfigReader.getProperty(tripTitle));
    }

    @Then("User clicks on Trip-Update- button.")
    public void userClicksOnTripUpdateButton() {
        trip.updateButton.click();
    }

    @And("User clicks on close button.")
    public void userClicksOnCloseButton() {
        trip.closeButton.click();
    }

    @Then("User verifies that the trip is updated.")
    public void userVerifiesThatTheTripIsUpdated() {
        actualUpdate = trip.newTripElement.getText();
        expectedUpdate = ConfigReader.getProperty("ihsanUpdatedTripTitle");
        softAssert.assertEquals(actualUpdate, expectedUpdate, "'Trip' IS NOT updated!");
    }

    @And("User clicks on -Edit- button for the added vehicle.")
    public void userClicksOnEditButtonForTheAddedVehicle() {
        assignedVehicle.editButton.click();
    }

    @Then("User displays -Update Assigned Vehicle- page.")
    public void userDisplaysUpdateAssignedVehiclePage() {
        actualPage = assignedVehicle.labelUpdateAssignedVehicle.getText();
        expectedPage = "Update Assigned Vehicle";
        softAssert.assertEquals(actualPage, expectedPage, "User DID NOT display the 'Update Assigned Vehicle' page!");
    }

    @And("User clicks on -Trip- menu and selects an updated option.")
    public void userClicksOnTripMenuAndSelectsAnUpdatedOption() {
        Select selectTrip = new Select(assignedVehicle.dropDownUpdateTrip);
        ReusableMethods.bekle(1);
        selectTrip.selectByVisibleText(ConfigReader.getProperty("ihsanUpdatedTripName"));
    }

    @And("User clicks on -Vehicle- menu and selects an updated option.")
    public void userClicksOnVehicleMenuAndSelectsAnUpdatedOption() {
        Select selectVehicle = new Select(assignedVehicle.dropDownUpdateVehicle);
        selectVehicle.selectByVisibleText(ConfigReader.getProperty("ihsanUpdatedVehicle"));
    }

    @Then("User clicks on Assigned Vehicle-Update- button.")
    public void userClicksOnAssignedVehicleUpdateButton() {
        assignedVehicle.updateButton.click();
    }

    @And("User verifies that -Assigned vehicle update successfully.- text appeared.")
    public void userVerifiesThatAssignedVehicleUpdateSuccessfullyTextAppeared() {
        actualText = assignedVehicle.labelUpdate.getText();
        expectedText = "Assigned vehicle update successfully.";
        softAssert.assertEquals(actualText, expectedText, "'Assigned vehicle update successfully.' DID NOT appear!");
    }

    @And("User verifies that the vehicle is updated.")
    public void userVerifiesThatTheVehicleIsUpdated() {
        actualUpdate = assignedVehicle.newTripElement.getText();
        expectedUpdate = ConfigReader.getProperty("ihsanUpdatedTripName");
        softAssert.assertEquals(actualUpdate, expectedUpdate, "'Vehicle' IS NOT updated!");
    }

    @Given("User verify the presence of the Payment Gateways menu and its sub-menus.")
    public void userVerifyThePresenceOfThePaymentGatewaysMenuAndItsSubMenus() {
        automaticGateways.paymentGateWaysMenu.click();
        Assert.assertTrue(automaticGateways.paymentGateWaysMenu.isDisplayed());
    }

    @Then("User click on the link associated with Automatic Gateways under the Payment Gateways menu")
    public void userClickOnTheLinkAssociatedWith() {
        automaticGateways.automaticGatewaysLink.click();
    }

    @And("User displays Automatic Gateways page")
    public void userDisplaysAutomaticGatewaysPage() {
        Assert.assertTrue(automaticGateways.automaticGatewaysPage.isDisplayed());
    }

    @Then("User click on the link associated with Manuel Gateways under the Payment Gateways menu")
    public void userClickOnTheLinkAssociatedWithManuelGatewaysUnderThePaymentGatewaysMenu() {
        manuelGateways.manuelGatewaysLink.click();
    }

    @And("User displays Manuel Gateways page")
    public void userDisplaysManuelGatewaysPage() {
        Assert.assertTrue(manuelGateways.manuelGatewaysLink.isDisplayed());
    }

    @And("User click Add new button")
    public void userClickAddNewButton() {
        manuelGateways.addNewButton.click();
    }

    @And("User enters Gateway Name {string}")
    public void userEntersGatewayName(String GatewayName) {
        manuelGateways.gatewayNameColumn.click();
        manuelGateways.gatewayNameColumn.sendKeys(ConfigReader.getProperty(GatewayName));
    }

    @And("User enters {string}")
    public void userEnters(String currency) {
        manuelGateways.currencyColumn.click();
        manuelGateways.currencyColumn.sendKeys(ConfigReader.getProperty(currency));
    }

    @And("User enters Rate {string}")
    public void userEntersRate(String rate) {
        manuelGateways.rateColumn.click();
        manuelGateways.rateColumn.sendKeys(ConfigReader.getProperty(rate));
    }

    @Then("User displays the {string} page.")
    public void user_displays_the_page(String string) {

        adminSignIn.usernameBox.sendKeys(ConfigReader.getProperty("burcuAdminUsername"));
        adminSignIn.passwordBox.sendKeys(ConfigReader.getProperty("burcuAdminPassword"));
        adminSignIn.loginButton.click();
    }
  
    @Then("User clicks on View All button for Total Users.")
    public void user_clicks_on_view_all_button_for_total_users() {
        adminDashboard.ViewAllTotalUsers.click();
    }
  
    @Then("User displays Manage Users page.")
    public void user_displays_manage_users_page() {
        adminDashboard.ManageUsers.isDisplayed();
    }
  
    @Then("User clicks on View All button for TotalEmailUnverifiedUsers.")
    public void user_clicks_on_view_all_button_for_total_email_unverified_users() {
        adminDashboard.ViewAllTotalEmailUnverifiedUsers.click();
    }
  
    @Then("User clicks on View All button for TotalSMSUnverifiedUsers.")
    public void user_clicks_on_view_all_button_for_total_sms_unverified_users() {
        adminDashboard.ViewAllTotalSMSUnverifiedUsers.click();
    }
  
    @Then("User displays {string} page.")
    public void user_displays_page(String string) {
        adminDashboard.ManageUsers.isDisplayed();
    }

    @And("Admin should be able to see the counter link in the trasport manager menu in the left menu on the dashboard page.")
    public void adminShouldBeAbleToSeeTheCounterLinkInTheTrasportManagerMenuInTheLeftMenuOnTheDashboardPage() {
        adminDashboard.Counter.click();
    }

    @Then("Admin clicks on add new button")
    public void admin_clicks_on_add_new_button() {

        adminDashboard.AddNewDashboard.click();
    }

    @And("Add counter  username is added")
    public void addCounterUsernameIsAdded() {
        counter.AddNewName.sendKeys(ConfigReader.getProperty("Name"));
    }

    @And("The city name is added to the counter")
    public void theCityNameIsAddedToTheCounter() {
        counter. AddNewCity.sendKeys(ConfigReader.getProperty("City"));
    }

    @And("The counter should be added to the location.")
    public void theCounterShouldBeAddedToTheLocation() {
        counter.AddNewEnterLocation.sendKeys(ConfigReader.getProperty("Location"));

    }

    @And("A phone number must be added to the meter")
    public void aPhoneNumberMustBeAddedToTheMeter() {
        counter. AddNewEnterCounterContactNumber.sendKeys(ConfigReader.getProperty("Mobile"));

    }

    @And("Admin clicks on  counter.")
    public void adminClicksOnCounter() {
        counter.AddNewSave.click();

    }

    @And("Admin  verfies that new added counter is visible.")
    public void adminVerfiesThatNewAddedCounterIsVisible() {
        counter.AddNew.isDisplayed();
    }

}