package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
/*
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepsdefinitions",

        tags = "@user-type:admin",
        //tags = "@test-set:regression",

        plugin = {
                "pretty", "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-html-reports",
                "junit:target/reports/cucumber.xml",
                "unused:target/cucumber-reports/unused-steps.txt"
        },
        monochrome = true
)*/

public class TestRunner {
    /*@AfterClass
    public static void end(){
        // TODO
        //Reports.generateReport();
        System.out.println("Here I should have a method to generate reports");
    }*/
}