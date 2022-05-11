package dbsteps;


import support.DBUtils;
import support.Utils;

public class ProjetosDBSteps {

    private static String queriesPath = "src/test/java/queries/Projects/";

    public void deletaProjetos() {
        String query = Utils.getFileContent(queriesPath + "deletarProjetos.sql");
        DBUtils.executeQuery(query);
    }

    public void cadastrarProjetos() {
        String query = Utils.getFileContent(queriesPath + "cadastrarProjetos.sql");
        DBUtils.executeQuery(query);
    }
}
