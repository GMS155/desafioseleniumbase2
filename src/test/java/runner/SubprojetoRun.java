package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = false,
        features = "classpath:features/subprojeto.feature",
       // tags = "@SoEsse",
        glue = {"steps.subprojeto", "steps.login"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class SubprojetoRun extends RunBase {

    @AfterClass
    public static void stop() {
        driver.quit();

    }
}
