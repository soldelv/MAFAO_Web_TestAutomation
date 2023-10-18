package stepsdefinitions;

import factory.PageFactoryManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage_Odoo;
import stepsdefinitions.TestContext;

import static constants.Constants.ODOO_URL_STG;
import static org.junit.Assert.assertEquals;

public class HomeSteps_Odoo {
    private HomePage_Odoo homePage;
    private final TestContext context;

    public HomeSteps_Odoo(TestContext context) {
        this.context = context;
        homePage = PageFactoryManager.getHomePage(context.driver);
    }

    @Given("The user access to MAFAO homepage")
    public void theUserAccessToMAFAOHomepage() {
        homePage.visit(ODOO_URL_STG);
    }

    @When("The user clicks on User icon")
    public void theUserClicksOnLoginIcon() {
        homePage.clickOnUserIcon();
    }

    @Then("The user is on Login Page")
    public void theUserIsOnLoginPage() {
        assertEquals(homePage.getCurrentUrl(), ODOO_URL_STG);
    }

}
