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
    String query = "select first_name, last_name, salary from employees";

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
    public void connectSpartanDB(){

    }

}
