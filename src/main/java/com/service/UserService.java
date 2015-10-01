package com.service;

import com.dao.UserDao;
import com.model.UserModel;

import java.sql.SQLException;

/**
 * Created by alekspribysh on 9/14/15.
 */
public class UserService {

    UserDao userDao = new UserDao();

    public boolean createUser(UserModel usermodel) {


        if (userDao.getConn() == null) {
            userDao.connect();
        }

        return userDao.createUser(usermodel);


    }

    public UserModel getUser(UserModel usermodel) {


        if (userDao.getConn() == null) {
            userDao.connect();
        }

        return userDao.getUser(usermodel);


    }


//    public deleteUser(){}
//    public addData(){}


}
