package com.dao;

import java.sql.*;

/**
 * Created by alekspribysh on 9/14/15.
 */
public class UserDao {

    String dbURL = "jdbc:mysql://localhost:3306/sampledb";
    String username = "alex";
    String password = "aleksandr";
    Connection conn = null;

    public Connection getConn() {
        return conn;
    }

    public void connect() throws SQLException {
        try {

            conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createUser() throws SQLException {

        String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "aleks");
        statement.setString(2, "aleksandr");
        statement.setString(3, "Aliaksandr Prybysh");
        statement.setString(4, "alekspribysh@gmail.com");

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
    }

    public ResultSet getUser(String sql) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        return result;

    }


//    public createConnection(){}

//    public getUser(){}
//    public updateUser(){}
//    public deleteUser(){}


}
