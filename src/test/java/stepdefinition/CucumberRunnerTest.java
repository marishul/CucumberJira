package stepdefinition;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        strict = true,
        monochrome = true,
        features = {"src/test/resources/features/"},
        glue = "stepdefinition",
        plugin = {"pretty", "html:target/cucumber-html-report"},
        tags = ("@Regression")
)

public class CucumberRunnerTest {

}