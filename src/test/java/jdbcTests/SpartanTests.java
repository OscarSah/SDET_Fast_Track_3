package jdbcTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.mustache.Value;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
/*
The best way of representing DB info into JAVA is to store them into List<Map<String,Object>>
 */

    @Test
    public void createDBListofMap() throws SQLException {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();

        // create an empty List to store DB info
        List<Map<String,Object>> queryResult = new ArrayList<>();

        while (resultSet.next()){
            // each row coming from DataBase will be stored in a Map<String,Object>
            Map<String,Object> eachRow = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
            // Key is the column name: resultsetmetadata.getColumnName method
            // Value is the cell Data : resultSet.getObject(index)
                eachRow.put(resultSetMetaData.getColumnName(i) , resultSet.getObject(i));
          }
/*
Four Methods that allows us to read and manipulate the DataBase information, NEVER FORGET
1. int columnCount = resultSetMetaData.getColumnCount();  --- I need to know how many columns my query will return
2. resultSet.next() = row information
3. resultSetMetaData.getColumnName(i)  ---> each row Map Key information
4.  resultSet.getObject(i) -----> each row Map Value information
 */
        }

    }

}
