package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/ios",
        glue = "stepsdefinitions",

        tags = {"@RegressionTest"},

        plugin = {
                "pretty", "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-html-reports",
                "junit:target/reports/cucumber.xml"
        },
        monochrome = true
)
public class TestRunner_iOS {
}