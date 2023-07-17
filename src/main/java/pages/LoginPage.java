package pages;

import apis.MafaoAPIs;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import static utils.CommonMethods.holdOn;
import static utils.CommonMethods.print;

public class LoginPage extends BasePage {
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }
    By loginBtn = MobileBy.AccessibilityId("btn-login");
    By signUpBtn = MobileBy.AccessibilityId("btn-sign-up");
    By countryFlagIcon = MobileBy.AccessibilityId("telephone-country-flag-code");
    By countrySearchInput = MobileBy.AccessibilityId("country-search-input");
    By countrySearched = MobileBy.AccessibilityId("country-search-option-0");
    By phoneInput = MobileBy.AccessibilityId("phone-auth-input-phone");
    By sendCodeBtn = MobileBy.AccessibilityId("btn-send-code");
    By phoneOTPInput = MobileBy.AccessibilityId("phone-otp-input");
    By submitBtn = MobileBy.AccessibilityId("btn-submit");
    By confirmLoginBtn = MobileBy.AccessibilityId("confirm-login-button");
    By profileIcon = MobileBy.AccessibilityId("perfil");
    By errorLogin = MobileBy.xpath("//*[@text=\"You entered an invalid pincode. Please try again.\"]");

    /* KEY PATH LOCATORS */
    By keypathDelete = MobileBy.AccessibilityId("keypad-delete");
    By deleteBtn = MobileBy.AccessibilityId("Delete");

    public void tapOnLoginBtn()  {
        print("try to click on login");
        tap(loginBtn);
    }

    public boolean checkIsOnLoginScreen() {
        holdOn(1000);
        return isDisplayed(getElement(countryFlagIcon));
    }

    public void tapOnFlagIcon(){
        tap(countryFlagIcon);
    }

    public void searchCountry(String country) {
        type(country, countrySearchInput);
    }

    public void tapOnSearchedCountry() {
        tap(countrySearched);
        tap(countrySearched);
    }

    public void enterMobileNumber(String mobileNumber) {
        type(mobileNumber, phoneInput);
        tap(sendCodeBtn);
        tap(sendCodeBtn);
        holdOn(1000);
    }

    public void enterOTPCode(String countryCode, String mobileNumber) throws Exception {
        String full_mobileNumber = countryCode+mobileNumber;
        String otpCode = MafaoAPIs.getOTPCode(full_mobileNumber);
        print("OTP CODE "+otpCode);
        type("1", phoneOTPInput);
        tap(deleteBtn);
        typeFromKeyboard("", otpCode);
        tap(getElement(submitBtn));
        tap(getElement(submitBtn));
    }

    public void enterSecretCode(String secretCode) {
        typeFromKeyboard("keypad-", secretCode);
        tap(confirmLoginBtn);
    }

    public boolean checkSuccessLogin() {
        return isDisplayed(getElement(profileIcon));
    }

    public boolean getErrorLoginMsg() {
        return isDisplayed(getElement(errorLogin));
    }

}