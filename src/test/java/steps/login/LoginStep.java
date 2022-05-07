package steps.login;


import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LoginPage;
import runner.Run;


public class LoginStep extends Run {

    LoginPage loginPage = new LoginPage();
    String retornoMensagemErro = "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.";


    @Dado("que o usuário preencha o campo usuário corretamente")
    public void queOUsuárioPreenchaOCampoUsuárioCorretamente() {
        loginPage.preendheUsuario("administrator");

    }


    @Dado("preencha o campo senha corretamente")
    public void preenchaOCampoSenhaCorretamente() {

        loginPage.preencheSenha("root");
    }


    @Quando("é clicado no botão Login")
    public void éClicadoNoBotãoLogin() throws InterruptedException {
        loginPage.clicarBotaoLogin();
    }


    @Então("o login deve ser realizado com sucesso")
    public void oLoginDeveSerRealizadoComSucesso() throws InterruptedException {

        String nomeLogin = loginPage.confirmaLoginComSucesso();
        Assert.assertEquals(nomeLogin, "administrador");

        //Utils utils = new Utils();
        // Thread.sleep(10000);
        //utils.esperarElementoClicavel(By.xpath("//iframe[@class='navigationBar']"), Duration.ofMillis(1000));
        //utils.esperarElementoClicavel(By.id("navbar"), Duration.ofMillis(1000));


        //Boolean visible = driver.findElement(By.id("navbar")).isDisplayed();
        //Assert.assertEquals(true, visible);
        //String text = driver.findElement(By.cssSelector("body:nth-child(2) div.menu_title:nth-child(2) > span.bold:nth-child(1)")).getText();
        //System.out.println("jlkfhlkask hfjas" + text);
    }


    @Dado("que o usuário esteja na página de login do Testlink")
    public void queOUsuárioEstejaNaPáginaDeLoginDoTestlink() throws InterruptedException {

    }


    @Dado("preencha o campo senha com valor inválido")
    public void preenchaOCampoSenhaComValorInválido() {
        loginPage.preencheSenha("123456");
    }


    @Então("a aplicação deve emitir uma mensagem de erro")
    public void aAplicaçãoDeveEmitirUmaMensagemDeErro() {

        Assert.assertEquals(retornoMensagemErro, loginPage.mensagemErroLogin());
    }


    @Dado("que o usuário preencha o campo usuário com valor inválido")
    public void queOUsuárioPreenchaOCampoUsuárioComValorInválido() {
        loginPage.preendheUsuario("guilherme");
    }


    @Então("a aplicação deve permanecer na tela de login")
    public void aAplicaçãoDevePermanecerNaTelaDeLogin() {
        Boolean TestVisible = getDriver().findElement(By.id("tl_login_button")).isDisplayed();
        Assert.assertTrue(TestVisible);
    }

    @Dado("que o usuário esteja na página de login do Mantis")
    public void queOUsuárioEstejaNaPáginaDeLoginDoMantis() throws InterruptedException {

        loginPage.acessarAplicacao();
    }

    @E("clique no botão Entrar")
    public void cliqueNoBotãoEntrar() throws InterruptedException {

        loginPage.clicarBotaoEntrar();
    }

    @Quando("é clicado no botão Entrar")
    public void éClicadoNoBotãoEntrar() throws InterruptedException {

        loginPage.clicarBotaoEntrar();
    }

    @Quando("é clicado no botão Entrar novamente")
    public void éClicadoNoBotãoEntrarNovamente() throws InterruptedException {

        loginPage.clicarBotaoEntrar();
    }

    @Quando("que o usuário preencha o campo usuário e senha")
    public void queOUsuárioPreenchaOCampoUsuárioESenha() {

        loginPage.preenchereUsuarioJS("administrator");
        loginPage.clicarEntrarJS();
        loginPage.preencherSenhaJS("root");

    }
}
