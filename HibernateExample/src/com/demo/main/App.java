package com.demo.main;

import com.demo.dao.EmployeeDAO;
import com.demo.model.Employee;

public class App {

    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();

        // 1. INSERT
        Employee e1 = new Employee("Ravi", "IoT", 40000);
        dao.saveEmployee(e1);
        Employee e2 = new Employee("Rav", "IaT", 50000);
        dao.saveEmployee(e1);
        Employee e3 = new Employee("Rai", "IiT", 30000);
        dao.saveEmployee(e1);
        // 2. SELECT BY ID
        Employee emp = dao.getEmployee(1);
        System.out.println("Fetched: " + emp);

        // 3. UPDATE
        emp.setSalary(70000);
        dao.updateEmployee(emp);

        // 4. DELETE
        dao.deleteEmployee(1);

        // 5. LIST ALL
        dao.getAllEmployees().forEach(System.out::println);
    }
}
