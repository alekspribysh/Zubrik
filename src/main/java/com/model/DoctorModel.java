package com.model;

/**
 * Created by alekspribysh on 10/4/15.
 */
public class DoctorModel {

    private String id;
    private String specialization;
    private String email;
    private String fullName;

    public DoctorModel(){};

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecializationialization() {

        return specialization;
    }

    public void setSpecialization(String spetialization) {
        this.specialization = spetialization;
    }
}
