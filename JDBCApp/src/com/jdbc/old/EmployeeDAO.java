package com.jdbc.old;

import java.sql.*;
import java.util.*;

public class EmployeeDAO {

    // INSERT - PreparedStatement
    public void insertEmployee(Employee emp) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            String sql = "INSERT INTO employee(name, salary) VALUES (?, ?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, emp.getName());
            ps.setDouble(2, emp.getSalary());

            int rows = ps.executeUpdate();
            System.out.println(rows + " Employee Inserted");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }

    // READ - Statement
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                Employee e = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("salary")
                );
                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
        return list;
    }

    // UPDATE - PreparedStatement
    public void updateSalary(int id, double newSalary) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            String sql = "UPDATE employee SET salary=? WHERE id=?";
            ps = con.prepareStatement(sql);

            ps.setDouble(1, newSalary);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            System.out.println(rows + " Employee Updated");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }

    // DELETE - PreparedStatement
    public void deleteEmployee(int id) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            String sql = "DELETE FROM employee WHERE id=?";
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.println(rows + " Employee Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }

    // CALLABLE STATEMENT
    public void callRaiseSalary(int empId, double increment) {
        Connection con = null;
        CallableStatement cs = null;

        try {
            con = DBConnection.getConnection();
            cs = con.prepareCall("CALL raise_salary(?, ?)");

            cs.setInt(1, empId);
            cs.setDouble(2, increment);

            cs.execute();
            System.out.println("Salary Raised!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (cs != null) cs.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }

    // BATCH INSERT
    public void batchInsert(List<Employee> list) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            String sql = "INSERT INTO employee(name, salary) VALUES (?, ?)";
            ps = con.prepareStatement(sql);

            for (Employee e : list) {
                ps.setString(1, e.getName());
                ps.setDouble(2, e.getSalary());
                ps.addBatch();
            }

            int[] count = ps.executeBatch();
            System.out.println(count.length + " Employees Batch Inserted");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }

    // TRANSACTION
    public void transferSalary(int fromId, int toId, double amount) {
        Connection con = null;
        PreparedStatement deduct = null;
        PreparedStatement add = null;

        try {
            con = DBConnection.getConnection();
            con.setAutoCommit(false);

            deduct = con.prepareStatement("UPDATE employee SET salary = salary - ? WHERE id=?");
            deduct.setDouble(1, amount);
            deduct.setInt(2, fromId);
            deduct.executeUpdate();

            add = con.prepareStatement("UPDATE employee SET salary = salary + ? WHERE id=?");
            add.setDouble(1, amount);
            add.setInt(2, toId);
            add.executeUpdate();

            con.commit();
            System.out.println("Transaction Successful!");

        } catch (Exception e) {
            try { if (con != null) con.rollback(); } catch (Exception ex) {}
            System.out.println("Transaction Rolled Back");
            e.printStackTrace();

        } finally {
            try { if (deduct != null) deduct.close(); } catch (Exception e) {}
            try { if (add != null) add.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}
