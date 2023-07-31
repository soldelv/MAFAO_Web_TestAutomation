package stepsdefinitions.ios;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.ios.OrdersPage_iOS;
import stepsdefinitions.HooksSteps;

public class OrdersSteps_iOS {
    private AppiumDriver driver = HooksSteps.getDriver();
    private final OrdersPage_iOS ordersPage = new OrdersPage_iOS(driver);

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
        ordersPage.tapOnContinueShoppingBtn();
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

    @And("taps pay your order to finish the purchase")
    public void tapsPayYourOrderToFinishThePurchase() {
        ordersPage.tapOnPayOrder();
    }

    @And("user goes to Pay Order tab")
    public void userGoesToPayOrderTab() {
        ordersPage.tapOnPaidOrderTab();
    }

    @Then("^the order with (.*) is on the list$")
    public void theOrderWithProduct_IsOnTheList(String productName) {
        Assertions.assertTrue(ordersPage.checkIsInPaidOrders(productName));
    }

    @And("^taps on the order with (.*)$")
    public void tapsOnTheOrderWithProduct_(String productName) {
        ordersPage.tapOnOrder(productName);
    }

    @Then("paid order transaction details are displayed")
    public void paidOrderTransactionDetailsAreDisplayed() {
        Assertions.assertTrue(ordersPage.checkTransactionDetailsAreDisplayed());
    }
}
