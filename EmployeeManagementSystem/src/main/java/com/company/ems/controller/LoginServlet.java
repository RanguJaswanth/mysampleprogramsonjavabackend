package com.company.ems.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "admin123".equals(password)) {

            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            response.sendRedirect("dashboard.jsp");
        } else {
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}
