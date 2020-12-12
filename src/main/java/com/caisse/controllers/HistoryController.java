package com.caisse.controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.caisse.App;

public class HistoryController {

    public static void all() throws SQLException {
        String sql = "SELECT * FROM orders";
        Statement statement = App.conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            String order = result.getString("orders");
            Timestamp time = result.getTimestamp("created_at");
            Date date = new Date(time.getTime());

            System.out.println("Le : " + date);
            System.out.println(order);
        }
    }
}
