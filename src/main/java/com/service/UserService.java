package com.service;

import com.dao.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alekspribysh on 9/14/15.
 */
public class UserService {

    UserDao userDao = new UserDao();
    ResultSet result;


    public void createUser() throws SQLException {
        if (userDao.getConn() == null) {
            userDao.connect();
            userDao.createUser();
        } else {
            userDao.createUser();
        }


    }

    public ResultSet getUser() throws SQLException {

        if (userDao.getConn() == null){
            userDao.connect();
            userDao.getUser();


        }
        else {
            userDao.getUser();


        }
        return result;

    }
//    public getUser(){}
//    public deleteUser(){}
//    public addData(){}


}
