package com.jdbc.old;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        service.createEmployee("Ravi", 50000);
        service.createEmployee("Sita", 60000);

        service.showAll();

        service.updateSalary(1, 75000);

        service.delete(2);

        service.giveIncrement(1, 5000);

        List<Employee> batch = Arrays.asList(
            new Employee("Hari", 40000),
            new Employee("Kiran", 55000)
        );
        service.bulkInsert(batch);

        service.transfer(1, 3, 3000);

        service.showAll();
    }
}
