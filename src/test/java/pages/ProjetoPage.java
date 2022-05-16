package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import runner.ProjetoRun;
import support.Utils;

import java.time.Duration;
import java.util.ArrayList;

public class ProjetoPage extends ProjetoRun {


    private By menuGerenciar = By.xpath("//i[@class='fa fa-gears menu-icon']");
    private By botaoGerenciarProjetos = By.xpath("//a[contains(text(),'Gerenciar Projetos')]");
    private By botaoNovoProjeto = By.xpath("//button[@class='btn btn-primary btn-white btn-round']");
    private By botaoAdicionarProjeto = By.xpath("//input[@class='btn btn-primary btn-white btn-round']");
    private By botaoExcluirProjeto = By.xpath("//input[@value='Apagar Projeto']");
    private By nomeProjeto = By.id("project-name");
    private By estadoProjeto = By.id("project-status");
    private By habilitado = By.id("project-enabled");
    private By herdarCategorias = By.xpath("//span[@class='lbl']");
    private By visibilidadeProjeto = By.id("project-view-state");
    private By descricaoProjeto = By.id("project-description");
    private By validarProjetoCadastrado = By.xpath("//td/a[text()='Projeto01']");
    private By validarProjetoComCaracterEspecial = By.xpath("//td/a[text()='*&!##@@=']");
    private By validarProjetoComNumero = By.xpath("//td/a[text()='8989448489846546']");
    private By validarProjetoExcluido = By.xpath("//td/a[text()='Teste projeto SQL 06']");
    private By validarProjetoNomeEditado = By.xpath("//td/a[text()='» Subprojeto 02 editado']");
    private By validarSubProjetoNomeEditado = By.xpath("//td/a[text()='Teste projeto SQL 01_Editado']");
    private By retornoProjetoNomeIgual = By.xpath("//p[text()='APPLICATION ERROR #701']");
    private By habilitadoEditado = By.xpath("//i[@class=\"fa fa-check fa-lg\"]");
    private By habilitadoEditadoDesmarcado = By.xpath("(//i[@class=\"fa fa-check fa-lg\"])[3]");
    private By visibilidadeEditado = By.xpath("//tr/td[text()='privado']");
    private By descricaoEditado = By.xpath("//td[text()='Projeto criado e alterado com sucesso']");
    private By esperaProjetoVisivel = By.xpath("//td/a[text()='Teste projeto SQL 02']");



    public void clicarBotaoGerenciar() throws InterruptedException {

        getDriver().findElement(menuGerenciar).click();
    }

    public void clicarBotaoGerenciarProjetos() throws InterruptedException {

        //utils = new Utils(driver);
        //utils.esperarElementoClicavel(botaoAdicionarProjeto,Duration.ofSeconds(20));
        getDriver().findElement(botaoGerenciarProjetos).click();
    }

    public void clicarBotaoCriarNovoProjeto() throws InterruptedException {

        Utils.esperarElementoClicavel(botaoNovoProjeto, Duration.ofSeconds(20));
        getDriver().findElement(botaoNovoProjeto).click();
    }

    public void clicarBotaoAdicionarProjeto() throws InterruptedException {

        getDriver().findElement(botaoAdicionarProjeto).click();
    }

    public void clicarExcluir() throws InterruptedException {

        getDriver().findElement(botaoExcluirProjeto).click();
    }

    public void clicarProjeto(String nome) throws InterruptedException {

        getDriver().findElement(By.linkText(nome)).click();
    }

    public void clicarProjetoNovamente(String nome) throws InterruptedException {

        Utils.esperarElementoClicavel(esperaProjetoVisivel, Duration.ofSeconds(20));
        getDriver().findElement(esperaProjetoVisivel).click();
    }



    public void clicarhabilitado() throws InterruptedException {

        getDriver().findElement(habilitado).click();
    }

    public void clicarHerdarCategorias() {

        getDriver().findElement(herdarCategorias).click();
    }

    public void preencherNomeProjeto(String nome) throws InterruptedException {

        getDriver().findElement(nomeProjeto).sendKeys(nome);
    }

    public void editaNomeProjeto(String nome) throws InterruptedException {

        getDriver().findElement(nomeProjeto).clear();
        getDriver().findElement(nomeProjeto).sendKeys(nome);
    }

    public void editaDescricaoProjeto(String descricao) throws InterruptedException {

        getDriver().findElement(descricaoProjeto).clear();
        getDriver().findElement(descricaoProjeto).sendKeys(descricao);
    }

    public void selecionaEstado(String estado) throws InterruptedException {

        getDriver().findElement(estadoProjeto).sendKeys(estado);
    }

    public void editaEstado(String estado) throws InterruptedException {

        getDriver().findElement(estadoProjeto).sendKeys(estado);
    }

    public void selecionaVisibilidade(String visibilidade) throws InterruptedException {

        getDriver().findElement(visibilidadeProjeto).sendKeys(visibilidade);
    }

    public void prencherDescricao(String descricao) throws InterruptedException {

        getDriver().findElement(descricaoProjeto).sendKeys(descricao);
    }

    public ArrayList<String> validaProjetoCriado() throws InterruptedException {

        ArrayList<String> list = new ArrayList<>();
        Utils.esperarElementoVisivel(validarProjetoCadastrado, Duration.ofSeconds(20));
        String sucesso = String.valueOf(getDriver().findElement(validarProjetoCadastrado).getText());
        list.add(sucesso);
        String estado = String.valueOf(getDriver().findElement(By.xpath("//tr/td[text()='obsoleto']")).getText());
        list.add(estado);
        String habilitado = String.valueOf(getDriver().findElement(habilitadoEditado).getText());
        list.add(habilitado);
        String visibilidade = String.valueOf(getDriver().findElement(By.xpath("//tr/td[text()='privado']")).getText());
        list.add(visibilidade);
        String descricao = String.valueOf(getDriver().findElement(By.xpath("//tr/td[text()='Projeto criado como teste']")).getText());
        list.add(descricao);

        return list;
    }

    public ArrayList<String> validaProjetoCriadoComCaractereEspecial() throws InterruptedException {

        ArrayList<String> list = new ArrayList<>();
        Utils.esperarElementoVisivel(validarProjetoComCaracterEspecial, Duration.ofSeconds(20));
        String sucesso = String.valueOf(getDriver().findElement(validarProjetoComCaracterEspecial).getText());
        list.add(sucesso);

        return list;
    }

    public ArrayList<String> validaProjetoCriadoComNumero() throws InterruptedException {

        ArrayList<String> list = new ArrayList<>();
        Utils.esperarElementoVisivel(validarProjetoComNumero, Duration.ofSeconds(20));
        String sucesso = String.valueOf(getDriver().findElement(validarProjetoComNumero).getText());
        list.add(sucesso);

        return list;
    }

    public String validaProjetoExcluido() throws InterruptedException {

        try {
            Utils.esperarElementoVisivel(validarProjetoExcluido, Duration.ofSeconds(20));
            String sucesso = String.valueOf(getDriver().findElement(validarProjetoExcluido).getText());
            return sucesso;
        } catch (Exception e) {
            String retorno = String.valueOf(e.getMessage().subSequence(0, 68));
            return retorno;
        }
    }

    public String validaEstadoEditado(String estado) throws InterruptedException {

        Utils.esperarElementoVisivel(By.xpath("//td[text()='" + estado + "']"), Duration.ofSeconds(20));
        String sucesso = String.valueOf(getDriver().findElement(By.xpath("//td[text()='" + estado + "']")).getText());

        return sucesso;
    }

    public String validaProjetoNomeEditado() throws InterruptedException {

        Utils.esperarElementoVisivel(validarSubProjetoNomeEditado, Duration.ofSeconds(20));
        String sucesso = String.valueOf(getDriver().findElement(validarSubProjetoNomeEditado).getText());
        return sucesso;
    }

    public String validaProjetoHabilitadoEditado() throws InterruptedException {

        Utils.esperarElementoVisivel(habilitadoEditado, Duration.ofSeconds(20));
        String sucesso = String.valueOf(getDriver().findElement(habilitadoEditado).getText());

        return sucesso;
    }

    public String validaProjetoHabilitadoEditadoDesmarcado() throws InterruptedException {

        try {
            Utils.esperarElementoVisivel(habilitadoEditadoDesmarcado, Duration.ofSeconds(20));
            String sucesso = String.valueOf(getDriver().findElement(habilitadoEditadoDesmarcado).getText());
            return sucesso;
        } catch (Exception e) {
            String retorno = String.valueOf(e.getMessage().subSequence(0, 68));
            return retorno;
        }
    }

    public String validaProjetoVisibilidadeEditado() throws InterruptedException {

        Utils.esperarElementoVisivel(visibilidadeEditado, Duration.ofSeconds(20));
        String sucesso = String.valueOf(getDriver().findElement(visibilidadeEditado).getText());

        return sucesso;
    }

    public String validaProjetoDescricaoEditado() throws InterruptedException {

        Utils.esperarElementoVisivel(descricaoEditado, Duration.ofSeconds(20));
        String sucesso = String.valueOf(getDriver().findElement(descricaoEditado).getText());

        return sucesso;
    }

    public void verificaTelaAdicionaProjeto() throws InterruptedException {

        Boolean visible = getDriver().findElement(By.xpath("//h4[@class='widget-title lighter']")).isDisplayed();
        Assert.assertEquals(true, visible);
    }

    public String vericaProjetoComMesmoNome() throws InterruptedException {

        String retornoErro = getDriver().findElement(retornoProjetoNomeIgual).getText();

        return retornoErro;
    }
}
