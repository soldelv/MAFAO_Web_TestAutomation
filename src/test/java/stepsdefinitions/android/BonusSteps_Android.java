package stepsdefinitions.android;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.android.BonusPage_Android;
import stepsdefinitions.HooksSteps;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BonusSteps_Android {
    private final AppiumDriver driver = HooksSteps.getDriver();
    private final BonusPage_Android bonusPage_Android = new BonusPage_Android(driver);

    @When("taps on refill button - Android")
    public void tapsOnRefillButtonAndroid() {
        bonusPage_Android.tapOnRefillBtn();
    }

    @And("taps on Top up my account - Android")
    public void tapsOnTopUpMyAccountAndroid() {
        bonusPage_Android.tapTopUpMtAccount();
    }

    @And("selects paypal as a top up method - Android")
    public void selectsPaypalAsATopUpMethodAndroid() {
        bonusPage_Android.selectPaypal();
    }

    @And("enters (.*) and confirms - Android$")
    public void entersAmount_to_top_upAndConfirmsAndroid(String amountToTopUp) {
        bonusPage_Android.enterTopUpAmount(amountToTopUp);
        bonusPage_Android.tapOnConfirmAmount();
        bonusPage_Android.tapOnActionConfirm();
    }

    @And("the user logs into Paypal and confirm the payment - Android")
    public void theUserLogsIntoPaypalAndConfirmThePaymentAndroid() {
        bonusPage_Android.loginPaypal();
    }

    @Then("top-up completed screen should be displayed - Android")
    public void topUpCompletedScreenShouldBeDisplayedAndroid() {
        assertTrue(bonusPage_Android.checkTopUpCompleted());
        bonusPage_Android.tapOnClose();
    }
}
