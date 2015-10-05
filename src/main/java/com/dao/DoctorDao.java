package com.dao;

import com.model.DoctorModel;


import java.sql.*;

/**
 * Created by alekspribysh on 10/4/15.
 */
public class DoctorDao {

    DoctorModel doctor = new DoctorModel();
    DaoConnec conn = new DaoConnec();


    public boolean createDoctor(DoctorModel doctorModel) {
        boolean val = false;

        String sql = "INSERT INTO Doctors (fullname, specialization, email) VALUES (?, ?, ?)";

        try {

            PreparedStatement statement = conn.connect().prepareStatement(sql);

            statement.setString(1, doctorModel.getFullName());
            statement.setString(2, doctorModel.getSpecializationialization());
            statement.setString(3, doctorModel.getEmail());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new doctor was inserted successfully!");
                val = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return val;
    }

    public DoctorModel getDoctor(DoctorModel doctormodel) {

        String sql = "SELECT * FROM Users where fullname = '" + doctormodel.getFullName() + "' and password = '"
                + doctormodel.getFullName() + "'";

        try {
            Statement statement = conn.connect().createStatement();
            ResultSet result = statement.executeQuery(sql);

            //       int count = 0;

            while (result.next()) {
                doctor.setId(result.getString(1));
                doctor.setFullName(result.getString(4));
                doctor.setEmail(result.getString(5));
//            String login = result.getString(2);
//            String pass = result.getString(3);
//            String fullname = result.getString(4);
//            String email = result.getString(5);
//
//            String output = "UserModel #%d: %s - %s - %s - %s";
//            System.out.println(String.format(output, ++count, login, pass, fullname, email));

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }


        return doctor;
    }


}
