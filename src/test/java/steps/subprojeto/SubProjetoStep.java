package steps.subprojeto;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.LoginPage;
import pages.ProjetoPage;
import pages.SubProjetoPage;
import runner.SubprojetoRun;

public class SubProjetoStep extends SubprojetoRun {

    ProjetoPage projetoPage = new ProjetoPage();
    LoginPage loginPage = new LoginPage();
    SubProjetoPage subprojeto = new SubProjetoPage();


    @Dado("que o usuário tenha feito o login com sucesso")
    public void queOUsuárioTenhaFeitoOLoginComSucesso() throws InterruptedException {


        loginPage.preendheUsuario("administrator");
        loginPage.clicarBotaoEntrar();
        loginPage.preencheSenha("root");
        loginPage.clicarBotaoEntrar();

    }

    @Quando("acessar o projeto desejado")
    public void acessarOProjetoDesejado() throws InterruptedException {

        projetoPage.clicarBotaoGerenciar();
        projetoPage.clicarBotaoGerenciarProjetos();
        projetoPage.clicarBotaoCriarNovoProjeto();
    }

    @E("clicar no botão de cadastrar subProjeto")
    public void clicarNoBotãoDeCadastrarSubProjeto() throws InterruptedException {

        subprojeto.clicarSubProjeto();

    }

    @E("preencher o nome do subprojeto {string}")
    public void preencherONomeDoSubprojeto(String nome) throws InterruptedException {

        subprojeto.preencherNomeSubProjeto(nome);
    }

    @E("definir o estado do subprojeto {}")
    public void definirOEstadoDoSubprojetoEstado(String estado) throws InterruptedException {

        subprojeto.preencheEstado(estado);
    }

    @E("marcar a opcao herdar categorias da tarefa pai")
    public void marcarAOpcaoHerdarCategoriasDaTarefaPai() {

        subprojeto.clicarHerdarCategoriasTarefas();
    }

    @E("marcar a opcao herdar categorias globais")
    public void marcarAOpcaoHerdarCategoriasGlobais() {

        subprojeto.clicarHerdarCategorias();
    }

    @E("selecionar a visibilidade do projeto")
    public void selecionarAVisibilidadeDoProjeto() throws InterruptedException {
        subprojeto.selecionaVisibilidade("público");
    }

    @E("preencher a descricao do subprojeto {string}")
    public void preencherADescricaoDoSubprojeto(String descricao) throws InterruptedException {

        subprojeto.prencherDescricao(descricao);

    }

    @E("clicar no botão de salvar subprojeto")
    public void clicarNoBotãoDeSalvarSubprojeto() throws InterruptedException {

        subprojeto.clicarBotaoConfirmaSubProjeto();

    }

    @Então("o sistema deve efetuar o cadastro do subprojeto com sucesso")
    public void oSistemaDeveEfetuarOCadastroDoSubprojetoComSucesso() throws InterruptedException {

        Assert.assertEquals("Valida cadastro subprojeto com sucesso", subprojeto.validaSubProjetoCriado(), "» Subprojeto 02");


    }

    @Então("o sistema deve efetuar o cadastro do subprojeto editado com sucesso")
    public void oSistemaDeveEfetuarOCadastroDoSubprojetoEditadoComSucesso() throws InterruptedException {

        Assert.assertEquals("Valida cadastro projeto com sucesso", projetoPage.validaProjetoNomeEditado(), "» Subprojeto 02 editado");
    }

    @E("clicar no projeto desejado {string}")
    public void clicarNoProjetoDesejado(String nome) throws InterruptedException {

        projetoPage.clicarBotaoGerenciar();
        projetoPage.clicarBotaoGerenciarProjetos();
        projetoPage.clicarProjeto(nome);
    }

    @E("clicar no projeto desejado {string} novamente")
    public void clicarNoProjetoDesejadoNovamente(String projeto) throws InterruptedException {

        projetoPage.clicarProjetoNovamente(projeto);
    }

    @Então("o sistema deve emitir uma mensagem de erro")
    public void oSistemaDeveEmitirUmaMensagemDeErro() throws InterruptedException {

        Assert.assertEquals("Valida mensagem Erro nome igual", projetoPage.vericaProjetoComMesmoNome(), "APPLICATION ERROR #701");

    }

    @Então("o sistema deve permanecer na mesma tela de cadastro")
    public void oSistemaDevePermanecerNaMesmaTelaDeCadastro() throws InterruptedException {

        subprojeto.verificaTelaAdicionaSubProjeto();
    }

    @Então("o sistema deve efetuar o cadastro do subprojeto com número com sucesso")
    public void oSistemaDeveEfetuarOCadastroDoSubprojetoComNúmeroComSucesso() throws InterruptedException {
        Assert.assertEquals("Valida cadastro subprojeto com sucesso", subprojeto.validaSubProjetoCriadoComNumero(), "» 123456789");


    }

    @Então("o sistema deve efetuar o cadastro do subprojeto com caracter especial com sucesso")
    public void oSistemaDeveEfetuarOCadastroDoSubprojetoComCaracterEspecialComSucesso() throws InterruptedException {
        Assert.assertEquals("Valida cadastro subprojeto com sucesso", subprojeto.validaSubProjetoCriadoComCaracterEspecial(), "» #$#$%#%&*(!!_>");

    }

    @E("clicar no subprojeto desejado {string} novamente")
    public void clicarNoSubprojetoDesejadoNovamente(String subprojeto) throws InterruptedException {

        projetoPage.clicarSubProjetoNovamente(subprojeto);

    }

    @Então("o sistema deve realizar o cadastro do subprojeto com estado editado com sucesso")
    public void oSistemaDeveRealizarOCadastroDoSubprojetoComEstadoEditadoComSucesso() {


    }

    @Então("o sistema deve realizar o cadastro do subprojeto com {} com sucesso")
    public void oSistemaDeveRealizarOCadastroDoSubprojetoComEstadoEditadoComSucesso(String estado) throws InterruptedException {

        Assert.assertEquals("Valida edição estado com sucesso", projetoPage.validaEstadoEditado(estado), estado);

    }

    @E("clicar no campo habilitado")
    public void clicarNoCampoHabilitado() throws InterruptedException {
        projetoPage.clicarhabilitado();
    }

    @Então("o sistema deve efetuar a alteração do habilitado com sucesso")
    public void oSistemaDeveEfetuarAAlteraçãoDoHabilitadoComSucesso() throws InterruptedException {

        Assert.assertNotEquals("Valida alteração habilitado com sucesso", projetoPage.validaProjetoHabilitadoEditadoDesmarcado(), "");

    }

    @E("selecionar a visibilidade do projeto novamente")
    public void selecionarAVisibilidadeDoProjetoNovamente() throws InterruptedException {
        subprojeto.selecionaVisibilidade("privado");

    }

    @Então("o sistema deve efetuar a alteração da visiblidade com sucesso")
    public void oSistemaDeveEfetuarAAlteraçãoDaVisiblidadeComSucesso() throws InterruptedException {

        Assert.assertEquals("Valida alteração visibilidade com sucesso", projetoPage.validaProjetoVisibilidadeEditado(), "privado");

    }

    @E("preencher a descricao do subprojeto {string} novamente")
    public void preencherADescricaoDoSubprojetoNovamente(String descricao) throws InterruptedException {

        projetoPage.editaDescricaoProjeto(descricao);
    }

    @Então("o sistema deve efetuar a alteração da descrição com sucesso")
    public void oSistemaDeveEfetuarAAlteraçãoDaDescriçãoComSucesso() throws InterruptedException {

        Assert.assertEquals("Valida alteração descrição com sucesso", subprojeto.validaSubProjetoDescricaoEditado(), "SubProjeto criado como teste editado");

    }

    @E("clicar no botão apagar projeto")
    public void clicarNoBotãoApagarProjeto() throws InterruptedException {
        subprojeto.clicarExcluir();
        subprojeto.clicarExcluir();
    }

    @Então("o sistema deve excluir com sucesso")
    public void oSistemaDeveExcluirComSucesso() throws InterruptedException {

        Assert.assertNotEquals("Valida exclusão com sucesso",subprojeto.validaSubProjetoExcluido(), "Subprojeto 02");

    }
/*
    @E("que tenha um projeto cadastrado")
    public void queTenhaUmProjetoCadastrado() throws InterruptedException {

        projetoPage.clicarBotaoGerenciar();
        projetoPage.clicarBotaoGerenciarProjetos();
        projetoPage.clicarBotaoCriarNovoProjeto();
        projetoPage.preencherNomeProjeto("Projeto01");
        projetoPage.selecionaEstado("estável");
        projetoPage.clicarHerdarCategorias();
        projetoPage.selecionaVisibilidade("público");
        projetoPage.prencherDescricao("Projeto criado como teste");
        projetoPage.clicarBotaoAdicionarProjeto();


    }

 */


}
