package com.service;

import com.dao.UserDao;


import java.sql.ResultSet;
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

    public ResultSet getUser(String sql) throws SQLException {
        ResultSet result;
        if (userDao.getConn() == null) {
            userDao.connect();
            result = userDao.getUser(sql);
        } else {
            result = userDao.getUser(sql);


        }
        return result;



    }
//    public getUser(){}
//    public deleteUser(){}
//    public addData(){}


}
