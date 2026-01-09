package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.model.Employee;
import com.demo.util.HibernateUtil;

public class EmployeeDAO {

    // CREATE
    public void saveEmployee(Employee emp) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(emp);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // READ (By ID)
    public Employee getEmployee(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }

    // READ ALL (HQL)
    public List<Employee> getAllEmployees() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Employee", Employee.class).list();
        }
    }

    // UPDATE
    public void updateEmployee(Employee emp) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(emp);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteEmployee(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee emp = session.get(Employee.class, id);
            tx = session.beginTransaction();
            session.delete(emp);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
