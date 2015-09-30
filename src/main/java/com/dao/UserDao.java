package com.dao;

import com.model.UserModel;

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

    public UserModel getUser(UserModel usermodel) throws SQLException {

        UserModel user = new UserModel();

        String sql = "SELECT * FROM Users where username = '" + usermodel.getUsername() + "' and password = '"
                + usermodel.getPassword() + "'";

        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);


        while (result.next()) {
            user.setId(result.getString("user_id"));
            user.setUsername(result.getString("username"));
            user.setPassword(result.getString(3));

//            String output = "UserModel #%d: %s - %s - %s - %s";
//            System.out.println(String.format(output, ++count, login, pass, fullname, email));

        }

        return user;
    }

//    public updateUser(){}
//    public deleteUser(){}


}
