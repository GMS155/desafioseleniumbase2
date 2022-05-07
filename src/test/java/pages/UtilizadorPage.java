package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class UtilizadorPage {

    WebDriver driver;

    public UtilizadorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarAplicacao() throws InterruptedException {


        driver.get("http://localhost:81/testlink/login.php");
        Thread.sleep(10000);
    }

    public void preencheLoginUtilizador(String login) {
        driver.findElement(By.id("login")).sendKeys(login);
    }

    public void preencheSenhaUtilizador(String senha) {
        driver.findElement(By.id("password")).sendKeys(senha);
    }

    public void preencheRepetirSenhaUtilizador(String senha) {
        driver.findElement(By.id("password2")).sendKeys(senha);
    }

    public void preencheNomeUtilizador(String nome) {
        driver.findElement(By.id("firstName")).sendKeys(nome);
    }

    public void preencheApelidoUtilizador(String apelido) {
        driver.findElement(By.id("lastName")).sendKeys(apelido);
    }

    public void preencheEmailUtilizador(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }


    public void clicarBotaoAdicionarDadosUtilizador() throws InterruptedException {

        driver.findElement(By.name("doEditUser")).click();

    }

    public void clicarBotaoNovoUtilizador() throws InterruptedException {

        driver.findElement(By.id("tl_sign_up")).click();

    }

    public void verificaBotaoNovoUtilizador() throws InterruptedException{
        Boolean visible = driver.findElement(By.xpath("//input[@name='doEditUser']")).isDisplayed();
        Assert.assertEquals(true, visible);
    }



}
