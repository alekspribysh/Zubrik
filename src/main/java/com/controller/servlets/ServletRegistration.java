package com.controller.servlets;

import com.service.ValidateUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by alekspribysh on 9/21/15.
 */
@WebServlet("/registration")
public class ServletRegistration extends HttpServlet {

    ValidateUser valid = new ValidateUser();
    private String name;
    private String password1;
    private String password2;
    private String fullname;
    private String email;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        name = req.getParameter("loginParam");
        password1 = req.getParameter("passwd");
        password2 = req.getParameter("passwd2");
        fullname = req.getParameter("fullname");
        email = req.getParameter("email");

        PrintWriter p = resp.getWriter();


        try {
            if (valid.loginValidation(name) && valid.useExist(name) && valid.passwordnValidation(password1)
                    && valid.passwordMatch(password1, password2) && !fullname.isEmpty() && !email.isEmpty()) {
                resp.sendRedirect(req.getContextPath() + "/welcome.html");

            } else {
                if (!valid.loginValidation(name)) {
                    p.println("Login should be at least 3 symbols");
                }
                if (!valid.useExist(name)) {
                    p.println("Entered username already exist. You have to use a different username ");
                }
                if (!valid.passwordnValidation(password1)) {
                    p.println("Password should contains at least 5 symbols and at least one diget");
                }
                if (!valid.passwordMatch(password1, password2)) {
                    p.println("Entered passwords doesn't match");
                }

                if (fullname.isEmpty()) {
                    p.println("Field full name can not be empty");
                }
                if (email.isEmpty()) {
                    p.println("Field email can not be empty");
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
