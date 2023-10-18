package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "stepsdefinitions",

        tags = "@regressions",

        plugin = {
                "pretty", "json:target/cucumber-reports/cucumber.json",
                "json:target/cucumber/report.json",
                "html:target/cucumber/report.html"
        },
        monochrome = true
)

public class TestRunner {
    @AfterClass
    public static void end(){
        System.out.println("Here I should have a method to generate reports");
    }
}