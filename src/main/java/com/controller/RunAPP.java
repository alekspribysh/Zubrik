package com.controller;

import com.service.UserService;

import java.sql.SQLException;

/**
 * Created by alekspribysh on 9/14/15.
 */
public class RunAPP {
    public static void main(String[] args) throws SQLException {
        UserService run = new UserService();
        //run.createUser();
        run.getUser();
    }
}
