package pages.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class ProfilePage_iOs extends BasePage_iOS{
    public ProfilePage_iOs(AppiumDriver driver) {
        super(driver);
    }

    //(//XCUIElementTypeOther[@name="Log out"])[1]
    By logOutBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='Log out'])[1]");

    By confirmLogOutBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='logout-button'])[2]");

    public void tapOnLogOutBtn(){
        tap(logOutBtn);
    }

    public void confirmLogOutBtn(){
        tap(confirmLogOutBtn);
    }
}
