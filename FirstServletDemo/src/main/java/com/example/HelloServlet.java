package com.example;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response type
        response.setContentType("text/html");

        // Get output writer
        PrintWriter out = response.getWriter();

        // Write HTML response
        out.println("<html><body>");
        out.println("<h2>Hello, Welcome to Servlets!</h2>");
        out.println("<p>This is your first servlet running successfully 🎉</p>");
        out.println("</body></html>");
    }
}
