package runner;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import dbsteps.PerfisDbSteps;
import dbsteps.ProjetosDBSteps;
import dbsteps.UsuariosDBSteps;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import support.GlobalParameters;

public class RunBase {
    public RunBase() {


    }

    static ProjetosDBSteps projetosDBSteps;
    static PerfisDbSteps perfisDbSteps;
    static UsuariosDBSteps usuariosDBSteps;
    static WebDriver driver;

   // public static ExtentReports extent;
   // public static ExtentTest cenario;
   // public static ExtentTest feature;
   // public static String reportLocation = "target/reports/";

    public enum Browser {CHROME, FIREFOX, EDGE}



    public static WebDriver getDriver() {
        new GlobalParameters();

        if (driver == null) {
            return getDriver(GlobalParameters.BROWSER_DEFAULT);

        } else {
            return driver;
        }
    }


    public static WebDriver getDriver(String navegador) {


        perfisDbSteps = new PerfisDbSteps();
        projetosDBSteps = new ProjetosDBSteps();
        usuariosDBSteps = new UsuariosDBSteps();


        usuariosDBSteps.excluiUsuarios();
        usuariosDBSteps.insereUsuarios();
        perfisDbSteps.deletaProjetos();
        perfisDbSteps.cadastraPerfis();
        projetosDBSteps.deletaProjetos();
        projetosDBSteps.cadastrarProjetos();

        if (driver != null) {
            driver.quit();
        }
        switch (navegador) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Passe um navegador válido");
        }
        return driver;
    }



}
