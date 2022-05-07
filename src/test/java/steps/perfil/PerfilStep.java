package steps.perfil;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.LoginPage;
import pages.PerfilPage;
import pages.ProjetoPage;

import java.util.ArrayList;

public class PerfilStep {

    ProjetoPage projetoPage = new ProjetoPage();
    LoginPage loginPage = new LoginPage();
    PerfilPage perfilPage = new PerfilPage();


    @Dado("que o usuário esteja na página de login do Mantis")
    public void queOUsuárioEstejaNaPáginaDeLoginDoMantis() throws InterruptedException {

        loginPage.acessarAplicacao();
    }

    @Dado("que o usuário tenha feito o login com sucesso")
    public void queOUsuárioTenhaFeitoOLoginComSucesso() throws InterruptedException {


        loginPage.preendheUsuario("administrator");
        loginPage.clicarBotaoEntrar();
        loginPage.preencheSenha("root");
        loginPage.clicarBotaoEntrar();

    }

    @Quando("acessar a tela de gerenciar perfil")
    public void acessarATelaDeGerenciarPerfil() throws InterruptedException {

        perfilPage.clicarBotaoGerenciar();
        perfilPage.clicarBotaoGerenciarProjetos();

    }

    @E("preencher a plataforma corretamente")
    public void preencherAPlataformaCorretamente() throws InterruptedException {

        perfilPage.preencherPlataforma("teste");
    }

    @E("preencher o SO corretamente")
    public void preencherOSOCorretamente() throws InterruptedException {

        perfilPage.preencherSO("Windows");
    }


    @E("preencher a versão do SO corretamente")
    public void preencherAVersãoDoSOCorretamente() throws InterruptedException {

        perfilPage.preencherVersao("2.14.1");
    }


    @E("preencher a descricao do sistema corretamente")
    public void preencherADescricaoDoSistemaCorretamente() throws InterruptedException {

        perfilPage.preencherDescricao("Novo versão do sistema operacional!");
    }

    @E("clicar no botão adicionar perfil")
    public void clicarNoBotãoAdicionarPerfil() throws InterruptedException {

        perfilPage.clicarBotaoAdicionarPerfil();
    }

    @Então("o sistema deve cadastrar o perfil com sucesso")
    public void oSistemaDeveCadastrarOPerfilComSucesso() {
        ArrayList<String> list = perfilPage.valisdaPerfilCriado();

        Assert.assertEquals("Valida plataforma cadastrado com sucesso", list.get(0), "teste");
        Assert.assertEquals("Valida so cadastrado com sucesso", list.get(1), "Windows");
        Assert.assertEquals("Valida versão cadastrado com sucesso", list.get(2), "2.14.1");

    }


    @Então("o sistema deve permanecer na mesma tela de cadastro")
    public void oSistemaDevePermanecerNaMesmaTelaDeCadastro() throws InterruptedException {

        perfilPage.verificaTelaAdicionaPerfil();
    }

    @E("deixar o campo plataforma em branco")
    public void deixarOCampoPlataformaEmBranco() throws InterruptedException {

        perfilPage.preencherPlataforma("");
    }

    @E("deixar o campo SO em branco")
    public void deixarOCampoSOEmBranco() throws InterruptedException {

        perfilPage.preencherSO("");
    }

    @E("e deixar o campo versão SO em branco")
    public void eDeixarOCampoVersãoSOEmBranco() throws InterruptedException {

        perfilPage.preencherVersao("");
    }

    @E("clicar no botão apagar")
    public void clicarNoBotãoApagar() throws InterruptedException {

        perfilPage.clicarBotaoApagarPerfis();
    }

    @Então("o sistema deve excluir o perfil desejado corretamente")
    public void oSistemaDeveExcluirOPerfilDesejadoCorretamente() throws InterruptedException {


        Assert.assertNotEquals("Valida exclusão perfil com sucesso",perfilPage.validaPerfilExcluido(), "Insert SQL");

    }


}
