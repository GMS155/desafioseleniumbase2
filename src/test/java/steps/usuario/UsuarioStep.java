package steps.usuario;

import io.cucumber.java.pt.*;
import org.junit.Assert;
import pages.LoginPage;
import pages.UsuarioPage;
import support.Utils;

import java.time.Duration;
import java.util.ArrayList;

public class UsuarioStep {

    LoginPage loginPage = new LoginPage();
    UsuarioPage usuarioPage = new UsuarioPage();

    @Dado("que o usuario esteja na pagina de login do Mantis")
    public void queOUsuarioEstejaNaPaginaDeLoginDoMantis() throws InterruptedException {

        loginPage.acessarAplicacao();
    }

    @Dado("que o usuario tenha feito o login com sucesso")
    public void queOUsuarioTenhaFeitoOLoginComSucesso() throws InterruptedException {

        loginPage.preendheUsuario("administrator");
        loginPage.clicarBotaoEntrar();
        loginPage.preencheSenha("root");
        loginPage.clicarBotaoEntrar();
    }

    @Quando("acessar a tela de criacao de usuario")
    public void acessarATelaDeCriacaoDeUsuario() throws InterruptedException {

        usuarioPage.clicarBotaoGerenciar();
        usuarioPage.clicarBotaoGerenciarUsuarios();
        usuarioPage.clicarBotaoCriarNovoUsuario();
    }

    @E("preencher o nome de usuario {string}")
    public void preencherONomeDeUsuario(String nome) throws InterruptedException {

        usuarioPage.preencherNomeUsuario(nome);
    }

    @E("preencher o nome verdadeiro do usuario {string}")
    public void preencherONomeVerdadeiroDoUsuario(String nomeVerdadeiro) throws InterruptedException {

        usuarioPage.preencherNomeUsuarioVerdadeiro(nomeVerdadeiro);
    }

    @E("preencher o email {string}")
    public void preencherOEmail(String email) throws InterruptedException {

        usuarioPage.preencherEmail(email);
    }

    @E("preencher o nivel de acesso")
    public void preencherONivelDeAcesso() throws InterruptedException {

        usuarioPage.preencherNivelAcesso("visualizador");
    }

    @E("selecionar a opcao protegido")
    public void selecionarAOpcaoProtegido() {

        usuarioPage.clicarProtegido();
    }

    @E("clicar no botao de criar usuario")
    public void clicarNoBotaoDeCriarUsuario() throws InterruptedException {

        usuarioPage.clicarAdicionarUsuario();
    }

    @Entao("o sistema deve efetuar o cadastro com sucesso")
    public void oSistemaDeveEfetuarOCadastroComSucesso() throws InterruptedException {

        ArrayList<String> list = usuarioPage.validaUsuarioCriado();
        Assert.assertEquals("Valida cadastro nome usuário com sucesso", list.get(0), "GMS");
        Assert.assertEquals("Valida cadastro nome verdadeiro usuário com sucesso", list.get(1), "Teste Nome Usuario");
        Assert.assertEquals("Valida cadastro email usuário com sucesso", list.get(2), "Usuario@hotmail.com");
        Assert.assertEquals("Valida cadastro nível de acesso com sucesso", list.get(3), "visualizador");
        Assert.assertEquals("Valida cadastro protegido com sucesso", list.get(4), " ");
    }

    @Entao("o sistema deve emitir uma mensagem de erro")
    public void oSistemaDeveEmitirUmaMensagemDeErro() throws InterruptedException {

        Assert.assertEquals("Valida mensagem Erro nome igual", usuarioPage.vericaUsuarioComMesmoNome(), "APPLICATION ERROR #800");
    }

    @Entao("o sistema deve emitir uma mensagem de erro do usuario sem nome")
    public void oSistemaDeveEmitirUmaMensagemDeErroDoUsuarioSemNome() throws InterruptedException {

        Assert.assertEquals("Valida mensagem Erro sem nome", usuarioPage.vericaUsuarioSemNome(), "APPLICATION ERROR #805");
    }

    @Entao("o sistema deve emitir uma mensagem de erro do email igual")
    public void oSistemaDeveEmitirUmaMensagemDeErroDoEmailIgual() throws InterruptedException {

        Assert.assertEquals("Valida mensagem Erro email igual", usuarioPage.vericaUsuarioMesmoEmail(), "APPLICATION ERROR #813");
    }

    @Entao("o sistema deve emitir uma mensagem de erro do caractere especial")
    public void oSistemaDeveEmitirUmaMensagemDeErroDoCaractereEspecial() throws InterruptedException {

        Assert.assertEquals("Valida mensagem Erro sem nome", usuarioPage.vericaCaractereEspecialNome(), "APPLICATION ERROR #805");
    }

    @Entao("o sistema deve efetuar o cadastro com numero com sucesso")
    public void oSistemaDeveEfetuarOCadastroComNumeroComSucesso() throws InterruptedException {

        ArrayList<String> list = usuarioPage.validaUsuarioNomeComNumero();
        Assert.assertEquals("Valida cadastro com caractere especial com sucesso", list.get(0), "123456789");
    }

    @E("clicar no campo usuario {string}")
    public void clicarNoCampoUsuario(String usuario) throws InterruptedException {

        usuarioPage.clicarUsuario(usuario);
    }

    @E("clicar no botao de atualizar usuario")
    public void clicarNoBotaoDeAtualizarUsuario() throws InterruptedException {

        usuarioPage.clicarAdicionarUsuario();
    }

    @Entao("o sistema deve editar o nome com sucesso")
    public void oSistemaDeveEditarONomeComSucesso() throws InterruptedException {

        ArrayList<String> list = usuarioPage.validaUsuarioNomeEditado();
        Assert.assertEquals("Valida edição nome com sucesso", list.get(0), "Usuario1Editado");
    }

    @Quando("acessar a tela dos usuarios cadastrados")
    public void acessarATelaDosUsuariosCadastrados() throws InterruptedException {

        usuarioPage.clicarBotaoGerenciar();
        usuarioPage.clicarBotaoGerenciarUsuarios();
    }

    @E("editar o nome de usuario {string}")
    public void editarONomeDeUsuario(String nome) throws InterruptedException {

        usuarioPage.editaNomeUsuario(nome);
    }

    @E("editar o nome verdadeiro {string}")
    public void editarONomeVerdadeiro(String nome) throws InterruptedException {

        usuarioPage.editaNomeVerdadeiroUsuario(nome);
    }

    @Entao("o sistema deve editar o nome verdadeiro com sucesso")
    public void oSistemaDeveEditarONomeVerdadeiroComSucesso() throws InterruptedException {

        ArrayList<String> list = usuarioPage.validaUsuarioNomeVerdadeiroEditado();
        Assert.assertEquals("Valida edição nome verdadeiro com sucesso", list.get(0), "Usuario Completo editado");
    }

    @E("editar o email {string}")
    public void editarOEmail(String email) throws InterruptedException {

        usuarioPage.editaEmail(email);
    }

    @Entao("o sistema deve editar o email com sucesso")
    public void oSistemaDeveEditarOEmailComSucesso() throws InterruptedException {

        ArrayList<String> list = usuarioPage.validaEmail();
        Assert.assertEquals("Valida edição nome verdadeiro com sucesso", list.get(0), "usuarioeditado.igual@hotmail.com");
    }

    @Entao("o sistema deve emitir uma mensagem de erro do nome vazio")
    public void oSistemaDeveEmitirUmaMensagemDeErroDoNomeVazio() throws InterruptedException {

        Assert.assertEquals("Valida edição nome em branco", usuarioPage.vericaUsuarioComMesmoNome(), "APPLICATION ERROR #800");
    }

    @E("editar o nivel de acesso {string}")
    public void editarONivelDeAcesso(String nivel) throws InterruptedException {

        usuarioPage.editaNivel(nivel);
    }

    @Entao("o sistema deve editar o nível com sucesso")
    public void oSistemaDeveEditarONívelComSucesso() throws InterruptedException {

        ArrayList<String> list = usuarioPage.validaNivelAcesso();
        Assert.assertEquals("Valida edição nível com sucesso", list.get(0), "desenvolvedor");
    }

    @E("clicar no botao apagar usuario")
    public void clicarNoBotaoApagarUsuario() throws InterruptedException {

        usuarioPage.clicarExcluir();
    }

    @Entao("o sistema deve excluir com sucesso")
    public void oSistemaDeveExcluirComSucesso() throws InterruptedException {

        Assert.assertNotEquals("Valida exclusão do usuário", usuarioPage.validaUsuarioExcluido(), "Usuario1");
    }
}
