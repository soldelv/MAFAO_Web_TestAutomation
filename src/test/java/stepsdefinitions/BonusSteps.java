package stepsdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BonusPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BonusSteps {
    private final AppiumDriver driver = HooksSteps.getDriver();
    private final BonusPage bonusPage = new BonusPage(driver);

    @When("the user taps on refill button")
    public void theUserTapsOnRefillButton() {
        bonusPage.tapOnRefillBtn();
    }

    @And("taps on Top up my account")
    public void tapsOnTopUpMyAccount() {
        bonusPage.tapTopUpMtAccount();
    }

    @And("selects paypal as a top up method")
    public void selectsPaypalAsATopUpMethod() {
        bonusPage.selectPaypal();
    }

    @And("^enters (.*) and confirms$")
    public void entersAmount_to_top_upAndConfirms(String amountToTopUp) {
        bonusPage.enterTopUpAmount(amountToTopUp);
        bonusPage.tapOnConfirmAmount();
        bonusPage.tapOnActionConfirm();
    }

    @And("the user logs into Paypal and confirm the payment")
    public void theUserLogsIntoPaypalAndConfirmThePayment() {
        bonusPage.loginPaypal();
    }

    @Then("top-up completed screen should be displayed")
    public void topUpCompletedScreenShouldBeDisplayed() {
        assertTrue(bonusPage.checkTopUpCompleted());
        bonusPage.tapOnClose();
    }
}
