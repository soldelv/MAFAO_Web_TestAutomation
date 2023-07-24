package stepsdefinitions;

import factory.AndroidDriverFactory;
import factory.iOSDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class HooksSteps {
    private static AppiumDriver driver;
    //@Before
    public void driverSetUp() throws MalformedURLException, URISyntaxException {
        /* IOS ENVIRONMENT */
        driver = iOSDriverFactory.initializeIOSDriver();

        /* ANDROID ENVIRONMENT */
        //driver = AndroidDriverFactory.initializeAndroidDriver();
        //driver = AndroidDriverFactory.initializeAndroidRealDevice();
    }

    //@After
    public void driverTearDown(){
        if (null != driver) {
            driver.quit();
        }
    }

    public static AppiumDriver getDriver() {
        return driver;
    }


}
