package com.controller.servlets;

import com.service.ValidateUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by alekspribysh on 9/21/15.
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {

    Map<String, String> messages = new HashMap<String, String>();
    ValidateUser valid = new ValidateUser();
    private String name;
    private String password;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("messageMap", messages);

        name = req.getParameter("loginParam");
        password = req.getParameter("passwd");

        try {

//            if (name.isEmpty() || password.isEmpty()){
//                messages.put("fieldIsEmpty", "Fields cannot not be empty");
//                req.getRequestDispatcher("login.jsp").forward(req, resp);
//
//            }


            if (valid.validLoginPassword(name, password)) {
                resp.sendRedirect(req.getContextPath() + "/welcome.html");


            } else {
                resp.sendRedirect(req.getContextPath() + "/registration.jsp");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
