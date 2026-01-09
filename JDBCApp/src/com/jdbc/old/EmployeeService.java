package com.jdbc.old;

import java.util.*;

public class EmployeeService {

    EmployeeDAO dao = new EmployeeDAO();

    public void createEmployee(String name, double salary) {
        dao.insertEmployee(new Employee(name, salary));
    }

    public void updateSalary(int id, double salary) {
        dao.updateSalary(id, salary);
    }

    public void delete(int id) {
        dao.deleteEmployee(id);
    }

    public void showAll() {
        dao.getAllEmployees().forEach(System.out::println);
    }

    public void giveIncrement(int id, double amount) {
        dao.callRaiseSalary(id, amount);
    }

    public void bulkInsert(List<Employee> list) {
        dao.batchInsert(list);
    }

    public void transfer(int from, int to, double amount) {
        dao.transferSalary(from, to, amount);
    }
}
