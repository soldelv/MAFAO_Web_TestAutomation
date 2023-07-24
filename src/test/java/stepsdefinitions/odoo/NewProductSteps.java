package stepsdefinitions.odoo;

import factory.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.odoo.NewProductPage;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class NewProductSteps {

    private NewProductPage newProductPage;
    private final TestContext context;

    public NewProductSteps(TestContext context) {
        this.context = context;
        newProductPage = PageFactoryManager.getNewProductPage(context.driver);
    }

    @When("fills information of new product form")
    public void fillsInformationOfNewProductForm() {
        newProductPage.fillNewProductFormInformation();
    }

    @And("fills variants details of new product form")
    public void fillsVariantsDetailsOfNewProductForm() {
        newProductPage.fillNewProductFormVariants();
    }

    @And("uploads images for the new product")
    public void uploadsImagesForTheNewProduct() throws AWTException {
        newProductPage.fillNewProductFormImages();
    }

    @And("fills inventory of new product form")
    public void fillsInventoryOfNewProductForm() {
        newProductPage.fillNewProductFormInventory();
    }

    @And("selects pick up location")
    public void selectsPickUpLocation() {
        newProductPage.fillNewProductFormPickUpLocation();
    }

    @And("creates a group of discounts")
    public void createsAGroupOfDiscounts() {
        newProductPage.fillNewProductFormDiscountGroups();
    }

    @And("clicks on Request To Approve button")
    public void clicksOnRequestToApproveButton() {
        newProductPage.fillNewProductFormRequestToApprove();
    }

    @Then("the new product is on Pending list")
    public void theNewProductIsOnPendingList() {
        assertTrue(newProductPage.checkProductIsInPendingList());
    }

}
