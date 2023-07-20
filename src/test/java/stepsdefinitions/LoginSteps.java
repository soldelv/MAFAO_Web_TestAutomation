package stepsdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;

import static Constants.Constants.*;
import static org.junit.Assert.assertTrue;
import static utils.CommonMethods.holdOn;
import static utils.CommonMethods.print;

public class LoginSteps {
    private AppiumDriver driver = HooksSteps.getDriver();
    private final LoginPage loginPage = new LoginPage(driver);


    @Given("^the user accesses to MAFAO application$")
    public void theUserAccessesToMafaoApp()  {
        holdOn(8000);
    }


    @When("the user taps on Log in button")
    public void theUserTapsOnLogInButton() {
        loginPage.tapOnLoginBtn();
    }

    @Then("the user is on the login screen")
    public void theUserIsOnTheLoginScreen() {
        Assertions.assertTrue(loginPage.checkIsOnLoginScreen());

    }
    @When("^the user taps on flag icon and searches a country$")
    public void theUserTapsOnFlagIconAndSearchesForCountry() {
        loginPage.tapOnFlagIcon();
        print("Tapped on flag icon");
        loginPage.searchCountry(COUNTRY);
        print("searched the country");

    }
    @When("^the user taps on flag icon and searches for (.*)$")
    public void theUserTapsOnFlagIconAndSearchesFor(String country) {
        loginPage.tapOnFlagIcon();
        print("Tapped on flag icon");
        loginPage.searchCountry(country);
        print("searched the country");

    }

    @And("^taps on searched country flag$")
    public void tapsOnCountryFlag() {
        loginPage.tapOnSearchedCountry();
    }

    @And("^enters a registered mobile number and taps on send code$")
    public void entersARegisteredMobile_numberAndTapsOnSendCode() {
        loginPage.enterMobileNumber(MOBILE_NUMBER);
    }

    @And("^enters a valid mobile number and taps on send code$")
    public void entersAValidMobile_numberAndTapsOnSendCode() {
        loginPage.enterMobileNumber("756490210");
    }

    @And("^enters the verification code and taps on send$")
    public void entersTheVerificationCodeAndTapsOnSend() throws Exception {
        loginPage.enterOTPCode(COUNTRY_CODE, MOBILE_NUMBER);
    }

    @And("^enters a valid verification code and taps on send$")
    public void entersAValidVerificationCodeAndTapsOnSend() throws Exception {
        loginPage.enterOTPCode("+33", "756490210");
    }

    @And("^enters a valid secret code and taps on confirm$")
    public void entersAValidSecret_codeAndTapsOnConfirm() {
        loginPage.enterSecretCode(SECRET_CODE);
    }

    @Then("the user should be logged in successfully")
    @Then("the user is logged in on MAFAO mobile application")
    public void theUserShouldBeLoggedInSuccessfully() {
        assertTrue(loginPage.checkSuccessLogin());
    }


    @And("^enters incorrect (.*) and taps on confirm$")
    public void entersIncorrectSecret_codeAndTapsOnConfirm(String secretCode) {
        loginPage.enterSecretCode(secretCode);
    }

    @Then("the user should see an error message")
    public void theUserShouldSeeAnErrorMessage() {
        assertTrue(loginPage.getErrorLoginMsg());
    }

    @When("^the user enters valid credentials$")
    public void theUserEntersValidCredentials() throws Exception {
        loginPage.tapOnLoginBtn();
        loginPage.tapOnFlagIcon();
        print("Tapped on flag icon");
        loginPage.searchCountry(COUNTRY);
        print("searched the country");
        loginPage.tapOnSearchedCountry();
        loginPage.enterMobileNumber(MOBILE_NUMBER);
        holdOn(900);
        loginPage.enterOTPCode(COUNTRY_CODE, MOBILE_NUMBER);
        loginPage.enterSecretCode(SECRET_CODE);
    }

    @When("the user enters just pincode")
    public void theUserEntersJustPincode() {
        loginPage.enterSecretCode(SECRET_CODE);
    }

    @And("taps on forgot pincode")
    public void tapsOnForgotPincode() {
        loginPage.tapOnForgotPincode();
    }

    @And("^enter the (.*) twice$")
    public void enterTheNew_pincodeTwice(String newPincode) {
        loginPage.enterNewPincode(newPincode);
        holdOn(100);
        loginPage.enterNewPincode(newPincode);
    }
}
