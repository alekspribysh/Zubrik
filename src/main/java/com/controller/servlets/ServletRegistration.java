package com.controller.servlets;

import com.service.ValidateUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by alekspribysh on 9/21/15.
 */
@WebServlet(urlPatterns = {"/login", })
public class ServletRegistration extends HttpServlet{

    ValidateUser valid = new ValidateUser();
    private String name;
    private String password1;
    private String password2;
    private HashMap<String, String> map = new HashMap<String, String>();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        name = req.getParameter("loginParam");
        password1 = req.getParameter("passwd");
        password2 = req.getParameter("passwd2");

        String servletPath = req.getServletPath();

        PrintWriter p = resp.getWriter();

        if (valid.loginValidation(name)) {
            if (valid.useExist(name, map)) {
                if (valid.passwordnValidation(password1)) {
                    if (valid.passwordMatch(password1, password2)) {
                        // map.put(name, password1);
                        // req.getServletContext().setAttribute(name, true);
                        resp.sendRedirect(req.getContextPath() + "/converter.html");

                    } else {
                        p.println("Entered passwords doesn't match");
                    }
                } else {
                    p.println("Password should contains at least 5 symbols and at least one diget");
                }
            } else {
                p.println("Entered username already exist. You have to use a different username ");
            }
        } else {
            p.println("Login should be at least 3 symbols");

        }

    }

}
