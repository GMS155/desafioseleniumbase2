package support;



import java.sql.*;
import java.util.ArrayList;

public class DBUtils {

    private static String getStringConnection(){
        return "jdbc:mysql://"+
                "localhost" +"/"+"bugtracker";
    }

    public static ArrayList<String> getQueryResult(String query){
        ArrayList<String> arrayList = null;
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = null;
            connection = DriverManager.getConnection(getStringConnection(), "root", "");

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if(!rs.isBeforeFirst()){
                return null;
            }

            else{
                int numberOfColumns;
                ResultSetMetaData metadata=null;

                arrayList = new ArrayList<String>();
                metadata = rs.getMetaData();
                numberOfColumns = metadata.getColumnCount();

                while (rs.next()) {
                    int i = 1;
                    while(i <= numberOfColumns) {
                        arrayList.add(rs.getString(i++));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static ArrayList<String> executeQuery(String query){
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = null;
            connection = DriverManager.getConnection(getStringConnection(), "root", "");

            stmt = connection.createStatement();
            stmt.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
