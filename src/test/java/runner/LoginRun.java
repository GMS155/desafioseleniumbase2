package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = false,
        features = "classpath:features/login.feature",
        //tags = "@soEsse",
        glue = {"steps.login"},
        snippets = CucumberOptions.SnippetType.CAMELCASE


)
public class LoginRun extends RunBase {
/*
    public static WebDriver driver;
    static ProjetosDBSteps projetosDBSteps;

    @BeforeClass
    public static void start() {
        driver = new ChromeDriver();
        projetosDBSteps = new ProjetosDBSteps();
        projetosDBSteps.deletaProjetos();


    }


 */
    @AfterClass
    public static void stop() {

        driver.quit();

    }
}
