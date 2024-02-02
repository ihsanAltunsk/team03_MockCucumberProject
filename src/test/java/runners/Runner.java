package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/rapor.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-reports/cucumber.xml"},
    features = "src/test/resources/features",
    glue = "stepDefinitions",
    tags = "@",
    dryRun = false
)

public class Runner {}

