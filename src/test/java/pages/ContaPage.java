package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.Utils;


public class ContaPage {

    WebDriver driver;

    public ContaPage(WebDriver driver) {
        this.driver = driver;

    }

    public void acessarAplicacao() throws InterruptedException {

        driver.get("http://localhost:81/testlink/login.php");
        Thread.sleep(10000);
    }

    public void preendheUsuario(String usuario) {

        driver.findElement(By.id("tl_login")).sendKeys(usuario);
        //jse.executeScript("document.querySelector(\"#tl_login\").innerHTML = 'gui'");

    }

    public void preencheSenha(String senha) {
        driver.findElement(By.id("tl_password")).sendKeys(senha);
    }

    public void scroolPage() {
        //Quando tem scroll na tela e não consegue chegar no elemento no final da página
        // JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("window.scrollTo(0,10000)");
        //Thread.sleep(2000);
    }

    public void clicarBotaoLogin() throws InterruptedException {
        WebElement button = driver.findElement(By.id("tl_login_button"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", button);


        //  driver.findElement(By.id("tl_login_button")).click();

    }

    public void clicarBotaoConfiguracoesPessoais() throws InterruptedException {


        //Utils utils = new Utils();
        //utils.esperarElementoClicavel(By.cssSelector("a[href=\"lib/issuetrackers/issueTrackerView.php?tproject_id=1\"]"), 30);
        driver.findElement(By.xpath("/html/body/div[3]/a[2]/img")).click();


    }
}
