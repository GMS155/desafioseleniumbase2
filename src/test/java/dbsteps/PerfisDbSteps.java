package dbsteps;

import support.DBUtils;
import support.Utils;

public class PerfisDbSteps {

    private static String queriesPath = "src/test/java/queries/Perfis/";

    public void deletaProjetos() {
        String query = Utils.getFileContent(queriesPath + "deletaPerfil.sql");
        DBUtils.executeQuery(query);
    }

    public void cadastraPerfis() {
        String query = Utils.getFileContent(queriesPath + "cadastrarPerfil.sql");
        DBUtils.executeQuery(query);
    }
}
