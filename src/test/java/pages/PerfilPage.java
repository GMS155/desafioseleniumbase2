package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import runner.PerfilRun;
import support.Utils;

import java.time.Duration;
import java.util.ArrayList;

public class PerfilPage extends PerfilRun {

    private By menuGerenciar = By.xpath("//i[@class='fa fa-gears menu-icon']");
    private By botaoGerenciarPerfis = By.xpath("//li/a[text()='Gerenciar Perfís Globais']");
    private By nomePlataforma = By.id("platform");
    private By nomeSo = By.id("os");
    private By nomeVersao = By.id("os_build");
    private By nomeDescricao = By.id("description");
    private By botaoAdicionarPerfil = By.xpath("//button[@class='btn btn-primary btn-white btn-round']");
    private By validarPlataformaCadastrado = By.xpath("//tr/td[text()='teste']");
    private By validarSoCadastrado = By.xpath("//tr/td[text()='Windows']");
    private By validarVersaoCadastrado = By.xpath("//tr/td[text()='2.14.1']");
    private By botaoExcluirPerfil = By.xpath("//button[text()='Apagar']");
    private By botaoConfirmaExclusaoPerfil = By.xpath("//input[@class='btn btn-primary btn-white btn-round']");
    private By validarPerfilExcluido = By.xpath("//tr/td[text()='Insert SQL']");


    public void clicarBotaoGerenciar() throws InterruptedException {

        getDriver().findElement(menuGerenciar).click();
    }

    public void clicarBotaoGerenciarProjetos() throws InterruptedException {

        getDriver().findElement(botaoGerenciarPerfis).click();
    }

    public void clicarBotaoApagarPerfis() throws InterruptedException {

        getDriver().findElement(botaoExcluirPerfil).click();
        Utils.esperarElementoVisivel(botaoConfirmaExclusaoPerfil, Duration.ofSeconds(20));
        getDriver().findElement(botaoConfirmaExclusaoPerfil).click();
    }

    public void clicarBotaoAdicionarPerfil() throws InterruptedException {

        getDriver().findElement(botaoAdicionarPerfil).click();
    }

    public void preencherPlataforma(String plataforma) throws InterruptedException {

        getDriver().findElement(nomePlataforma).sendKeys(plataforma);
    }

    public void preencherSO(String so) throws InterruptedException {

        getDriver().findElement(nomeSo).sendKeys(so);
    }

    public void preencherVersao(String versao) throws InterruptedException {

        getDriver().findElement(nomeVersao).sendKeys(versao);
    }

    public void preencherDescricao(String descricao) throws InterruptedException {

        getDriver().findElement(nomeDescricao).sendKeys(descricao);
    }

    public ArrayList<String> validaPerfilCriado() {

        ArrayList<String> list = new ArrayList<>();
        Utils.esperarElementoVisivel(validarPlataformaCadastrado, Duration.ofSeconds(20));
        String plataforma = String.valueOf(getDriver().findElement(validarPlataformaCadastrado).getText());
        list.add(plataforma);
        String so = String.valueOf(getDriver().findElement(validarSoCadastrado).getText());
        list.add(so);
        String versao = String.valueOf(getDriver().findElement(validarVersaoCadastrado).getText());
        list.add(versao);

        return list;
    }

    public void verificaTelaAdicionaPerfil() throws InterruptedException {

        Boolean visible = getDriver().findElement(By.xpath("//h4[@class='widget-title lighter']")).isDisplayed();
        Assert.assertEquals(true, visible);
    }

    public String validaPerfilExcluido() throws InterruptedException {

        try {
            Utils.esperarElementoVisivel(validarPerfilExcluido, Duration.ofSeconds(20));
            String sucesso = String.valueOf(getDriver().findElement(validarPerfilExcluido).getText());
            return sucesso;
        } catch (Exception e) {
            String retorno = String.valueOf(e.getMessage().subSequence(0, 68));
            return retorno;
        }
    }
}

