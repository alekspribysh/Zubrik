package com.controller.servlets;


import com.service.ValidateUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by alekspribysh on 9/21/15.
 */
@WebServlet("/registration")
public class ServletRegistration extends HttpServlet {

    ValidateUser valid = new ValidateUser();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect(req.getContextPath() + "/registrtion.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("loginParam");
        String password1 = req.getParameter("passwd");
        String password2 = req.getParameter("passwd2");
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");

        PrintWriter p = resp.getWriter();

        if (valid.loginValidation(name) && !valid.useExist(name) && valid.passwordnValidation(password1)
                && valid.passwordMatch(password1, password2) && !fullname.isEmpty() && !email.isEmpty()) {
            if (valid.validAddUser(name, password1, fullname, email)) {
                resp.sendRedirect(req.getContextPath() + "/welcome.html");
            }

        } else {
            if (!valid.loginValidation(name)) {
                p.println("Login should be at least 3 symbols");
            }
            if (valid.useExist(name)) {
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

    }

}
