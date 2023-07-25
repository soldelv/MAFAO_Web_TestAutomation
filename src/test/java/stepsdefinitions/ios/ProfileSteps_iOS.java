package stepsdefinitions.ios;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import pages.ios.BonusPage_iOS;
import pages.ios.ProfilePage_iOs;
import stepsdefinitions.HooksSteps;

public class ProfileSteps_iOS {

    private final AppiumDriver driver = HooksSteps.getDriver();
    private final ProfilePage_iOs profilePage = new ProfilePage_iOs(driver);

    @And("clicks on log out")
    public void clicksOnLogOut() {
        profilePage.tapOnLogOutBtn();
        profilePage.confirmLogOutBtn();
    }

}
