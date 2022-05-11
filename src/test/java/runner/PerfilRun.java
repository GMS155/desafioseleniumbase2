package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = false,
        features = "classpath:features/perfis.feature",
        //tags = "@SoEsse",
        glue = {"steps.perfil"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)


public class PerfilRun extends RunBase{

    @AfterClass
    public static void stop() {
        driver.quit();

    }
}
