package stepsdefinitions;

import factory.iOSDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static apis.MafaoAPIs.getAlertsQuantity;

public class HooksSteps {
    private static AppiumDriver driver;
    @Before
    public void driverSetUp() throws MalformedURLException, URISyntaxException {
        driver = iOSDriverFactory.initializeIOSDriver();
    }

    @After
    public void driverTearDown(){
        if (null != driver) {
            driver.quit();
        }
    }

    public static AppiumDriver getDriver() {
        return driver;
    }


}
