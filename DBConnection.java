// Definition of class DBConnection - Establish connection to the database
// Author: Siomara Pantarotto
// File : DBConnection.java
// Date : June,8,2000

import java.sql.*;

public class DBConnection
{
    private Connection conn;
    private Statement stmt;
    private String driver = "oracle.jdbc.driver.OracleDriver";

    // Parameters for Local Oracle8i Server
    private String url = "jdbc:oracle:thin:@PROKIDS:1521:ORCL";
    private String user = "INTERNAL";
    private String password = "oracle";

    /////////////////////////////////////////////////////////////////////////
    // Constructor - Establish connection to the database
    //
    public DBConnection()
    {
        try {
            Class.forName(driver);
        }
        catch(Exception e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
        }
        catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Return connection object
    //
    public Connection getConnection() {
        return conn;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Return statement object
    //
    public Statement getStatement() {
        return stmt;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Close DB connection
    //
    public void closeConnection() {
        try {
            conn.close();
        }
        catch(Exception e) {
            System.err.print("Unable to disconect");
            e.printStackTrace();
        }
    }

    /////////////////////////////////////////////////////////////////////////
    // Close statement object
    //
    public void closeStatement() {
        try {
            stmt.close();
        }
        catch(Exception e) {
            System.err.print("Unable to close statement");
            e.printStackTrace();
        }
    }   
}
