package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = false,
        features = "classpath:features/usuario.feature",
        tags = "@SoEsse",
        glue = {"steps.usuario"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class UsuarioRun extends RunBase{

    @AfterClass
    public static void stop() {
        driver.quit();

    }
}
