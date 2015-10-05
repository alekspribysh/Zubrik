package com.service;

import com.model.DoctorModel;

/**
 * Created by alekspribysh on 10/4/15.
 */
public class ValidateDoctor {

    DoctorModel doctorModel = new DoctorModel();
    DoctorService doctorService = new DoctorService();


    public boolean createDoctors(String fullName, String spec, String email ){

        doctorModel.setFullName(fullName);
        doctorModel.setSpecialization(spec);
        doctorModel.setEmail(email);
        return doctorService.createDoctors(doctorModel);
    }


}
