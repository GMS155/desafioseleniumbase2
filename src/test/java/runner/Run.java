package runner;

import dbsteps.ProjetosDBSteps;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.awt.peer.CanvasPeer;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        monochrome = false,
        features = "classpath:features/login.feature",
        tags = "@soEsse",
        glue = {"steps.login"},
        snippets = CucumberOptions.SnippetType.CAMELCASE


)
public class Run extends RunBase {
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