package steps.login;


import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LoginPage;
import runner.LoginRun;


public class LoginStep extends LoginRun {

    LoginPage loginPage = new LoginPage();
    String retornoMensagemErro = "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.";


    @Dado("que o usuario preencha o campo usuario corretamente")
    public void queOUsuarioPreenchaOCampoUsuarioCorretamente() {

        loginPage.preendheUsuario("administrator");
    }

    @Dado("preencha o campo senha corretamente")
    public void preenchaOCampoSenhaCorretamente() {

        loginPage.preencheSenha("root");
    }

    @Quando("e clicado no botao Login")
    public void eClicadoNoBotaoLogin() throws InterruptedException {

        loginPage.clicarBotaoLogin();
    }

    @Entao("o login deve ser realizado com sucesso")
    public void oLoginDeveSerRealizadoComSucesso() throws InterruptedException {

        String nomeLogin = loginPage.confirmaLoginComSucesso();
        Assert.assertEquals(nomeLogin, "administrador");
    }

    @Dado("que o usuario esteja na pagina de login do Testlink")
    public void queOUsuarioEstejaNaPaginaDeLoginDoTestlink() throws InterruptedException {

    }

    @Dado("preencha o campo senha com valor invalido")
    public void preenchaOCampoSenhaComValorInvalido() {

        loginPage.preencheSenha("123456");
    }

    @Entao("a aplicacao deve emitir uma mensagem de erro")
    public void aAplicacaoDeveEmitirUmaMensagemDeErro() {

        Assert.assertEquals(retornoMensagemErro, loginPage.mensagemErroLogin());
    }

    @Dado("que o usuario preencha o campo usuario com valor invalido")
    public void queOUsuarioPreenchaOCampoUsuarioComValorInvalido() {

        loginPage.preendheUsuario("guilherme");
    }

    @Entao("a aplicacao deve permanecer na tela de login")
    public void aAplicacaoDevePermanecerNaTelaDeLogin() {

        Boolean TestVisible = getDriver().findElement(By.id("tl_login_button")).isDisplayed();
        Assert.assertTrue(TestVisible);
    }

    @Dado("que o usuario esteja na pagina de login do Mantis")
    public void queOUsuarioEstejaNaPaginaDeLoginDoMantis() throws InterruptedException {

        loginPage.acessarAplicacao();
    }

    @E("clique no botao Entrar")
    public void cliqueNoBotaoEntrar() throws InterruptedException {

        loginPage.clicarBotaoEntrar();
    }

    @Quando("e clicado no botao Entrar")
    public void eClicadoNoBotaoEntrar() throws InterruptedException {

        loginPage.clicarBotaoEntrar();
    }

    @Quando("e clicado no botao Entrar novamente")
    public void eClicadoNoBotaoEntrarNovamente() throws InterruptedException {

        loginPage.clicarBotaoEntrar();
    }

    @Quando("que o usuario preencha o campo usuario e senha")
    public void queOUsuarioPreenchaOCampoUsuarioESenha() {

        loginPage.preenchereUsuarioJS("administrator");
        loginPage.clicarEntrarJS();
        loginPage.preencherSenhaJS("root");
    }
}
