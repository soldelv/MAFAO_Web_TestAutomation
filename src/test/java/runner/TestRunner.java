package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepsdefinitions",

        tags = {"@test-set:regression and not (@ignore or @exclude:test-need-fix)"},

        plugin = {
                "pretty", "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-html-reports",
                "junit:target/reports/cucumber.xml",
                "unused:target/cucumber-reports/unused-steps.txt"
        },
        monochrome = true
)
public class TestRunner {
    @AfterClass
    public static void end(){
        // TODO
        //Reports.generateReport();
        System.out.println("Here I should have a method to generate reports");
    }
}