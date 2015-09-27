package com.service;

import com.dao.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by alekspribysh on 9/19/15.
 */
public class ValidateUser {
    //UserDao user = new UserDao();

    UserService user = new UserService();
    private String login = null;
    private String pass = null;
    private ResultSet result;


    private boolean val;

    public boolean loginValidation(String name) {
        if (name.length() > 2) {
            val = true;
        } else {
            val = false;
        }
        return val;
    }

    public boolean passwordnValidation(String password) {
        if (password.matches(".*\\d+.*") && password.length() > 4) {
            val = true;
        } else {
            val = false;
        }
        return val;

    }

    public boolean passwordMatch(String password, String paswword1) {
        if (password.equals(paswword1)) {
            val = true;
        } else {
            val = false;
        }
        return val;
    }

    public boolean useExist(String name, HashMap map) {
        if (map.containsKey(name)) {
            val = false;
        } else {
            val = true;
        }
        return val;
    }

    public boolean validLoginPassword(String name, String password) throws SQLException {

        String sql = "SELECT * FROM Users where username = '" + name + "' and password = '" + password + "'";
        result = user.getUser(sql);

        int count = 0;

        while (result.next()) {
            login = result.getString(2);
            pass = result.getString(3);
            String fullname = result.getString("fullname");
            String email = result.getString("email");
            String output = "User #%d: %s - %s - %s - %s";
            System.out.println(String.format(output, ++count, login, pass, fullname, email));

        }
        // System.out.println(login + " " + "krutoi");

        if (name.equals(login) && password.equals(pass))

        {
            val = true;
        } else {
            val = false;
        }

        return val;

    }
}
