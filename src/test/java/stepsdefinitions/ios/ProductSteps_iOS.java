package stepsdefinitions.ios;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.ios.ProductPage_iOS;
import stepsdefinitions.HooksSteps;

public class ProductSteps_iOS {
    private AppiumDriver driver = HooksSteps.getDriver();
    private final ProductPage_iOS productPage = new ProductPage_iOS(driver);
    private static String product_price;

    @And("taps on plus icon")
    public void tapsOnPlusIcon() {
        productPage.tapOnPlusBtn();
    }

    @And("taps on minus icon")
    public void tapsOnMinusIcon() {
        productPage.tapOnMinusBtn();
    }

    @And("^add (.*) to cart$")
    public void tapsToAddToCartIcon(String productName) {
        productPage.tapOnAddToCart(productName);
    }

    @And("taps on Auchan logo to see seller info")
    public void tapsOnAuchanLogoToSeeSellerInfo() {
        productPage.tapOnSellerInfo();
    }

    @Then("seller info is displayed correctly")
    public void sellerInfoIsDisplayedCorrectly() {
        Assertions.assertTrue(productPage.checkSellerInfo());
    }

    @And("taps on Report this product")
    public void tapsOnReportThisProduct() {
        productPage.tapOnReportThisProductBtn();
    }

    @And("fills the report the product form")
    public void fillsTheReportTheProductForm() {
        productPage.fillReportProductForm();
    }

    @And("report to validate message are displayed")
    public void reportToValidateMessageAreDisplayed() {
        Assertions.assertTrue(productPage.checkReportMessageIsDisplayed());
    }

    @Then("taps on Ok to send the report")
    public void tapsOnOkToSendTheReport() {
        productPage.tapOnOkReportBtn();
    }

    @And("taps on call button")
    public void tapsOnCallButton() {
        productPage.tapOnCallBtn();
    }

    @Then("^(.*) information are displayed correctly$")
    public void productInformationAreDisplayedCorrectly(String productName) {
        productPage.checkProductDetailView(productName);
    }

    @And("goes to similar products section")
    public void goesToSimilarProductsSection() {
        productPage.scrollDown();
        productPage.scrollDown();
        productPage.scrollDown();
        Assertions.assertTrue(productPage.similarProductsSectionIsDisplayed());
    }

    @Then("^similar products for (.*) are displayed$")
    public void similarProductsForProduct_nameAreDisplayed(String productName) {
        productPage.checkSimilarProductsAreDisplayed(productName);
    }
}
