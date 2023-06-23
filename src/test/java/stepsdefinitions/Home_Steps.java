package stepsdefinitions;

import factory.PageFactoryManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

import static junit.framework.TestCase.assertEquals;
public class Home_Steps {
    private HomePage homePage;
    private final TestContext context;

    public Home_Steps(TestContext context) {
        this.context = context;
        homePage = PageFactoryManager.getHomePage(context.driver);
    }

    @Given("The user access to MAFAO homepage")
    public void theUserAccessToMAFAOHomepage() {
        homePage.visit("https://odoo-staging.jips.io/");
    }

    @When("The user clicks on User icon")
    public void theUserClicksOnLoginIcon() {
        homePage.clickOnUserIcon();
    }

    @Then("The user is on Login Page")
    public void theUserIsOnLoginPage() {
        assertEquals(homePage.getCurrentUrl(),"https://odoo-staging.jips.io/web/login");
    }

}
