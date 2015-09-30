package com.service;


import com.model.UserModel;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by alekspribysh on 9/19/15.
 */
public class ValidateUser {

    UserService user = new UserService();
    UserModel usermodel = new UserModel();
    private String login;
    private String pass;


    public boolean loginValidation(String name) {

        return (name.length() > 2);
    }

    public boolean passwordnValidation(String password) {

        return password.matches(".*\\d+.*") && password.length() > 4;

    }

    public boolean passwordMatch(String password, String paswword1) {

        return (password.equals(paswword1));
    }

    public boolean useExist(String name) throws SQLException {
        usermodel.setUsername(name);
        login = user.getUserByLogPas(usermodel).getUsername();
        return (name.equals(login));
    }

    public boolean validLoginPassword(String name, String password) throws SQLException {

        usermodel.setUsername(name);
        usermodel.setPassword(password);
        login = user.getUserByLogPas(usermodel).getUsername();
        pass = user.getUserByLogPas(usermodel).getPassword();

        return (name.equals(login) && password.equals(pass));

    }
}
