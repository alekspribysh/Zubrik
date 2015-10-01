package com.controller.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alekspribysh on 9/22/15.
 */
@WebServlet("/index")
public class ServletRouter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String servletPath = req.getServletPath();

        if (servletPath.equals("/login")) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }

        if (servletPath.equals("/registration")) {
            resp.sendRedirect(req.getContextPath() + "/registration.jsp");
        }


    }
}
