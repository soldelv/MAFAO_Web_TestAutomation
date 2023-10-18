package stepsdefinitions;

import factory.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage_Odoo;
import stepsdefinitions.TestContext;

import static constants.Constants.*;

public class LoginSteps_Odoo {
    private LoginPage_Odoo loginPage;
    private final TestContext context;
    public LoginSteps_Odoo(TestContext context){
        this.context = context;
        loginPage = PageFactoryManager.getLoginPage(context.driver);
    }

    @Given("the user clicks on Login with Keycloak button")
    public void theUserClicksOnLoginWithKeycloackButton() {
        loginPage.clickOnLoginWithKeycloak();
    }

    @When("^The user enters user (.*) and password (.*)$")
    public void theUserEntersUserUsernameAndPasswordPassword(String user, String password){

    }

    @Then("Invalid secret code error message is displayed")
    public void invalidSecretCodeErrorMessageIsDisplayed() throws InterruptedException {
        Assertions.assertTrue(loginPage.checkErrorLoginKc());
    }
    @Given("the user logs in as an admin")
    public void theUserLogsInAsAnAdmin() {
        loginPage.fillLoginForm(ADMIN_EMAIL_STG, ADMIN_PASSWORD_STG);
    }

    @And("^The user enters email (.*) and password (.*)$")
    public void theUserEntersEmailAndPassword(String email, String password) throws InterruptedException {
        loginPage.fillLoginForm(email, password);
    }

    @When("the user logs in as a seller with valid credentials")
    public void theUserLogsInAsASellerWithValidCredentials() {
        loginPage.fillLoginFormWithKey(FULL_MOBILE_NUMBER, SECRET_CODE);
    }

    @Then("An error message is displayed")
    public void anErrorMessageIsDisplayed() throws InterruptedException {
        Assertions.assertTrue(loginPage.checkErrorLogin());
    }

    @Given("the user clicks on Reset Pin Code")
    public void theUserClicksOnResetPinCode() {
        
    }

    @When("enters a registered mobile number - odoo")
    public void entersARegisteredMobileNumberOdoo() {
        
    }

    @And("enters OTP code received - odoo")
    public void entersOTPCodeReceivedOdoo() {
        
    }

    @And("the new pincode twice and clicks on Confirm button")
    public void theNewPincodeTwiceAndClicksOnConfirmButton() {
        
    }

    @Then("passcode changed successful message must be displayed")
    public void passcodeChangedSuccessfulMessageMustBeDisplayed() {
        
    }

    @And("redirects you to Login page again")
    public void redirectsYouToLoginPageAgain() {

    }
}
