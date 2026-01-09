package com.company.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.company.ems.model.Employee;

public class EmployeeDAO {

    public void saveEmployee(Employee emp) {

        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps =
              con.prepareStatement(
                "INSERT INTO employee(name,email) VALUES(?,?)"
              );

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
