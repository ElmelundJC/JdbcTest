import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;

public class JDBCExample {
    public static void main(String[] args) throws SQLException, IOException {
        try {

            //Create connection
            DatabaseConnectionManager connectionManager = new DatabaseConnectionManager();
            Connection forbindelseTilMySQL = connectionManager.getDatabaseConnection();

            Employee emp = new Employee();

            //System.out.println(Arrays.asList(emp.getAllEmployees(forbindelseTilMySQL.createStatement())));

            HashMap<String, Object> map = new HashMap<String, Object>();
            map = emp.getAllEmployees(forbindelseTilMySQL.createStatement());
            for (Object key : map.values()) {
                System.out.println(key);
            }

/*
            //Create Statement
            Statement statement = forbindelseTilMySQL.createStatement();


            //Execute Query
            ResultSet rs = statement.executeQuery("select * from emp");
            ResultSetMetaData rsmd = rs.getMetaData();
*/
/*
            Statement sqlConnection = forbindelseTilMySQL.createStatement();

            ResultSet query1 = sqlConnection.executeQuery("select * from emp");
            ResultSetMetaData meta = query1.getMetaData();
            int getColumnCount = meta.getColumnCount();
            String queryResult = "";
            for (int i = 1; i < getColumnCount; i++) {
                queryResult += meta.getColumnName(i) + " ";
            }
            queryResult += "\n";
            while (query1.next()) {

                for (int i = 1; i < getColumnCount; i++) {
                    queryResult += query1.getString(i) + " ";
                }
                queryResult += "\n";
            }
            System.out.println(queryResult);
*/

/*
            //Print the set
            while (rs.next()) {
               System.out.println(rs.getString("emp"));

            }
            */

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
