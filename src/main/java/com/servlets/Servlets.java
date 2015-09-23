package com.servlets;

import com.validators.ValidateUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by alekspribysh on 9/19/15.
 */
@WebServlet(urlPatterns = {"/login", "/registration"})
public class Servlets extends HttpServlet {

    ValidateUser valid = new ValidateUser();
    private String name;
    private String password1;
    private String password2;
    private HashMap<String, String> map = new HashMap<String, String>();


    @Override
    public void init() throws ServletException {
        map.put("aleks", "123");
        super.init();
    }

//
//    @Override
//
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String servletPath = req.getServletPath();
//
//        if (servletPath.equals("/login")) {
//            resp.sendRedirect(req.getContextPath() + "/login.html");
//        }
//
//        if (servletPath.equals("/registration")) {
//            resp.sendRedirect(req.getContextPath() + "/registration.html");
//        }
//    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        name = req.getParameter("loginParam");
        password1 = req.getParameter("passwd");
        password2 = req.getParameter("passwd2");

        String servletPath = req.getServletPath();



        if (servletPath.equals("/login")) {
            validLogin(req, resp);


        }
        if (servletPath.equals("/registration")) {
            validationReg(req, resp);

        }
    }



    private void validLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (valid.validLoginPassword(name, password1, map)) {
            //req.getServletContext().setAttribute(name, true);
            resp.sendRedirect(req.getContextPath() +  "");




        } else {
            resp.sendRedirect(req.getContextPath() + "/registration.jsp");


        }

    }

    private void validationReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter p = resp.getWriter();

        if (valid.loginValidation(name)) {
            if (valid.useExist(name, map)) {
                if (valid.passwordnValidation(password1)) {
                    if (valid.passwordMatch(password1, password2)) {

                        map.put(name, password1);
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
