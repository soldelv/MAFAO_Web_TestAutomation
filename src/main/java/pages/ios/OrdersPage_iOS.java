package pages.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static utils.CommonMethods.holdOn;
import static utils.CommonMethods.print;

public class OrdersPage_iOS extends BasePage_iOS {
    public OrdersPage_iOS(AppiumDriver driver) {
        super(driver);
    }

    By payOrderBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='Pay your order'])[2]");

    By changePaymentBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='Change'])[2]");

    By mafaoWalletOption = MobileBy.xpath("(//XCUIElementTypeOther[@name='type-4'])[2]");

    By continueBtn = MobileBy.AccessibilityId("Continue");

    By orderSuccessMessage = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Thank you for your order']");
    By continueShoppingBtn = MobileBy.xpath("//android.view.ViewGroup[@content-desc='continue_shopping_btn']");

    By trashBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='minus-button quantity-input plus-button'])[1]/XCUIElementTypeOther[2]");
    By cartEmptyMessage = MobileBy.xpath("//android.widget.TextView[contains(@text, 'Your cart is empty')]");

    public boolean checkProductIsOnOrders(String productName){
        holdOn(800);
        By product = MobileBy.xpath("//XCUIElementTypeOther[contains(@name, 'product-"+productName+"')]");
        return isDisplayed(getElement(product));
    }

    public boolean checkProductRemovedFromCart(){
        holdOn(800);
        try{
            By message = MobileBy.AccessibilityId("Removed product successfully");
            return isDisplayed(message);
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public void tapOnPayOrder(){
        tap(payOrderBtn);
    }

    public boolean checkPurchaseSuccessful(){
        holdOn(800);
        boolean displayed = false;
        try {
            displayed = isDisplayed(getElement(orderSuccessMessage));
        }catch(NoSuchElementException e){
            print("Message not found");
        }
        return displayed;
    }

    public void tapOnTrashIcon(){
        tap(trashBtn);
    }

    public void tapOnChangePaymentMethod(){
        scrollDown();
        tap(changePaymentBtn);
    }

    public void selectMafaoWallet(){
        tap(mafaoWalletOption);
    }

    public void tapOnContinuePaymentMethod(){
        tap(continueBtn);
    }

}
