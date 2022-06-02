package jdbcTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;

public class SpartanTests {
    // 3 important steps of using JDBC library
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    // List all employees name, lastName and salary from employees table
    String query = "select spartan_id, name, gender from spartans";

    @BeforeMethod
    public void connect() throws SQLException {
   // Connection String
        String dbUrl = "jdbc:oracle:thin:@54.234.179.88:1521:xe";
        String dbUserName = "SP";
        String dbPassword = "SP";
        connection = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
    }
    @AfterMethod
    public void close() throws SQLException {
        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void connectSpartanDB() throws SQLException {

        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnCount = rsmd.getColumnCount();
        while (resultSet.next()){
            String rowResult = "";
            for (int i = 1; i <= columnCount; i++) {
                rowResult += resultSet.getString(i)+" ";
           }
            System.out.println(rowResult);
        }

    }
    /*
    I need to handle column information in a more dynamic way
    ResultSetMetaData  ----> how many columns and column names
     */


}
