package stepsdefinitions;

import factory.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SellerDashboardPage;
import stepsdefinitions.TestContext;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class SellerDashboardSteps_Odoo {
    private SellerDashboardPage sellerDashboardPage;
    private final TestContext context;

    public SellerDashboardSteps_Odoo(TestContext context) {
        this.context = context;
        sellerDashboardPage = PageFactoryManager.getSellerDashboard(context.driver);
    }

    @When("seller dashboard page displays correctly")
    public void sellerDashboardPageDisplaysCorrectly() {
        assertEquals("Seller Dashboard",sellerDashboardPage.checkDashboard());
    }

    @Then("the user logs out")
    public void theUserLogsOut() {
        sellerDashboardPage.logOut();
    }

    @When("admin dashboard page displays correctly")
    public void adminDashboardPageDisplaysCorrectly() {
        assertEquals("Admin Dashboard",sellerDashboardPage.checkDashboard());
    }

    @When("admin clicks on Pending button from Marketplace Products section")
    public void adminClicksOnPendingButtonFromMarketplaceProductsSection() {
        sellerDashboardPage.clickOnPendingProducts();
    }

    @And("chooses the first product from the list")
    public void choosesTheFirstProductFromTheList() {
        sellerDashboardPage.clickOnFirstPendingProduct();
    }

    @And("clicks on approve button")
    public void clicksOnApproveButton() {
        sellerDashboardPage.clickOnApproveProduct();
    }

    @And("clicks on Approve and Publish")
    public void clicksOnApproveAndPublish() {
        sellerDashboardPage.clickOnApproveAndPublish();
    }

    @Then("the product recently approved is no longer displayed in the list")
    public void theProductRecentlyApprovedIsNoLongerDisplayedInTheList() {
        assertFalse(sellerDashboardPage.checkProductIsNotLongerPending());
    }


    @Given("the seller goes to New Product screen")
    public void theSellerGoesToNewProductScreen() {
        sellerDashboardPage.clickOnProductsBtn();
        sellerDashboardPage.clickOnSubmenuProduct();
        sellerDashboardPage.clickOnCreateNewProduct();
    }

    @Given("the seller goes to Seller Pickup Location screen")
    public void theSellerGoesToSellerPickupLocationScreen() {
        sellerDashboardPage.goToPickUpLocation();
    }

    @When("clicks on create")
    public void clicksOnCreate() {
        sellerDashboardPage.clickOnCreateNewPickUpLocation();
    }

    @And("fills Merchants Pick up Location form and clicks on save")
    public void fillsMerchantsPickUpLocationFormAndClicksOnSave() {
        sellerDashboardPage.fillPickUpLocationForm();
    }

    @Then("the new location is on pick up list")
    public void theNewLocationIsOnPickUpList() {
        assertTrue(sellerDashboardPage.checkNewLocationIsCreated());
    }
}
