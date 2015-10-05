package com.service;

import com.dao.DaoConnec;
import com.dao.DoctorDao;
import com.model.DoctorModel;

/**
 * Created by alekspribysh on 9/28/15.
 */
public class DoctorService {

    DoctorDao doctorDao = new DoctorDao();
    DaoConnec coon  = new DaoConnec();

    public boolean createDoctors (DoctorModel doctor){

        if(coon.getConn() == null){
            coon.getConn();
        }

        return doctorDao.createDoctor(doctor);
    }
}
