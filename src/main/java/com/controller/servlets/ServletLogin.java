package com.controller.servlets;

import com.service.UserService;
import com.service.ValidateUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by alekspribysh on 9/21/15.
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {

    ValidateUser valid = new ValidateUser();
    private String name;
    private String password1;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        name = req.getParameter("loginParam");
        password1 = req.getParameter("passwd");

        try {
            if (valid.validLoginPassword(name, password1)) {
                resp.sendRedirect(req.getContextPath() +  "/welcome.html");


            } else {
                resp.sendRedirect(req.getContextPath() + "/registration.jsp");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
