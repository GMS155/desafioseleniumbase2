package steps.usuario;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.LoginPage;
import pages.UsuarioPage;
import support.Utils;

import java.time.Duration;
import java.util.ArrayList;

public class UsuarioStep {

    LoginPage loginPage = new LoginPage();
    UsuarioPage usuarioPage = new UsuarioPage();

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

    @Quando("acessar a tela de criação de usuário")
    public void acessarATelaDeCriaçãoDeUsuário() throws InterruptedException {

        usuarioPage.clicarBotaoGerenciar();
        usuarioPage.clicarBotaoGerenciarUsuarios();
        usuarioPage.clicarBotaoCriarNovoUsuario();
    }


    @E("preencher o nome de usuário {string}")
    public void preencherONomeDeUsuário(String nome) throws InterruptedException {

        usuarioPage.preencherNomeUsuario(nome);
    }

    @E("preencher o nome verdadeiro do usuário {string}")
    public void preencherONomeVerdadeiroDoUsuário(String nomeVerdadeiro) throws InterruptedException {

        usuarioPage.preencherNomeUsuarioVerdadeiro(nomeVerdadeiro);
    }

    @E("preencher o email {string}")
    public void preencherOEmail(String email) throws InterruptedException {

        usuarioPage.preencherEmail(email);
    }


    @E("preencher o nível de acesso")
    public void preencherONívelDeAcesso() throws InterruptedException {

        usuarioPage.preencherNivelAcesso("visualizador");
    }

    @E("selecionar a opção protegido")
    public void selecionarAOpçãoProtegido() {

        usuarioPage.clicarProtegido();
    }

    @E("clicar no botão de criar usuário")
    public void clicarNoBotãoDeCriarUsuário() throws InterruptedException {

        usuarioPage.clicarAdicionarUsuario();
    }

    @Então("o sistema deve efetuar o cadastro com sucesso")
    public void oSistemaDeveEfetuarOCadastroComSucesso() throws InterruptedException {


        ArrayList<String> list = usuarioPage.validaUsuarioCriado();

        Assert.assertEquals("Valida cadastro nome usuário com sucesso", list.get(0), "GMS");
        Assert.assertEquals("Valida cadastro nome verdadeiro usuário com sucesso", list.get(1), "Teste Nome Usuário");
        Assert.assertEquals("Valida cadastro email usuário com sucesso", list.get(2), "Usuario@hotmail.com");
        Assert.assertEquals("Valida cadastro nível de acesso com sucesso", list.get(3), "visualizador");
        Assert.assertEquals("Valida cadastro protegido com sucesso", list.get(4), " ");


    }

    @Então("o sistema deve emitir uma mensagem de erro")
    public void oSistemaDeveEmitirUmaMensagemDeErro() throws InterruptedException {

        Assert.assertEquals("Valida mensagem Erro nome igual", usuarioPage.vericaUsuarioComMesmoNome(), "APPLICATION ERROR #800");

    }


    @Então("o sistema deve emitir uma mensagem de erro do usuário sem nome")
    public void oSistemaDeveEmitirUmaMensagemDeErroDoUsuárioSemNome() throws InterruptedException {

        Assert.assertEquals("Valida mensagem Erro sem nome", usuarioPage.vericaUsuarioSemNome(), "APPLICATION ERROR #805");

    }

    @Então("o sistema deve emitir uma mensagem de erro do email igual")
    public void oSistemaDeveEmitirUmaMensagemDeErroDoEmailIgual() throws InterruptedException {

        Assert.assertEquals("Valida mensagem Erro email igual", usuarioPage.vericaUsuarioMesmoEmail(), "APPLICATION ERROR #813");


    }

    @Então("o sistema deve emitir uma mensagem de erro do caractere especial")
    public void oSistemaDeveEmitirUmaMensagemDeErroDoCaractereEspecial() throws InterruptedException {

        Assert.assertEquals("Valida mensagem Erro sem nome", usuarioPage.vericaCaractereEspecialNome(), "APPLICATION ERROR #805");

    }


    @Então("o sistema deve efetuar o cadastro com número com sucesso")
    public void oSistemaDeveEfetuarOCadastroComNúmeroComSucesso() throws InterruptedException {

        ArrayList<String> list = usuarioPage.validaUsuarioNomeComNumero();
        Assert.assertEquals("Valida cadastro com caractere especial com sucesso", list.get(0), "123456789");

    }

    @E("clicar no campo usuário {string}")
    public void clicarNoCampoUsuário(String usuario) throws InterruptedException {

        usuarioPage.clicarUsuario(usuario);
    }

    @E("clicar no botão de atualizar usuário")
    public void clicarNoBotãoDeAtualizarUsuário() throws InterruptedException {

        usuarioPage.clicarAdicionarUsuario();


    }

    @Então("o sistema deve editar o nome com sucesso")
    public void oSistemaDeveEditarONomeComSucesso() throws InterruptedException {

        ArrayList<String> list = usuarioPage.validaUsuarioNomeEditado();
        Assert.assertEquals("Valida edição nome com sucesso", list.get(0), "Usuario1Editado");


    }

    @Quando("acessar a tela dos usuários cadastrados")
    public void acessarATelaDosUsuáriosCadastrados() throws InterruptedException {

        usuarioPage.clicarBotaoGerenciar();
        usuarioPage.clicarBotaoGerenciarUsuarios();
    }

    @E("editar o nome de usuário {string}")
    public void editarONomeDeUsuário(String nome) throws InterruptedException {

        usuarioPage.editaNomeUsuario(nome);
    }

    @E("editar o nome verdadeiro {string}")
    public void editarONomeVerdadeiro(String nome) throws InterruptedException {

        usuarioPage.editaNomeVerdadeiroUsuario(nome);
    }

    @Então("o sistema deve editar o nome verdadeiro com sucesso")
    public void oSistemaDeveEditarONomeVerdadeiroComSucesso() throws InterruptedException {

        ArrayList<String> list = usuarioPage.validaUsuarioNomeVerdadeiroEditado();
        Assert.assertEquals("Valida edição nome verdadeiro com sucesso", list.get(0), "Usuario Completo editado");

    }

    @E("editar o email {string}")
    public void editarOEmail(String email) throws InterruptedException {

        usuarioPage.editaEmail(email);
    }

    @Então("o sistema deve editar o email com sucesso")
    public void oSistemaDeveEditarOEmailComSucesso() throws InterruptedException {

        ArrayList<String> list = usuarioPage.validaEmail();
        Assert.assertEquals("Valida edição nome verdadeiro com sucesso", list.get(0), "usuarioeditado.igual@hotmail.com");
    }

    @Então("o sistema deve emitir uma mensagem de erro do nome vazio")
    public void oSistemaDeveEmitirUmaMensagemDeErroDoNomeVazio() throws InterruptedException {

        Assert.assertEquals("Valida edição nome em branco", usuarioPage.vericaUsuarioComMesmoNome(), "APPLICATION ERROR #800");
    }

    @E("editar o nível de acesso {string}")
    public void editarONívelDeAcesso(String nivel) throws InterruptedException {

        usuarioPage.editaNivel(nivel);
    }

    @Então("o sistema deve editar o nível com sucesso")
    public void oSistemaDeveEditarONívelComSucesso() throws InterruptedException {

        ArrayList<String> list = usuarioPage.validaNivelAcesso();
        Assert.assertEquals("Valida edição nível com sucesso", list.get(0), "desenvolvedor");

    }

    @E("clicar no botão apagar usuário")
    public void clicarNoBotãoApagarUsuário() throws InterruptedException {

        usuarioPage.clicarExcluir();
    }

    @Então("o sistema deve excluir com sucesso")
    public void oSistemaDeveExcluirComSucesso() throws InterruptedException {

        Assert.assertNotEquals("Valida exclusão do usuário", usuarioPage.validaUsuarioExcluido(), "Usuario1");
    }
}
