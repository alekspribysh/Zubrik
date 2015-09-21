package com.service;

import com.dao.UserDao;

import java.sql.SQLException;

/**
 * Created by alekspribysh on 9/14/15.
 */
public class UserService {

    UserDao userDao = new UserDao();

    public void createUser() throws SQLException {
        if (userDao.getConn() == null) {
            userDao.connect();
            userDao.createUser();
        } else {
            userDao.createUser();
        }


    }

    public void getUser() throws SQLException {
        if (userDao.getConn() == null){
            userDao.connect();
            userDao.getUser();
        }
        else {
            userDao.getUser();
        }
    }
//    public getUser(){}
//    public deleteUser(){}
//    public addData(){}


}
