package com.service;


import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by alekspribysh on 9/19/15.
 */
public class ValidateUser {

    UserService user = new UserService();
    private String login = null;
    private String pass = null;



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

//        String sql = "SELECT * FROM Users where username = '" + name + "' and password = '" + password + "'";
          user.getUser();


        if (name.equals(login) && password.equals(pass))

        {
            val = true;
        } else {
            val = false;
        }

        return val;

    }
}
