package jdbcTests;


import org.testng.annotations.Test;

import java.sql.*;

public class TestsWithOracle {


    }

/*
The information I need to be able to read the Table
1. How many rows I have? ----- resultset.next() - takes you to the row
2. How many columns I have?
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnCount = rsmd.getColumnCount();
3. I need to my column names
         String columnName = rsmd.getColumnName(1);
4. I need to read the data in that cell  resultset.getObject method to read the cell
 */




