package com.dao;

import com.model.UserModel;

import java.sql.*;

/**
 * Created by alekspribysh on 9/14/15.
 */
public class UserDao {

    Connection conn = null;
    UserModel user = new UserModel();

    public Connection getConn() {
        return conn;
    }


    public void connect() throws SQLException {
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
    }

    public boolean createUser(UserModel userModel) throws SQLException {
        boolean val = false;

        String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, userModel.getUsername());
        statement.setString(2, userModel.getPassword());
        statement.setString(3, userModel.getFullName());
        statement.setString(4, userModel.getEmail());

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
            val = true;
        }

        return val;
    }

    public UserModel getUser(UserModel usermodel) throws SQLException {

        String sql = "SELECT * FROM Users where username = '" + usermodel.getUsername() + "' and password = '"
                + usermodel.getPassword() + "'";

        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

 //       int count = 0;

        while (result.next()) {
            user.setId(result.getString(1));
            user.setUsername(result.getString(2));
            user.setPassword(result.getString(3));
            user.setFullName(result.getString(4));
//            user.setEmail(result.getString(5));
//            String login = result.getString(2);
//            String pass = result.getString(3);
//            String fullname = result.getString(4);
//            String email = result.getString(5);
//
//            String output = "UserModel #%d: %s - %s - %s - %s";
//            System.out.println(String.format(output, ++count, login, pass, fullname, email));

        }

        return user;
    }

//    public updateUser(){}
//    public deleteUser(){}


}
