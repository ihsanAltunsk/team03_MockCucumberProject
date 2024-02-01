package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources1/features",
    glue = "stepDefinitions",
    tags = "@live",
    dryRun = false
)

public class Runner {}

