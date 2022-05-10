package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import runner.Run;
import support.GlobalParameters;


public class LoginPage extends Run {


    private By campoUsuario = By.id("username");
    private By botaoEntrar = By.xpath("//input[@class='width-40 pull-right btn btn-success btn-inverse bigger-110']");
    private By campoSenha = By.id("password");
    private By mensagemLoginSucesso = By.xpath("//span[text()='administrador']");
    private By mensagemLoginErro = By.xpath("//div[@class='alert alert-danger']");


    // --------------------------------- Login -----------------------------------------

    public void acessarAplicacao() throws InterruptedException {
        new GlobalParameters();
        getDriver(GlobalParameters.BROWSER_DEFAULT);
        getDriver().get("http://localhost:8080/mantisbt/login_page.php");
    }

    public void preendheUsuario(String usuario) {


        getDriver().findElement(campoUsuario).sendKeys(usuario);
        //jse.executeScript("document.querySelector(\"#tl_login\").innerHTML = 'gui'");


    }

    public void clicarBotaoEntrar() throws InterruptedException {

        getDriver().findElement(botaoEntrar).click();


        //JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("arguments[0].click();", button);

        //  driver.findElement(By.id("tl_login_button")).click();

    }

    public void preencheSenha(String senha) {
        getDriver().findElement(campoSenha).sendKeys(senha);
    }

    public String confirmaLoginComSucesso() {
        String mensagemErro = getDriver().findElement(mensagemLoginSucesso).getText();
        return mensagemErro;

    }

    public String mensagemErroLogin() {
        String mensagemErro = getDriver().findElement(mensagemLoginErro).getText();
        return mensagemErro;

    }

// --------------------------------- Login Java Script -----------------------------------------


    public void preenchereUsuarioJS(String usuario) {
        WebElement element = getDriver().findElement(campoUsuario);

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].value='" + usuario + "';", element);

    }

    public void preencherSenhaJS(String senha) {
        WebElement element = getDriver().findElement(campoSenha);

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].value='" + senha + "';", element);

    }

    public void clicarEntrarJS() {
        WebElement element = getDriver().findElement(botaoEntrar);

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click();", element);

    }

// --------------------------------- -----------------------------------------

    public void scroolPage() {
        //Quando tem scroll na tela e não consegue chegar no elemento no final da página
        // JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("window.scrollTo(0,10000)");
        //Thread.sleep(2000);
    }

    public void clicarBotaoLogin() throws InterruptedException {
        WebElement button = getDriver().findElement(By.id("tl_login_button"));

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click();", button);


        //  driver.findElement(By.id("tl_login_button")).click();

    }


}
