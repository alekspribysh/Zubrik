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
        statement.setString(1, "bill");
        statement.setString(2, "secretpass");
        statement.setString(3, "Bill Gates");
        statement.setString(4, "bill.gates@microsoft.com");

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
    }

    public ResultSet getUser() throws SQLException {
        String sql = "SELECT * FROM Users";


        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        int count = 0;

        while (result.next()){
            String name = result.getString(2);
            String pass = result.getString(3);
            String fullname = result.getString("fullname");
            String email = result.getString("email");

            String output = "User #%d: %s - %s - %s - %s";
            System.out.println(String.format(output, ++count, name, pass, fullname, email));

        }

        return result;

    }





//    public createConnection(){}

//    public getUser(){}
//    public updateUser(){}
//    public deleteUser(){}


}
