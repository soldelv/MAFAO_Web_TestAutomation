package stepsdefinitions;

import factory.PageFactoryManager;
import org.junit.jupiter.api.Assertions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class Login_Steps {
    private LoginPage loginPage;
    private final TestContext context;
    public Login_Steps(TestContext context){
        this.context = context;
        loginPage = PageFactoryManager.getLoginPage(context.driver);
    }

    @Given("The user clicks on Login with Keycloak button")
    public void theUserClicksOnLoginWithKeycloackButton() {
        loginPage.clickOnLoginWithKeycloak();
    }

    @When("^The user enters user (.*) and password (.*)$")
    public void theUserEntersUserUsernameAndPasswordPassword(String user, String password){
        loginPage.fillLoginFormWithKey(user, password);
    }

    @Then("Invalid secret code error message is displayed")
    public void invalidSecretCodeErrorMessageIsDisplayed() throws InterruptedException {
        Assertions.assertTrue(loginPage.checkErrorLoginKc());
    }

    @And("^The user enters email (.*) and password (.*)$")
    public void theUserEntersEmailAndPassword(String email, String password) throws InterruptedException {
        loginPage.fillLoginForm(email, password);
    }

    @Then("An error message is displayed")
    public void anErrorMessageIsDisplayed() throws InterruptedException {
        Assertions.assertTrue(loginPage.checkErrorLogin());
    }
}
