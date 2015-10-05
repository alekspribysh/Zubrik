package com.service;

import com.dao.DaoConnec;
import com.dao.UserDao;
import com.model.UserModel;


/**
 * Created by alekspribysh on 9/14/15.
 */
public class UserService {

    UserDao userDao = new UserDao();
    DaoConnec conn = new DaoConnec();

    public boolean createUser(UserModel usermodel) {


        if (conn.getConn() == null) {
            conn.connect();
        }

        return userDao.createUser(usermodel);


    }

    public UserModel getUser(UserModel usermodel) {


        if (conn.getConn() == null) {
            conn.connect();
        }

        return userDao.getUser(usermodel);


    }


//    public deleteUser(){}
//    public addData(){}


}
