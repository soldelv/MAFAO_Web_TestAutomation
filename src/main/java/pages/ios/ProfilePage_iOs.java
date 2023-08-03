package pages.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.util.Objects;

import static constants.Constants.SECRET_CODE;
import static apis.MafaoAPIs.getAPIUserInfoByID;
import static org.testng.AssertJUnit.fail;
import static utils.CommonMethods.*;

public class ProfilePage_iOs extends BasePage_iOS{
    public ProfilePage_iOs(AppiumDriver driver) {
        super(driver);
    }

    private static String newSecretCode= generateNewPincode();;
    private static String newDisplayName;

    By logOutBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='Log out'])[1]");
    By confirmLogOutBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='logout-button'])[2]");
    By profileOptionBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"Profile \uE61F\"])[2]");
    By settingsBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='Settings'])[1]");
    By notificationsBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"Notifications\"])[1]");
    By myShopOptionBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='My shop'])[1]");

    /** PROFILE */
    By displayNameField = MobileBy.xpath("//XCUIElementTypeTextField[@name='edit-profile-display-name']");
    By editProfileBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"edit-profile-button\"])[2]");
    By nextKeyboardBtn = MobileBy.AccessibilityId("Next:");
    By backBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"back-button\"])[2]");
    By successfulProfileUpdate = MobileBy.AccessibilityId("Update profile successfully");

    /** SETTINGS */
    By secretCodeBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name=\"Secret Code \uE61F\"])[2]");
    By changeMySecretCode = MobileBy.AccessibilityId("Change my secret code \uE61F");
    By successfulReset = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Your new secret code has been successfully changed!']");
    By retryLaterMessage= MobileBy.AccessibilityId("Retry later");
    By okBtn = MobileBy.AccessibilityId("OK");
    By loginNow = MobileBy.xpath("(//XCUIElementTypeOther[@name='back-to-profile-button'])[2]");
    By confirmBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='confirm-login-button'])[2]");
    By backupAccountOption = MobileBy.xpath("(//XCUIElementTypeOther[@name='Backup Account \uE61F\'])[2]");
    By backupBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='backup-button'])[2]");
    By successBackupMgs = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Backup successfully']");
    By returnBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='return-button'])[2]");

    /** SELLER DASHBOARD */
    By sellerDashboardTitle = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Seller Dashboard']");
    By marketplaceProducts = MobileBy.AccessibilityId("Marketplace Products");
    By marketplaceOrders = MobileBy.AccessibilityId("Marketplace Orders");
    By sellerPayments = MobileBy.AccessibilityId("Seller Payments");
    By overviewReports = MobileBy.AccessibilityId("Overview Reports");

    public void tapOnLogOutBtn(){
        tap(logOutBtn);
    }

    public void confirmLogOutBtn(){
        tap(confirmLogOutBtn);
    }

    public void tapOnProfileOption(){
        tap(profileOptionBtn);
    }

    public void tapOnSettingsBtn(){
        scrollDown();
        tap(settingsBtn);
    }

    public void tapOnNotifications(){
        tap(notificationsBtn);
    }
     public void tapOnMyShopOption(){
         tap(myShopOptionBtn);
     }
    public void goBackBtn(){
        tap(backBtn);
    }

    public void tapOnChangeSecretCode(){
        tap(secretCodeBtn);
    }
    public void tapOnBackupAccount(){
        scrollDown();
        tap(backupAccountOption);
    }

    public void tapOnConfirmBackup(){
        tap(backupBtn);
    }


    public void changeDisplayName(){
        tap(displayNameField);
        newDisplayName = "Test"+generateDateTimeString();
        clearAndType(newDisplayName,displayNameField);
        tap(nextKeyboardBtn);
        tap(editProfileBtn);
    }

    public boolean checkDisplayNameHasChanged(){
        holdOn(500);
        return isDisplayed(successfulProfileUpdate);
    }

    public boolean checkBackupSuccessMessage(){
        waitUntilIsDisplayed(returnBtn);
        return isDisplayed(successBackupMgs);
    }

    public void tapOnReturnFromBackUp(){
        tap(returnBtn);
    }

    public void tapOnChangeMySecretCode(){
        tap(changeMySecretCode);
    }

    public void enterCurrentSecretCode(){
        typeFromKeyboard("keypad-", SECRET_CODE);
    }

    public void enterANewSecretCodeTwice(String action) {
        if(Objects.equals(action, "random")){
            typeFromKeyboard("keypad-", newSecretCode);
            typeFromKeyboard("keypad-", newSecretCode);
        }
        if(Objects.equals(action, "reset")){
            typeFromKeyboard("keypad-", SECRET_CODE);
            typeFromKeyboard("keypad-", SECRET_CODE);
        }
    }

    public boolean successfulReset(){
        holdOn(5000);
        if(isDisplayed(retryLaterMessage)){
            tap(okBtn);
            fail("Error to reset the pincode");
            return false;
        }else if(isDisplayed(successfulReset)){
            return true;
        }else{
            fail("Can not proceed to reset pincode");
            return false;
        }
    }
    public void tapOnLoginNow(){
        tap(loginNow);
    }

    public void loginWithNewSecretCode(String action){
        if(Objects.equals(action, "random")){
            typeFromKeyboard("keypad-", newSecretCode);
        }
        if(Objects.equals(action, "reset")){
            typeFromKeyboard("keypad-", SECRET_CODE);
        }
        tap(confirmBtn);
    }

    public void resetSecretCodeToDefault(){
        scrollDown();
        tapOnSettingsBtn();
        tapOnChangeSecretCode();
        typeFromKeyboard("keypad-", newSecretCode);
        tapOnChangeMySecretCode();
        typeFromKeyboard("keypad-", newSecretCode);
        enterANewSecretCodeTwice("reset");
        if(successfulReset()){
            tapOnLoginNow();
        }
        loginWithNewSecretCode("reset");
    }

    public boolean checkSellerDashboardIsDisplayed(){
        waitUntilIsDisplayed(sellerDashboardTitle);
        return isDisplayed(marketplaceProducts) && isDisplayed(marketplaceOrders)
                && isDisplayed(sellerPayments) && isDisplayed(overviewReports);
    }

    public boolean checkDisplayedName(){
        By display_name = MobileBy.xpath("//XCUIElementTypeStaticText[@name='"+ getAPIUserInfoByID().getDisplay_name()+"']");
        return isDisplayed(display_name);
    }

    public boolean checkProfilePicture(){
        By profile_picture = MobileBy.xpath("//XCUIElementTypeOther[@name=\"\uF148 Bonus Balance view-balance-button ****** Compagnon "+ getAPIUserInfoByID().getDisplay_name()+" Total points 2120 pts Next goal Mentor 5000 pts\"]/XCUIElementTypeOther[4]");
        return isDisplayed(profile_picture);
    }
}
