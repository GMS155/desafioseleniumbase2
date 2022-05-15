package pages;

import org.openqa.selenium.By;
import runner.UsuarioRun;
import support.Utils;

import java.time.Duration;
import java.util.ArrayList;

public class UsuarioPage extends UsuarioRun {

    private By menuGerenciar = By.xpath("//i[@class='fa fa-gears menu-icon']");
    private By botaoGerenciarUsuarios = By.xpath("//li/a[text()='Gerenciar Usuários']");
    private By botaoNovoUsuario = By.xpath("//a[@class='btn btn-primary btn-white btn-round btn-sm']");
    private By nomeUsuario = By.id("user-username");
    private By nomeEditado = By.id("edit-username");
    private By nomeUsuarioVerdadeiro = By.id("user-realname");
    private By editanomeUsuarioVerdadeiro = By.id("edit-realname");
    private By email = By.id("email-field");
    private By nivelAcesso = By.id("user-access-level");
    private By editaNivelAcesso = By.id("edit-access-level");
    private By habilitado = By.id("user-enabled");
    private By protegido = By.xpath("(//span[@class='lbl'])[2]");
    private By botaoAdicionarUsuario = By.xpath("//input[@class='btn btn-primary btn-white btn-round']");
    private By validarUsuarioCadastrado = By.xpath("//td/a[text()='GMS']");
    private By validarUsuarioEditado = By.xpath("//td/a[text()='Usuario1Editado']");
    private By validarUsuarioNomeVerdadeiroEditado = By.xpath("//tr/td[text()='Usuario Completo editado']");
    private By validarEmail = By.xpath("//tr/td[text()='usuarioeditado.igual@hotmail.com']");
    private By validarNivel = By.xpath("//tr/td[text()='desenvolvedor']");
    private By validarUsuarioComNumero = By.xpath("//td/a[text()='123456789']");
    private By retornoUsuarioNomeIgual = By.xpath("//p[text()='APPLICATION ERROR #800']");
    private By retornoUsuarioSemNome = By.xpath("//p[text()='APPLICATION ERROR #805']");
    private By retornoUsuarioEmailIgual = By.xpath("//p[text()='APPLICATION ERROR #813']");
    private By retornoCaractereEspecialNome = By.xpath("//p[text()='APPLICATION ERROR #805']");
    private By botaoExcluirUsuario = By.id("manage-user-delete-form");
    private By confirmaExcluirUsuario = By.xpath("//input[@class='btn btn-primary btn-white btn-round']");
    private By validarUsuarioExcluido = By.xpath("//td/a[text()='Usuario1']");


    public void clicarBotaoGerenciar() throws InterruptedException {

        getDriver().findElement(menuGerenciar).click();
    }

    public void clicarBotaoGerenciarUsuarios() throws InterruptedException {

        getDriver().findElement(botaoGerenciarUsuarios).click();
    }

    public void clicarBotaoCriarNovoUsuario() throws InterruptedException {

        //Utils.esperarElementoClicavel(botaoNovoProjeto, Duration.ofSeconds(20));
        getDriver().findElement(botaoNovoUsuario).click();
    }

    public void clicarProtegido() {

        getDriver().findElement(protegido).click();
    }

    public void clicarAdicionarUsuario() throws InterruptedException {

        //getDriver().findElement(By.xpath("(//span[@class='lbl'])[3]")).click();
        getDriver().findElement(botaoAdicionarUsuario).click();
    }

    public void clicarUsuario(String usuario) throws InterruptedException {

        getDriver().findElement(By.linkText(usuario)).click();
    }

    public void clicarExcluir() throws InterruptedException {

        getDriver().findElement(botaoExcluirUsuario).click();
        getDriver().findElement(confirmaExcluirUsuario).click();
    }

    public void preencherNomeUsuario(String nome) throws InterruptedException {

        getDriver().findElement(nomeUsuario).sendKeys(nome);
    }

    public void preencherNomeUsuarioVerdadeiro(String nomeVerdadeiro) throws InterruptedException {

        getDriver().findElement(nomeUsuarioVerdadeiro).sendKeys(nomeVerdadeiro);
    }

    public void preencherEmail(String email) throws InterruptedException {

        getDriver().findElement(this.email).sendKeys(email);
    }

    public void preencherNivelAcesso(String acesso) throws InterruptedException {

        getDriver().findElement(nivelAcesso).sendKeys(acesso);
    }

    public ArrayList<String> validaUsuarioCriado() throws InterruptedException {

        Utils.esperarElementoClicavel(botaoAdicionarUsuario, Duration.ofSeconds(25));
        getDriver().findElement(botaoGerenciarUsuarios).click();
        ArrayList<String> list = new ArrayList<>();
        Utils.esperarElementoVisivel(validarUsuarioCadastrado, Duration.ofSeconds(20));
        String usuario = String.valueOf(getDriver().findElement(validarUsuarioCadastrado).getText());
        list.add(usuario);
        String nomeVerdadeiro = String.valueOf(getDriver().findElement(By.xpath("//tr/td[text()='Teste Nome Usuario']")).getText());
        list.add(nomeVerdadeiro);
        String email = String.valueOf(getDriver().findElement(By.xpath("//tr/td[text()='Usuario@hotmail.com']")).getText());
        list.add(email);
        String nivel = String.valueOf(getDriver().findElement(By.xpath("//tr/td[text()='visualizador']")).getText());
        list.add(nivel);
        String protegido = String.valueOf(getDriver().findElement(By.xpath("(//tr/td[@class='center'])[2]")).getText());
        list.add(protegido);

        return list;
    }

    public ArrayList<String> validaUsuarioNomeComNumero() throws InterruptedException {

        Utils.esperarElementoClicavel(botaoAdicionarUsuario, Duration.ofSeconds(25));
        getDriver().findElement(botaoGerenciarUsuarios).click();
        ArrayList<String> list = new ArrayList<>();
        Utils.esperarElementoVisivel(validarUsuarioComNumero, Duration.ofSeconds(20));
        String usuario = String.valueOf(getDriver().findElement(validarUsuarioComNumero).getText());
        list.add(usuario);

        return list;
    }

    public ArrayList<String> validaUsuarioNomeEditado() throws InterruptedException {

        Utils.esperarElementoVisivel(botaoGerenciarUsuarios, Duration.ofSeconds(30));
        getDriver().findElement(botaoGerenciarUsuarios).click();
        ArrayList<String> list = new ArrayList<>();
        Utils.esperarElementoVisivel(validarUsuarioEditado, Duration.ofSeconds(40));
        String usuario = String.valueOf(getDriver().findElement(validarUsuarioEditado).getText());
        list.add(usuario);

        return list;
    }

    public ArrayList<String> validaUsuarioNomeVerdadeiroEditado() throws InterruptedException {

        Utils.esperarElementoVisivel(botaoGerenciarUsuarios, Duration.ofSeconds(30));
        getDriver().findElement(botaoGerenciarUsuarios).click();
        ArrayList<String> list = new ArrayList<>();
        Utils.esperarElementoVisivel(validarUsuarioNomeVerdadeiroEditado, Duration.ofSeconds(40));
        String nomeVerdadeiro = String.valueOf(getDriver().findElement(validarUsuarioNomeVerdadeiroEditado).getText());
        list.add(nomeVerdadeiro);

        return list;
    }

    public ArrayList<String> validaEmail() throws InterruptedException {

        Utils.esperarElementoVisivel(botaoGerenciarUsuarios, Duration.ofSeconds(30));
        getDriver().findElement(botaoGerenciarUsuarios).click();
        ArrayList<String> list = new ArrayList<>();
        Utils.esperarElementoVisivel(validarEmail, Duration.ofSeconds(40));
        String email = String.valueOf(getDriver().findElement(validarEmail).getText());
        list.add(email);

        return list;
    }

    public ArrayList<String> validaNivelAcesso() throws InterruptedException {

        Utils.esperarElementoVisivel(botaoGerenciarUsuarios, Duration.ofSeconds(30));
        getDriver().findElement(botaoGerenciarUsuarios).click();
        ArrayList<String> list = new ArrayList<>();
        Utils.esperarElementoVisivel(validarNivel, Duration.ofSeconds(40));
        String email = String.valueOf(getDriver().findElement(validarNivel).getText());
        list.add(email);

        return list;
    }

    public String validaUsuarioExcluido() throws InterruptedException {

        try {
            Utils.esperarElementoVisivel(validarUsuarioExcluido, Duration.ofSeconds(20));
            String sucesso = String.valueOf(getDriver().findElement(validarUsuarioExcluido).getText());

            return sucesso;
        } catch (Exception e) {
            String retorno = String.valueOf(e.getMessage().subSequence(0, 68));

            return retorno;
        }
    }

    public String vericaUsuarioComMesmoNome() throws InterruptedException {

        String retornoErro = getDriver().findElement(retornoUsuarioNomeIgual).getText();

        return retornoErro;
    }

    public String vericaUsuarioSemNome() throws InterruptedException {

        String retornoErro = getDriver().findElement(retornoUsuarioSemNome).getText();

        return retornoErro;
    }

    public String vericaUsuarioMesmoEmail() throws InterruptedException {

        String retornoErro = getDriver().findElement(retornoUsuarioEmailIgual).getText();

        return retornoErro;
    }

    public String vericaCaractereEspecialNome() throws InterruptedException {

        String retornoErro = getDriver().findElement(retornoCaractereEspecialNome).getText();

        return retornoErro;
    }

    public void editaNomeUsuario(String nome) throws InterruptedException {

        getDriver().findElement(nomeEditado).clear();
        getDriver().findElement(nomeEditado).sendKeys(nome);
    }

    public void editaNomeVerdadeiroUsuario(String nome) throws InterruptedException {

        getDriver().findElement(editanomeUsuarioVerdadeiro).clear();
        getDriver().findElement(editanomeUsuarioVerdadeiro).sendKeys(nome);
    }

    public void editaEmail(String email) throws InterruptedException {

        getDriver().findElement(this.email).clear();
        getDriver().findElement(this.email).sendKeys(email);
    }

    public void editaNivel(String nivel) throws InterruptedException {

        //getDriver().findElement(editaNivelAcesso).clear();
        getDriver().findElement(editaNivelAcesso).sendKeys(nivel);
    }
}
