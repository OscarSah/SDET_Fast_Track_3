package jdbcTests;


import org.testng.annotations.Test;

import java.sql.*;

public class TestsWithOracle {
// 54.234.179.88
//  18.233.164.111
// 100.26.60.119
    @Test
    public void connectionTest() throws SQLException {
        // 3 important steps of using JDBC library
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        // Connection String
        String dbUrl = "jdbc:oracle:thin:@54.234.179.88:1521:xe";
        String dbUserName = "hr";
        String dbPassword = "hr";

        // List all employees name, lastName and salary from employees table
        String query = "select first_name, last_name, salary from employees";

        connection = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);

        // Task, challange : to be able access row and columns of resultset table
      //  resultSet.next(); ---> takes the pointer to next row
      //  resultSet.getObject(index of column)  -----> the data in that cell
        while (resultSet.next()){
            System.out.println(resultSet.getObject(1)+"| |"+resultSet.getObject(2)+"| |"+resultSet.getObject(3));
        }

        resultSet.close();
        statement.close();
        connection.close();

    }

    }






