package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue= "Steps",

        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        tags = "@Regression"
        //tags = "@Scenario1"


)

public class JunitRunnerTest {
}
