package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = false,
        features = "classpath:features/projeto.feature",
        //tags = "@SoEsse",
        glue = {"steps.projeto"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class ProjetoRun extends RunBase {

  // static ExtentsReportsUtils extentsReportsUtils = new ExtentsReportsUtils();


  //  @BeforeClass
   // public static void start() {

       // extentsReportsUtils.ExtentReport();
        //ExtentsReportsUtils.addTest("teste", "5");

   // }
//@BeforeClass
//public static void test(){

   // hooks hookss = new hooks();
//


    @AfterClass
    public static void stop() {

       // extentsReportsUtils.FlushReport();

//        ExtentBDDReporter bdd = new ExtentBDDReporter("target/teste.html");
//        ExtentReports extentReports =  new ExtentReports();
//        extentReports.attachReporter(bdd);
        driver.quit();

    }

}
