package steps.projeto;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginPage;
import pages.ProjetoPage;
import runner.ProjetoRun;

import java.util.ArrayList;


public class ProjetoStep extends ProjetoRun {

    ProjetoPage projetoPage = new ProjetoPage();
    LoginPage loginPage = new LoginPage();


    @Dado("que o usuario tenha feito o login com sucesso")
    public void queOUsuarioTenhaFeitoOLoginComSucesso() throws InterruptedException {


        loginPage.preendheUsuario("administrator");
        loginPage.clicarBotaoEntrar();
        loginPage.preencheSenha("root");
        loginPage.clicarBotaoEntrar();

    }

    @Dado("que o usuario esteja na pagina de login do Mantis")
    public void queOUsuarioEstejaNaPaginaDeLoginDoMantis() throws InterruptedException {

        //projetoPage.acessarAplicacao();
        loginPage.acessarAplicacao();
    }


    @Quando("acessar a tela de criacao de projeto")
    public void acessarATelaDeCriacaoDeProjeto() throws InterruptedException {


        projetoPage.clicarBotaoGerenciar();
        projetoPage.clicarBotaoGerenciarProjetos();
        projetoPage.clicarBotaoCriarNovoProjeto();
    }

    @E("clicar no botao de salvar projeto")
    public void clicarNoBotãoDeSalvarProjeto() throws InterruptedException {
        projetoPage.clicarBotaoAdicionarProjeto();
    }

    @Entao("o sistema deve permanecer na mesma tela de cadastro")
    public void oSistemaDevePermanecerNaMesmaTelaDeCadastro() throws InterruptedException {

        projetoPage.verificaTelaAdicionaProjeto();
    }

    @E("preencher o nome do projeto")
    public void preencherONomeDoProjeto() throws InterruptedException {
        projetoPage.preencherNomeProjeto("Projeto01");
    }


    @E("preencher o estado do projeto")
    public void preencherOEstadoDoProjeto() throws InterruptedException {
        projetoPage.selecionaEstado("estável");
    }

    @E("marcar a opcao herdar categorias globais")
    public void marcarAOpcaoHerdarCategoriasGlobais() {

        projetoPage.clicarHerdarCategorias();
    }

    @E("selecionar a visibilidade do projeto")
    public void selecionarAVisibilidadeDoProjeto() throws InterruptedException {
        projetoPage.selecionaVisibilidade("público");
    }


    @Entao("o sistema deve efetuar o cadastro com sucesso")
    public void oSistemaDeveEfetuarOCadastroComSucesso() throws InterruptedException {
        ArrayList<String> list = projetoPage.validaProjetoCriado();

        Assert.assertEquals("Valida cadastro nome projeto com sucesso", list.get(0), "Projeto01");
        Assert.assertEquals("Valida cadastro estado projeto com sucesso", list.get(1), "estável");
        Assert.assertEquals("Valida cadastro habilitado projeto com sucesso", list.get(2), "");
        Assert.assertEquals("Valida cadastro visibilidade projeto com sucesso", list.get(3), "público");
        Assert.assertEquals("Valida cadastro descricao com sucesso", list.get(4), "Projeto criado como teste");


    }

    @Entao("o sistema deve efetuar o cadastro editado com sucesso")
    public void oSistemaDeveEfetuarOCadastroEditadoComSucesso() throws InterruptedException {

        Assert.assertEquals("Valida cadastro projeto com sucesso", projetoPage.validaProjetoNomeEditado(), "Teste projeto SQL 01_Editado");
    }

    @E("que tenha cadastrado um projeto")
    public void queTenhaCadastradoUmProjeto() throws InterruptedException {

        projetoPage.clicarBotaoGerenciar();
        projetoPage.clicarBotaoGerenciarProjetos();
        projetoPage.clicarBotaoCriarNovoProjeto();
        projetoPage.preencherNomeProjeto("Projeto01");
        projetoPage.selecionaEstado("estável");
        projetoPage.clicarHerdarCategorias();
        projetoPage.selecionaVisibilidade("público");
        projetoPage.prencherDescricao("Projeto criado");
        projetoPage.clicarBotaoAdicionarProjeto();
    }

    @Entao("o sistema deve emitir uma mensagem de erro")
    public void oSistemaDeveEmitirUmaMensagemDeErro() throws InterruptedException {

        Assert.assertEquals("Valida mensagem Erro nome igual", projetoPage.vericaProjetoComMesmoNome(), "APPLICATION ERROR #701");

    }

    @E("preencher o nome do projeto com caractere especial")
    public void preencherONomeDoProjetoComCaractereEspecial() throws InterruptedException {

        projetoPage.preencherNomeProjeto("*&!##@@=");
    }

    @Entao("o sistema deve efetuar o cadastro do caractere especial com sucesso")
    public void oSistemaDeveEfetuarOCadastroDoCaractereEspecialComSucesso() throws InterruptedException {

        ArrayList<String> list = projetoPage.validaProjetoCriadoComCaractereEspecial();
        Assert.assertEquals("Valida cadastro com caractere especial com sucesso", list.get(0), "*&!##@@=");

    }

    @E("preencher o nome do projeto com numero")
    public void preencherONomeDoProjetoComNumero() throws InterruptedException {
        projetoPage.preencherNomeProjeto("8989448489846546");
    }

    @Entao("o sistema deve efetuar o cadastro do numero com sucesso")
    public void oSistemaDeveEfetuarOCadastroDoNumeroComSucesso() throws InterruptedException {

        ArrayList<String> list = projetoPage.validaProjetoCriadoComNumero();
        Assert.assertEquals("Valida cadastro com caractere especial com sucesso", list.get(0), "8989448489846546");


    }

    @Quando("acessar a tela de gerencia de projeto")
    public void acessarATelaDeGerenciaDeProjeto() throws InterruptedException {

        projetoPage.clicarBotaoGerenciar();
        projetoPage.clicarBotaoGerenciarProjetos();

    }


    @E("definir o nome do projeto {string}")
    public void definirONomeDoProjeto(String nome) throws InterruptedException {

        projetoPage.editaNomeProjeto(nome);
    }

    @E("clicar no projeto desejado {string}")
    public void clicarNoProjetoDesejado(String nome) throws InterruptedException {

        projetoPage.clicarProjeto(nome);
    }

    @E("definir o estado do projeto {}")
    public void definirOEstadoDoProjeto(String estado) throws InterruptedException {

        projetoPage.editaEstado(estado);

    }

    @Entao("o sistema deve efetuar o cadastro do {} editado com sucesso")
    public void oSistemaDeveEfetuarOCadastroDoEstadoEditadoComSucesso(String estado) throws InterruptedException {

        Assert.assertEquals("Valida edição estado com sucesso", projetoPage.validaEstadoEditado(estado), estado);

    }

    @E("clicar no campo habilitado")
    public void clicarNoCampoHabilitado() throws InterruptedException {
        projetoPage.clicarhabilitado();
    }

    @Entao("o sistema deve efetuar a alteracao do habilitado com sucesso")
    public void oSistemaDeveEfetuarAAlteracaoDoHabilitadoComSucesso() throws InterruptedException {

        Assert.assertEquals("Valida alteração habilitado com sucesso", projetoPage.validaProjetoHabilitadoEditado(), "");


    }

    @E("definir a visibilidade do projeto {string}")
    public void definirAVisibilidadeDoProjeto(String visibilidade) throws InterruptedException {

        projetoPage.selecionaVisibilidade(visibilidade);
    }

    @Entao("o sistema deve efetuar a alteracao da visibilidade com sucesso")
    public void oSistemaDeveEfetuarAAlteracaoDaVisibilidadeComSucesso() throws InterruptedException {

        Assert.assertEquals("Valida alteração visibilidade com sucesso", projetoPage.validaProjetoVisibilidadeEditado(), "privado");

    }


    @E("preencher a descricao do projeto {string}")
    public void preencherADescricaoDoProjeto(String descricao) throws InterruptedException {

        projetoPage.prencherDescricao(descricao);

    }

    @Entao("o sistema deve efetuar a alteracao da descricao com sucesso")
    public void oSistemaDeveEfetuarAAlteracaoDaDescricaoComSucesso() throws InterruptedException {

        Assert.assertEquals("Valida alteração visibilidade com sucesso", projetoPage.validaProjetoDescricaoEditado(), "Projeto criado e alterado com sucesso");

    }

    @E("definir a descricao do projeto {string}")
    public void definirADescricaoDoProjeto(String descricao) throws InterruptedException {
        projetoPage.editaDescricaoProjeto(descricao);
    }

    @E("clicar no botao apagar projeto")
    public void clicarNoBotaoApagarProjeto() throws InterruptedException {
        projetoPage.clicarExcluir();
        projetoPage.clicarExcluir();
    }

    @Entao("o sistema deve excluir com sucesso")
    public void oSistemaDeveExcluirComSucesso() throws InterruptedException {

        Assert.assertNotEquals("Valida alteração visibilidade com sucesso",projetoPage.validaProjetoExcluido(), "Teste projeto SQL 06");

    }

    @AfterStep
    public static void tirarScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }

}
