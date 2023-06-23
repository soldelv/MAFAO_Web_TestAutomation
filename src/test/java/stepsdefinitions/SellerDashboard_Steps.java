package stepsdefinitions;

import factory.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.SellerDashboardPage;

import static org.junit.Assert.assertEquals;

public class SellerDashboard_Steps {
    private SellerDashboardPage sellerDashboardPage;
    private final TestContext context;

    public SellerDashboard_Steps(TestContext context) {
        this.context = context;
        sellerDashboardPage = PageFactoryManager.getSellerDashboard(context.driver);
    }


    @And("The user is on the Seller Dashboard page")
    public void theUserIsOnTheSellerDashboardPage() {
        assertEquals("Seller Dashboard displayed",sellerDashboardPage.checkIsInSellerDashboard());

    }

    @Then("The user logs out")
    public void theUserLogsOut() {
        sellerDashboardPage.logOut();
    }
}
