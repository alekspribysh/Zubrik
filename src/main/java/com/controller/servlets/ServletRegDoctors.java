package com.controller.servlets;

import com.service.ValidateDoctor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alekspribysh on 10/4/15.
 */
@WebServlet("/doctors")
public class ServletRegDoctors extends HttpServlet {
    ValidateDoctor valiD = new ValidateDoctor();
   // Map<String, String> messages = new HashMap<String, String>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect(req.getContextPath() + "doctors.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fullname = req.getParameter("fullname");
        String spec = req.getParameter("spec");
        String email = req.getParameter("email");
        PrintWriter p = resp.getWriter();

        valiD.createDoctors(fullname, spec, email);
       // messages.put("", "A new doctor was inserted successfully!");
        p.print("A new doctor was inserted successfully!");

    }
}
