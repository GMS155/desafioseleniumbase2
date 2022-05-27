package runner;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import dbsteps.PerfisDbSteps;
import dbsteps.ProjetosDBSteps;
import dbsteps.UsuariosDBSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import support.GlobalParameters;

import java.net.MalformedURLException;
import java.net.URL;

public class RunBase {
    public RunBase() {

    }

    static ProjetosDBSteps projetosDBSteps;
    static PerfisDbSteps perfisDbSteps;
    static UsuariosDBSteps usuariosDBSteps;
    static WebDriver driver;
    //static String browser = GlobalParameters.BROWSER_DEFAULT;

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

        new GlobalParameters();
        String execution = GlobalParameters.EXECUTION;
        String seleniumHub = GlobalParameters.SELENIUM_HUB;

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
        if (execution.equals("local")) {
            switch (navegador) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    System.setProperty("webdriver.edge.driver","C:\\Users\\guilhermeSantos\\Documents\\Base2\\Desafio_Automacao_Base2\\desafioseleniumbase2\\msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Passe um navegador válido");
            }
        }

        if (execution.equals("remoto")) {
            switch (navegador) {
                case "chrome":

                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                    //capabilities.setBrowserName("chrome");
                    try {
                        driver = new RemoteWebDriver(new URL(seleniumHub), capabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "firefox":
                    DesiredCapabilities capabilitiesF = DesiredCapabilities.firefox();
                    try {
                        driver = new RemoteWebDriver(new URL(seleniumHub), capabilitiesF);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "edge":
                    //System.setProperty("webdriver.edge.driver","C:\\Users\\guilhermeSantos\\Documents\\Base2\\Desafio_Automacao_Base2\\desafioseleniumbase2\\seleniumgrid\\msedgedriver.exe");
                    DesiredCapabilities capabilitiesE = DesiredCapabilities.edge();
                    try {

                        driver = new RemoteWebDriver(new URL(seleniumHub), capabilitiesE);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Passe um navegador válido");
            }
        }
        return driver;
    }
}