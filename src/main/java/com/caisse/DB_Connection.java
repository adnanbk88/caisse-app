package com.caisse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
    
    private String username;
    private String password;
    private String database;

    public DB_Connection(String username, String password, String database) {
        this.username = username;
        this.password = password;
        this.database = database;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/" + this.database, this.username, this.password);
    } 
    
}
