package stepsdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.OrdersPage;

public class OrdersSteps {
    private AppiumDriver driver = HooksSteps.getDriver();
    private final OrdersPage ordersPage = new OrdersPage(driver);

    @Then("^notification that (.*) has added to cart is displayed$")
    public void notificationThatProduct_HasAddedToCartIsDisplayed(String productName) {
    }

    @Then("^(.*) is displayed on Orders list$")
    public void product_IsDisplayedOnOrdersList(String productName) {
        Assertions.assertTrue(ordersPage.checkProductIsOnOrders(productName));
    }

    @Then("^the product was removed successfully$")
    public void product_IsNotLongerDisplayedOnTheList() {
        Assertions.assertTrue(ordersPage.checkProductRemovedFromCart());
    }

    @And("taps pay your order")
    public void goesToOrdersScreenAndTapsPayYourOrder() {
        ordersPage.scrollDown();
        ordersPage.tapOnPayOrder();
    }

    @Then("your order has been registered screen should be displayed")
    public void yourOrderHasBeenRegisteredScreenShouldBeDisplayed() {
        Assertions.assertTrue(ordersPage.checkPurchaseSuccessful());
    }

    @And("taps on trash icon to remove product from the list")
    public void tapsOnTrashIconToRemoveProductFromTheList() {
        ordersPage.tapOnTrashIcon();
    }

    @And("taps on change payment method")
    public void tapsOnChangePaymentMethod() {
        ordersPage.tapOnChangePaymentMethod();
    }

    @And("selects MAFAO wallet as a payment method")
    public void selectsMAFAOWalletAsAPaymentMethod() {
        ordersPage.selectMafaoWallet();
        ordersPage.tapOnContinuePaymentMethod();
    }
}
