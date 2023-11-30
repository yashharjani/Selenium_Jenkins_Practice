package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/FeatureFiles/GoogleSearch.feature",
        glue = {"com.google.search.step.definitions" },
        plugin = { "pretty", "html:target/HTMlReports/report.html",
                "json:target/JSONReports/report.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
