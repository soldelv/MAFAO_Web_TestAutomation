package pages.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static org.testng.AssertJUnit.fail;
import static utils.CommonMethods.*;

public class OrdersPage_iOS extends BasePage_iOS {
    public OrdersPage_iOS(AppiumDriver driver) {
        super(driver);
    }

    By payOrderBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='Pay your order'])[2]");

    By changePaymentBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='Change'])[2]");

    By mafaoWalletOption = MobileBy.xpath("(//XCUIElementTypeOther[@name='type-4'])[2]");

    By continueBtn = MobileBy.AccessibilityId("Continue");

    By orderSuccessMessage = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Thank you for your order']");

    By insufficientFunds = MobileBy.AccessibilityId("Insufficient funds");
    By okInsufficientFunds = MobileBy.AccessibilityId("OK");
    By continueShoppingBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='continue_shopping_btn'])[2]");

    By trashBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='minus-button quantity-input plus-button'])[1]/XCUIElementTypeOther[2]");
    By paidOrderTab = MobileBy.AccessibilityId("Paid orders");
    By transactionDetailsTitle = MobileBy.xpath("//XCUIElementTypeStaticText[@name='View order details']");

    public boolean checkProductIsOnOrders(String productName){
        holdOn(800);
        By product = MobileBy.xpath("//XCUIElementTypeOther[contains(@name, 'product-"+productName+"')]");
        return isDisplayed(product);
    }

    public boolean checkProductRemovedFromCart(){
        holdOn(800);
        By message = MobileBy.AccessibilityId("Removed product successfully");
        return isDisplayed(message);
    }

    public void tapOnPayOrder(){
        tap(payOrderBtn);
    }

    public void checkPurchaseSuccessful(){
        holdOn(800);
        if(isDisplayed(orderSuccessMessage)){
            tapOnContinueShoppingBtn();
        }else if(isDisplayed(insufficientFunds)){
            tap(okInsufficientFunds);
            print("User with Insufficient Funds is not able to purchase");
        }else{
            fail("Order can not proceed");
        }
    }

    public void tapOnTrashIcon(){
        tap(trashBtn);
    }

    public void tapOnChangePaymentMethod(){
        scrollDown();
        scrollDown();
        tap(changePaymentBtn);
    }

    public void selectMafaoWallet(){
        tap(mafaoWalletOption);
    }

    public void tapOnContinuePaymentMethod(){
        tap(continueBtn);
    }

    public void tapOnContinueShoppingBtn(){
        tap(continueShoppingBtn);
    }

    public void tapOnPaidOrderTab(){
        tap(paidOrderTab);
    }

    public boolean checkIsInPaidOrders(String productName){
        String pickUpLocation = "Viyline Cosmetics, 426 Paltok, Manila";
        By order = MobileBy.xpath("(//XCUIElementTypeOther[@name='"+productName+" Quantity: 1 Paid on "+todayDayAndMonth()+" In preparation "+pickUpLocation+" \uF214\'])[2]");
        return isDisplayed(order);
    }

    public void tapOnOrder(String productName){
        String pickUpLocation = "Viyline Cosmetics, 426 Paltok, Manila";
        By order = MobileBy.xpath("(//XCUIElementTypeOther[@name=\'"+productName+" Quantity: 1 Paid on "+todayDayAndMonth()+" In preparation "+pickUpLocation+" \uF214\'])[2]");
        tap(order);
    }

    public boolean checkTransactionDetailsAreDisplayed(){
        return isDisplayed(transactionDetailsTitle);
    }

}
