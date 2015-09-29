package com.service;

import com.dao.UserDao;
import com.model.UserModel;
import java.sql.SQLException;

/**
 * Created by alekspribysh on 9/14/15.
 */
public class UserService {

    UserDao userDao = new UserDao();


    public void createUser() throws SQLException {

        if (userDao.getConn() == null) {
            userDao.connect();
        }

        userDao.createUser();

    }

    public UserModel getUser(UserModel usermodel) throws SQLException {

        if (userDao.getConn() == null) {
            userDao.connect();
        }

        return userDao.getUser(usermodel);



    }
//    public getUser(){}
//    public deleteUser(){}
//    public addData(){}


}
