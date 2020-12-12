package com.caisse;

import java.sql.Connection;
import java.sql.SQLException;

public class App 
{
    public static Connection conn = null;
    public static void main( String[] args ) throws SQLException
    {
        // Init the db_connection object
        DB_Connection db_Connection = new DB_Connection("root", "", "test1");
        //Connection conn = null;

        try {
            
            conn = db_Connection.getConnection();
            // Start the command reader
            CommandHandler.start();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}
