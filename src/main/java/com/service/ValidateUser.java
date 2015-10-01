package com.service;


import com.model.UserModel;


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

    public boolean useExist(String name) {
        usermodel.setUsername(name);
        login = user.getUser(usermodel).getUsername();
        return (name.equals(login));
    }

    public boolean validLoginPassword(String name, String password) {

        usermodel.setUsername(name);
        usermodel.setPassword(password);
        login = user.getUser(usermodel).getUsername();
        pass = user.getUser(usermodel).getPassword();

        return (name.equals(login) && password.equals(pass));

    }


    public boolean validAddUser(String username, String pass, String fullName, String email) {

        usermodel.setUsername(username);
        usermodel.setPassword(pass);
        usermodel.setFullName(fullName);
        usermodel.setEmail(email);

        return user.createUser(usermodel);

    }
}
