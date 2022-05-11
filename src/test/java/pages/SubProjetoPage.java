package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import runner.SubprojetoRun;
import support.Utils;

import java.time.Duration;

public class SubProjetoPage extends SubprojetoRun {


    private By nomeSubProjeto = By.id("project-name");
    private By estadoSubProjeto = By.id("project-status");
    private By descricaoSubProjeto = By.id("project-description");
    private By herdarCategoriasGlobais = By.xpath("(//span[@class='lbl'])[1]");
    private By herdarCategoriasTarefasPai = By.xpath("(//span[@class='lbl'])[2]");
    private By visibilidadeSubProjeto = By.id("project-view-state");
    private By botaoConfirmaAdicionarSubProjeto = By.xpath("//input[@class='btn btn-primary btn-white btn-round']");
    private By botaoAdicionarSubProjeto = By.xpath("//button[@class='btn btn-sm btn-primary btn-white btn-round']");
    private By validarSubProjetoCadastrado = By.xpath("//a[text()='» Subprojeto 02']");
    private By validarSubProjetoCadastradoComNumero = By.xpath("//a[text()='» 123456789']");
    private By validarSubProjetoCadastradoComCaracterEspecial = By.xpath("//a[text()='» #$#$%#%&*(!!_>']");
    private By retornoSubProjetoNomeIgual = By.xpath("//p[text()='APPLICATION ERROR #701']");
    private By validarSubProjetoNomeEditado = By.xpath("//td/a[text()='» Subprojeto 02 editado']");
    private By descricaoEditado = By.xpath("//td[text()='SubProjeto criado como teste editado']");
    private By botaoExcluirSubProjeto = By.xpath("//input[@value='Apagar Projeto']");
    private By validarSubProjetoExcluido = By.xpath("//td/a[text()='Subprojeto 02']");


    public void clicarSubProjeto() throws InterruptedException {

        getDriver().findElement(botaoAdicionarSubProjeto).click();
    }

    public void clicarExcluir() throws InterruptedException {

        getDriver().findElement(botaoExcluirSubProjeto).click();
    }

    public void clicarHerdarCategorias() {

        getDriver().findElement(herdarCategoriasGlobais).click();
    }

    public void clicarHerdarCategoriasTarefas() {

        getDriver().findElement(herdarCategoriasTarefasPai).click();
    }

    public void clicarBotaoConfirmaSubProjeto() throws InterruptedException {

        getDriver().findElement(botaoConfirmaAdicionarSubProjeto).click();
    }

    public void preencherNomeSubProjeto(String nome) throws InterruptedException {

        getDriver().findElement(nomeSubProjeto).clear();
        getDriver().findElement(nomeSubProjeto).sendKeys(nome);
    }

    public void preencheEstado(String estado) throws InterruptedException {

        getDriver().findElement(estadoSubProjeto).sendKeys(estado);
    }

    public void selecionaVisibilidade(String visibilidade) throws InterruptedException {

        getDriver().findElement(visibilidadeSubProjeto).sendKeys(visibilidade);
    }

    public void prencherDescricao(String descricao) throws InterruptedException {

        getDriver().findElement(descricaoSubProjeto).sendKeys(descricao);
    }

    public String validaSubProjetoCriado() throws InterruptedException {

        Utils.esperarElementoVisivel(validarSubProjetoCadastrado, Duration.ofSeconds(20));
        String sucesso = String.valueOf(getDriver().findElement(validarSubProjetoCadastrado).getText());

        return sucesso;
    }

    public String validaSubProjetoCriadoComNumero() throws InterruptedException {

        Utils.esperarElementoVisivel(validarSubProjetoCadastradoComNumero, Duration.ofSeconds(20));
        String sucesso = String.valueOf(getDriver().findElement(validarSubProjetoCadastradoComNumero).getText());

        return sucesso;
    }

    public String validaSubProjetoCriadoComCaracterEspecial() throws InterruptedException {

        Utils.esperarElementoVisivel(validarSubProjetoCadastradoComCaracterEspecial, Duration.ofSeconds(20));
        String sucesso = String.valueOf(getDriver().findElement(validarSubProjetoCadastradoComCaracterEspecial).getText());

        return sucesso;
    }

    public String vericaProjetoComMesmoNome() throws InterruptedException {

        String retornoErro = getDriver().findElement(retornoSubProjetoNomeIgual).getText();
        return retornoErro;
    }

    public void verificaTelaAdicionaSubProjeto() throws InterruptedException {

        Boolean visible = getDriver().findElement(By.xpath("//h4[@class='widget-title lighter']")).isDisplayed();
        Assert.assertEquals(true, visible);
    }

    public String validaSubProjetoNomeEditado() throws InterruptedException {

        Utils.esperarElementoVisivel(validarSubProjetoNomeEditado, Duration.ofSeconds(20));
        String sucesso = String.valueOf(getDriver().findElement(validarSubProjetoNomeEditado).getText());

        return sucesso;
    }

    public String validaSubProjetoDescricaoEditado() throws InterruptedException {

        Utils.esperarElementoVisivel(descricaoEditado, Duration.ofSeconds(20));
        String sucesso = String.valueOf(getDriver().findElement(descricaoEditado).getText());

        return sucesso;
    }

    public String validaSubProjetoExcluido() throws InterruptedException {

        try {
            Utils.esperarElementoVisivel(validarSubProjetoExcluido, Duration.ofSeconds(20));
            String sucesso = String.valueOf(getDriver().findElement(validarSubProjetoExcluido).getText());

            return sucesso;
        } catch (Exception e) {
            String retorno = String.valueOf(e.getMessage().subSequence(0, 68));

            return retorno;
        }
    }
}
