package com.model;

/**
 * Created by alekspribysh on 9/14/15.
 */
public class UserModel {

    private String id;
    private String username;
    private String password;
    private String fullName;
    private String email;

    public UserModel(){};

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {

        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //    public userId(){}
//    public userName(){}
//    public email(){}
//    public password(){}
}
