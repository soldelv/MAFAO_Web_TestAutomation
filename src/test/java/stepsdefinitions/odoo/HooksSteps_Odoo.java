package stepsdefinitions.odoo;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import static utils.CommonMethods.print;

public class HooksSteps_Odoo {
    private WebDriver webDriver;
    private final TestContext context;

    public HooksSteps_Odoo(TestContext context) {
        this.context = context;
    }

    @Before
    public void driverSetUp(Scenario scenario){
        webDriver = DriverFactory.initializeDriver();
        context.driver = webDriver;
    }

    @After
    public void driverTearDown(Scenario scenario){
        webDriver.close();
        webDriver.quit();
    }
}
