package dbsteps;


import support.DBUtils;
import support.Utils;

public class UsuariosDBSteps {

    private static String queriesPath = "src/test/java/queries/Users/";

    public void excluiUsuarios(){
        String query = Utils.getFileContent(queriesPath + "excluiUsuarios.sql");
        DBUtils.executeQuery(query);
    }

    public void insereUsuarios(){
        String query = Utils.getFileContent(queriesPath + "adicionaUsuarios.sql");
        DBUtils.executeQuery(query);
    }







}
