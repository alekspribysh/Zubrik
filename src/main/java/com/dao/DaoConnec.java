package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by alekspribysh on 10/4/15.
 */
public class DaoConnec {

    Connection conn = null;

    public Connection getConn() {
        return conn;
    }


    public Connection connect() {
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "alex";
        String password = "aleksandr";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
