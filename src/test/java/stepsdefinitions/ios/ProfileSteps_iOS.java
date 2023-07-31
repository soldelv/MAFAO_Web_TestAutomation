package stepsdefinitions.ios;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ios.BonusPage_iOS;
import pages.ios.ProfilePage_iOs;
import stepsdefinitions.HooksSteps;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileSteps_iOS {

    private final AppiumDriver driver = HooksSteps.getDriver();
    private final ProfilePage_iOs profilePage = new ProfilePage_iOs(driver);

    @And("clicks on log out")
    public void clicksOnLogOut() {
        profilePage.tapOnLogOutBtn();
        profilePage.confirmLogOutBtn();
    }

    @When("taps on settings")
    public void tapsOnSettings() {
        profilePage.tapOnSettingsBtn();
    }

    @And("taps on Secret code to change it")
    public void tapsOnSecretCodeToChangeIt() {
        profilePage.tapOnChangeSecretCode();
    }

    @And("taps on Change my secret code")
    public void tapsOnChangeMySecretCode() {
        profilePage.tapOnChangeMySecretCode();
    }

    @And("^enters the new secret code twice$")
    public void entersTheNew_secret_codeTwice() {
        profilePage.enterANewSecretCodeTwice("random");
    }

    @And("the pincode was successfully changed")
    public void resetPincodeSuccessfulMessageIsDisplayed() {
        assertTrue(profilePage.successfulReset());
        profilePage.tapOnLoginNow();
    }

    @And("^logins again with the new secret code$")
    public void loginsAgainWithTheNewSecretCode() {
        profilePage.loginWithNewSecretCode("random");
    }

    @Then("reset pincode to default secret code")
    public void resetPincodeToDefaultSecretCode() {
        profilePage.resetSecretCodeToDefault();
    }

    @And("enters the current secret code")
    public void entersAValidSecretCode() {
        profilePage.enterCurrentSecretCode();
    }

    @And("taps on profile option")
    public void tapsOnProfileOption() {
        profilePage.tapOnProfileOption();
    }

    @And("changes the display name")
    public void changesTheDisplayName() {
        profilePage.changeDisplayName();
    }

    @Then("the display name was successfully changed")
    public void theDisplayNameWasSuccessfullyChanged() {
        assertTrue(profilePage.checkDisplayNameHasChanged());
    }

    @When("taps on notifications")
    public void tapsOnNotifications() {
        profilePage.tapOnNotifications();
    }

    @Then("all the notifications received are displayed")
    public void allTheNotificationsReceivedAreDisplayed() {
        profilePage.goBackBtn();
    }
}
