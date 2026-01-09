package com.company.ems.controller;
import java.io.IOException;

import com.company.ems.dao.EmployeeDAO;
import com.company.ems.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        Employee emp = new Employee(name, email);
        EmployeeDAO dao = new EmployeeDAO();
        dao.saveEmployee(emp);

        response.sendRedirect("viewEmployees.jsp");
    }
}
